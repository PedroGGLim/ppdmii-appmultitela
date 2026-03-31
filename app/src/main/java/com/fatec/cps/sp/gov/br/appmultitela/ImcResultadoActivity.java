package com.fatec.cps.sp.gov.br.appmultitela;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.*;

import com.fatec.cps.sp.gov.br.appmultitela.R;

public class ImcResultadoActivity extends AppCompatActivity {

    TextView tvResultado, tvClassificacao, tvMensagem;
    Button btnVoltar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.tvResultado);
        tvClassificacao = findViewById(R.id.tvClassificacao);
        tvMensagem = findViewById(R.id.tvMensagem);
        btnVoltar = findViewById(R.id.btnVoltar);

        String nome = getIntent().getStringExtra("nome");
        double peso = getIntent().getDoubleExtra("peso",0);
        double altura = getIntent().getDoubleExtra("altura",0);
        double imc = getIntent().getDoubleExtra("imc",0);

        String classificacao;
        String mensagem;

        if(imc < 18.5){
            classificacao = "Abaixo do Peso";
            mensagem = "Vamos melhorar sua alimentação!";
        }
        else if(imc < 24.9){
            classificacao = "Peso Normal";
            mensagem = "Parabéns! Continue assim!";
        }
        else if(imc < 29.9){
            classificacao = "Sobrepeso";
            mensagem = "Que tal iniciar algumas atividades físicas?";
        }
        else{
            classificacao = "Obesidade";
            mensagem = "Procure orientação de saúde!";
        }

        tvResultado.setText(
                "Nome: " + nome +
                        "\nPeso: " + peso +
                        "\nAltura: " + altura +
                        "\nIMC: " + String.format("%.2f", imc));

        tvClassificacao.setText("Classificação: " + classificacao);
        tvMensagem.setText(mensagem);

        btnVoltar.setOnClickListener(v -> finish());
    }
}