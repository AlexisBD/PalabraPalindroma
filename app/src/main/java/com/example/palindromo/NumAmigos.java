package com.example.palindromo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class NumAmigos extends AppCompatActivity {

    static EditText txtNum1, txtNum2, txtResultado;
    static String textNum1, textNum2 = "";
    static int num1, num2, sum1, sum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_amigos);

        final Button btnAmigosReturn = findViewById(R.id.btnAmigosReturn);
        final Button btnVerificar = findViewById(R.id.btnVerificar);

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        txtResultado = findViewById(R.id.txtResultado);

        btnAmigosReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewMain = new Intent(NumAmigos.this, MainActivity.class);

                startActivity(viewMain);
            }
        });

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroAmigo();
            }
        });
    }

    private void numeroAmigo() {
        textNum1 = txtNum1.getText().toString();
        textNum2 = txtNum2.getText().toString();
        num1 = Integer.parseInt(textNum1);
        num2 = Integer.parseInt(textNum2);

        for (int i = 1; i < num1; i++) {
            if (num1 % i == 0 && i != num1) {
                sum1 += i;
            }
            for (int j = 1; j < num2; j++) {
                if (num2 % j == 0 && j != num2) {
                    sum2 += j;
                }
            }
        }
        if (num1 == sum2 || num2 == sum1)
            txtResultado.setText(num1+" Es amigo de "+ num2);
         else
            txtResultado.setText(num1+" No es amigo de "+ num2);

         sum1 = 0;
         sum2 = 0;
    }
}
