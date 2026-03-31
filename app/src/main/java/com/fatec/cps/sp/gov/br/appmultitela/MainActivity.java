package com.fatec.cps.sp.gov.br.appmultitela;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Edge-to-edge (opcional)
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        // Ajuste de padding para status/navigation bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets; // Lambda termina aqui
        });

        // Configuração dos botões (FORA da lambda)
        Button btnMega = findViewById(R.id.btnMega);
        Button btnImc = findViewById(R.id.btnImc);
        Button btnJokenpo = findViewById(R.id.btnJokenpo);
        Button btnFelicidade = findViewById(R.id.btnFelicidade);

        btnMega.setOnClickListener(v ->
                startActivity(new Intent(this, MegaSenaActivity.class)));

        btnImc.setOnClickListener(v ->
                startActivity(new Intent(this, ImcActivity.class)));

        btnJokenpo.setOnClickListener(v ->
                startActivity(new Intent(this, JokenpoActivity.class)));

        btnFelicidade.setOnClickListener(v ->
                startActivity(new Intent(this, QuestionarioActivity.class)));
    }
}