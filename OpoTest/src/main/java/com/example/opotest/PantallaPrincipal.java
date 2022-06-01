package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PantallaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
    }

    public void testTemas(View view)
    {
        Intent intent = new Intent (view.getContext(), TestTemas.class);
        startActivityForResult(intent, 0);
    }

    public void examen(View view)
    {
        Intent intent = new Intent (view.getContext(), Examen.class);
        startActivityForResult(intent, 0);
    }

    public void historial(View view)
    {
        Intent intent = new Intent (view.getContext(), Historial.class);
        startActivityForResult(intent, 0);
    }

}