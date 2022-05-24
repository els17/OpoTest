package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.opotest.Entidades.Preguntas;
import com.example.opotest.db.DbHelper;
import com.example.opotest.db.dbPreguntas;

public class PantallaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        //DbHelper dbHelper = new DbHelper(PantallaPrincipal.this);
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

}