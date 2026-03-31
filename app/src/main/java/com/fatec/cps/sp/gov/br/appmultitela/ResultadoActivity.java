package com.fatec.cps.sp.gov.br.appmultitela;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {

    TextView txtPontuacao;
    TextView txtClassificacao;
    TextView txtDescricao;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        // Referências
        txtPontuacao = findViewById(R.id.txtPontuacao);
        txtClassificacao = findViewById(R.id.txtClassificacao);
        txtDescricao = findViewById(R.id.txtDescricao);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Receber valor da outra tela
        double felicidade = getIntent().getDoubleExtra("felicidade", 0);

        // Classificação
        String classificacao;
        String descricao;

        if (felicidade <= 2.0) {
            classificacao = "Muito Baixa";
            descricao = "Alerta crítico";
        } else if (felicidade <= 4.0) {
            classificacao = "Baixa";
            descricao = "Equilíbrio precário";
        } else if (felicidade <= 6.0) {
            classificacao = "Moderada";
            descricao = "Estado neutro";
        } else if (felicidade <= 8.0) {
            classificacao = "Alta";
            descricao = "Bom equilíbrio";
        } else {
            classificacao = "Plena";
            descricao = "Estado ideal";
        }

        // Exibir na tela
        txtPontuacao.setText("Pontuação: " + String.format("%.1f", felicidade));
        txtClassificacao.setText("Classificação: " + classificacao);
        txtDescricao.setText(descricao);

        // Botão voltar
        btnVoltar.setOnClickListener(v -> finish());
    }
}