package com.example.palindromo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;
public class Palindromo extends AppCompatActivity {

    static EditText txtPalabra, txtPalindromo, txtLongitud, txtInversa, txtLetraRepetida;
    static String palabra,  palabraInvertida = "";
    static int inicio, fin, longitud;
    static boolean error = false;
    StringBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindromo);

        final Button btnPalReturn = findViewById(R.id.btnPalReturn);
        final Button btnGenerar = findViewById(R.id.btnGenerar);

        txtPalabra  = findViewById(R.id.txtPalabra);
        txtPalindromo = findViewById(R.id.txtPalindromo);
        txtLongitud = findViewById(R.id.txtLongitud);
        txtInversa = findViewById(R.id.txtInversa);
        txtLetraRepetida = findViewById(R.id.txtLetrasIguales);

        btnPalReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewMain = new Intent(Palindromo.this, MainActivity.class);

                startActivity(viewMain);
            }
        });

        btnGenerar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                palindromo();
            }
        });

    }

    private void palindromo() {
        palabra = txtPalabra.getText().toString();
        error = false;
        inicio = 0;
        longitud = palabra.length();

        palabra = palabra.replace(" ","");
        fin = palabra.length()-1;

        // INVERSA DE UNA CADENA
        builder = new StringBuilder(palabra);
        palabraInvertida = builder.reverse().toString();

        char repetida = 'z';
        int cont = 0;
        for (int i = 0;  i < palabra.length();  i++) {
            int aux = 0;
            char letra = palabra.charAt(i);
            for (int j = 0; j < palabra.length(); j++) {
                if (letra == palabra.charAt(j))
                    aux++;
            }
            if (aux > cont) {
                cont = aux;
                repetida = letra;
                Log.d("reétida", "->"+repetida);
                Log.d("letra", "->"+letra);
            }
        }



        while ((inicio < fin) && (!error)){

            if (palabra.charAt(inicio)==palabra.charAt(fin)){
                inicio++;
                fin--;
            } else {
                error = true;
            }
        }

        if (!error) {
            txtPalindromo.setText("Si");
            txtLongitud.setText(""+longitud);
            txtInversa.setText(palabraInvertida);
            txtLetraRepetida.setText(Character.toString(repetida));
        }
        else {
            txtPalindromo.setText("No");
            txtLongitud.setText(""+longitud);
            txtInversa.setText(palabraInvertida);
            txtLetraRepetida.setText(Character.toString(repetida));
        }
    }

}
