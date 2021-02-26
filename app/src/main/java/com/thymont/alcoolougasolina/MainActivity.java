package com.thymont.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText cxPrecoGasolina;
    TextInputEditText cxPrecoAlcool;
    TextView txtResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cxPrecoAlcool = findViewById(R.id.cxPrecoAlcool);
        cxPrecoGasolina = findViewById(R.id.cxPrecoGasolina);
        txtResposta = findViewById(R.id.txtResposta);
    }

    public void decidir(View view) {
        Double alcool;

        if (cxPrecoAlcool.getText().toString().trim().isEmpty()) {
            alcool = 0.0;
        } else {
            alcool = Double.parseDouble(cxPrecoAlcool.getText().toString());
        }

        Double gasolina;
        if (cxPrecoAlcool.getText().toString().trim().isEmpty()) {
            gasolina = 0.0;
        } else {
            gasolina = Double.parseDouble(cxPrecoGasolina.getText().toString());
        }
        //Verificar a relação Alcool e gasolinha (taxa de rendimento, 70%)
        if (gasolina == 0.0 && alcool == 0.0){
            txtResposta.setText("Por favor, insira um preço válido");
        } else if (gasolina * 0.7 > alcool) {
            txtResposta.setText("Melhor utilizar Álcool");
        } else {
            txtResposta.setText("Melhor utilizar Gasolina");
        }
    }

    public void limpar(View view) {
        cxPrecoAlcool.setText("");
        cxPrecoGasolina.setText("");
        txtResposta.setText("");
    }
}