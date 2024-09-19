package com.example.advancedformvalidationapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText imie;
    private EditText nazwisko;
    private EditText mail;
    private EditText telefon;
    private EditText haslo;
    private EditText potwierdzHaslo;
    private Button przycisk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imie = findViewById(R.id.imie);
        nazwisko = findViewById(R.id.nazwisko);
        mail = findViewById(R.id.mail);
        telefon = findViewById(R.id.telefon);
        haslo = findViewById(R.id.haslo);
        potwierdzHaslo = findViewById(R.id.potwierdzHaslo);
        przycisk = findViewById(R.id.przycisk);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sprawdzImie = imie.getText().toString().trim();
                String sprawdzNazwisko = nazwisko.getText().toString().trim();
                String sprawdzMail = mail.getText().toString().trim();
                String sprawdzTelefon = telefon.getText().toString().trim();
                String sprawdzHaslo = haslo.getText().toString().trim();
                String sprawdzPotwierdzHaslo = potwierdzHaslo.getText().toString().trim();
                
                if (sprawdzImie.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Prosimy dodać imię", Toast.LENGTH_SHORT).show();
                } else if (sprawdzNazwisko.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Prosimy dodać nazwisko", Toast.LENGTH_SHORT).show();
                } else if (sprawdzTelefon.length() != 9) {
                    Toast.makeText(MainActivity.this, "Proszę podać numer 9 cyfrowy", Toast.LENGTH_SHORT).show();
                }else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(sprawdzMail).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
                }  else if (sprawdzHaslo.length() < 6) {
                    Toast.makeText(MainActivity.this, "Hasło musi mieć 6 lub więcej zanków", Toast.LENGTH_SHORT).show();
                } else if (!sprawdzHaslo.equals(sprawdzPotwierdzHaslo)) {
                    Toast.makeText(MainActivity.this, "Hasła nie są takie same", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Formularz wysłano poprawnie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}