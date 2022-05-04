package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Examen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);
    }

    public void empezarExamen(View view)
    {
        Intent intent = new Intent (view.getContext(), Examen.class);
        startActivityForResult(intent, 0);
    }

    public void retroceder(View view)
    {
        Intent intent = new Intent (view.getContext(), PantallaPrincipal.class);
        startActivityForResult(intent, 0);
    }
}