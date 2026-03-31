package com.fatec.cps.sp.gov.br.appmultitela;

import static com.fatec.cps.sp.gov.br.appmultitela.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ImcActivity extends AppCompatActivity {

    EditText etNome, etPeso, etAltura;
    Button btnCalcular, btnLimpar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.etNome);
        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(v -> calcularIMC());

        btnLimpar.setOnClickListener(v -> {
            etNome.setText("");
            etPeso.setText("");
            etAltura.setText("");
        });
    }

    private void calcularIMC() {

        String nome = etNome.getText().toString();
        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());

        double imc = peso / (altura * altura);

        Intent intent = new Intent(ImcActivity.this, ResultadoActivity.class);

        intent.putExtra("nome", nome);
        intent.putExtra("peso", peso);
        intent.putExtra("altura", altura);
        intent.putExtra("imc", imc);

        startActivity(intent);
    }

}