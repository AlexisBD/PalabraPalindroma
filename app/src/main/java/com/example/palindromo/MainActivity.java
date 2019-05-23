package com.example.palindromo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnPalindromo = findViewById(R.id.btnPalindromo);
        final Button btnNumAmigos = findViewById(R.id.btnNumAmigos);


        btnPalindromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewPalindromo = new Intent(MainActivity.this, Palindromo.class);

                startActivity(viewPalindromo);
            }
        });

        btnNumAmigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewNumAmigos = new Intent(MainActivity.this, NumAmigos.class);

                startActivity(viewNumAmigos);
            }
        });
    }
}
