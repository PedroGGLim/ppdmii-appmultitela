package com.fatec.cps.sp.gov.br.appmultitela;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_questionario);

        Button btnCalcular;
        RadioGroup radioSono, radioEstresse;

        btnCalcular = findViewById(R.id.btnCalcular);
        radioSono = findViewById(R.id.radioSono);
        radioEstresse = findViewById(R.id.radioEstresse);

        btnCalcular.setOnClickListener(v -> {

            int sono = 0;
            int estresse = 0;

            // SONO
            int idSono = radioSono.getCheckedRadioButtonId();
            if(idSono == R.id.sono1) sono = 1;
            else if(idSono == R.id.sono2) sono = 3;
            else if(idSono == R.id.sono3) sono = 2;

            // ESTRESSE
            int idEst = radioEstresse.getCheckedRadioButtonId();
            if(idEst == R.id.est1) estresse = 3;
            else if(idEst == R.id.est2) estresse = 2;
            else if(idEst == R.id.est3) estresse = 1;

            double felicidade = ((sono + estresse) / 6.0) * 10;

            Intent intent = new Intent(this, ResultadoActivity.class);
            intent.putExtra("felicidade", felicidade);

            startActivity(intent);
        });

    }
}