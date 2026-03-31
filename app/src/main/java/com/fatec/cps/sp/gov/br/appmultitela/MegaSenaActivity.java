package com.fatec.cps.sp.gov.br.appmultitela;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

public class MegaSenaActivity extends AppCompatActivity {

    private ArrayList<Integer> numerosSorteados;
    private int indiceAtual = 0;
    private TextView[] campos;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campos = new TextView[] {
                findViewById(R.id.num1),
                findViewById(R.id.num2),
                findViewById(R.id.num3),
                findViewById(R.id.num4),
                findViewById(R.id.num5),
                findViewById(R.id.num6)
        };

        Button btnSorteio = findViewById(R.id.btnSorteio);
        Button btnRecomecar = findViewById(R.id.btnRecomecar);

        numerosSorteados = gerarNumerosMegaSena();

        btnSorteio.setOnClickListener(v -> {

            if (indiceAtual < 6) {
                campos[indiceAtual].setText(
                        String.format("%02d", numerosSorteados.get(indiceAtual))
                );
                indiceAtual++;
            }
        });

        btnRecomecar.setOnClickListener(v -> {

            indiceAtual = 0;

            for (TextView campo : campos) {
                campo.setText("_ _");
            }

            numerosSorteados = gerarNumerosMegaSena();
        });
    }

    private ArrayList<Integer> gerarNumerosMegaSena() {

        Random random = new Random();
        Set<Integer> numeros = new HashSet<>();

        while (numeros.size() < 6) {
            int numero = random.nextInt(60) + 1;
            numeros.add(numero);
        }

        ArrayList<Integer> lista = new ArrayList<>(numeros);
        Collections.sort(lista);
        return lista;
    }
}