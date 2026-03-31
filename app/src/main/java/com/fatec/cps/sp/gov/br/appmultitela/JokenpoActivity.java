package com.fatec.cps.sp.gov.br.appmultitela;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class JokenpoActivity extends AppCompatActivity {

    ImageView imgResultado;
    ImageView imgPedra;
    ImageView imgPapel;
    ImageView imgTesoura;

    int pontosUsuario = 0;
    int pontosComputador = 0;

    TextView txtPlacarUsuario;
    TextView txtPlacarComputador;
    TextView txtEscolha;

    Button btnReiniciar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Referências dos componentes
        imgResultado = findViewById(R.id.imgJogada);
        imgPedra = findViewById(R.id.imgPedra);
        imgPapel = findViewById(R.id.imgPapel);
        imgTesoura = findViewById(R.id.imgTesoura);

        txtPlacarUsuario = findViewById(R.id.txtPlacarUsuario);
        txtPlacarComputador = findViewById(R.id.txtPlacarPC);
        txtEscolha = findViewById(R.id.txtEscolha);

        btnReiniciar = findViewById(R.id.btnReiniciar);

        // Botão reiniciar
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarPartida();
            }
        });

        // Clique Pedra
        imgPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogar("pedra");
            }
        });

        // Clique Papel
        imgPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogar("papel");
            }
        });

        // Clique Tesoura
        imgTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogar("tesoura");
            }
        });
    }

    // Reinicia a partida
    public void reiniciarPartida() {

        pontosUsuario = 0;
        pontosComputador = 0;

        txtPlacarUsuario.setText("0");
        txtPlacarComputador.setText("0");

        txtEscolha.setText("Escolha sua opção de jogada:");

        imgResultado.setImageResource(R.drawable.img_padrao);
    }

    public void jogar(String escolhaUsuario) {

        // Mostrar escolha do usuário
        txtEscolha.setText("Escolha de jogada do Player1: " + escolhaUsuario);

        if (escolhaUsuario.equals("pedra")) {
            imgResultado.setImageResource(R.drawable.img_pedra);
        } else if (escolhaUsuario.equals("papel")) {
            imgResultado.setImageResource(R.drawable.img_papel);
        } else {
            imgResultado.setImageResource(R.drawable.img_tesoura);
        }

        // Delay de 1 segundo antes do computador jogar
        imgResultado.postDelayed(new Runnable() {
            @Override
            public void run() {

                String[] opcoes = {"pedra", "papel", "tesoura"};
                Random random = new Random();

                int numero = random.nextInt(3);
                String escolhaComputador = opcoes[numero];

                // Mostrar escolha do computador
                if (escolhaComputador.equals("pedra")) {
                    imgResultado.setImageResource(R.drawable.img_pedra);
                } else if (escolhaComputador.equals("papel")) {
                    imgResultado.setImageResource(R.drawable.img_papel);
                } else {
                    imgResultado.setImageResource(R.drawable.img_tesoura);
                }

                txtEscolha.setText("Escolha de jogada do BOOT: " + escolhaComputador);

                // Verificar vencedor
                if (
                        (escolhaUsuario.equals("pedra") && escolhaComputador.equals("tesoura")) ||
                                (escolhaUsuario.equals("tesoura") && escolhaComputador.equals("papel")) ||
                                (escolhaUsuario.equals("papel") && escolhaComputador.equals("pedra"))
                ) {

                    pontosUsuario++;
                    txtPlacarUsuario.setText(String.valueOf(pontosUsuario));

                } else if (escolhaUsuario.equals(escolhaComputador)) {

                    Toast.makeText(JokenpoActivity.this, "Empate!", Toast.LENGTH_SHORT).show();

                } else {

                    pontosComputador++;
                    txtPlacarComputador.setText(String.valueOf(pontosComputador));
                }

                // Verificar vencedor da partida
                if (pontosUsuario == 5) {

                    Toast.makeText(JokenpoActivity.this, "Player1 venceu a partida!", Toast.LENGTH_LONG).show();
                    reiniciarPartida();

                } else if (pontosComputador == 5) {

                    Toast.makeText(JokenpoActivity.this, "BOOT venceu a partida!", Toast.LENGTH_LONG).show();
                    reiniciarPartida();
                }
            }
        }, 1000); // 1000ms = 1 segundo
    }

}