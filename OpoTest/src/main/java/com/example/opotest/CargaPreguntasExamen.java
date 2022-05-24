package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CargaPreguntasExamen extends AppCompatActivity {

    //no es util solo estaba probando para el metodo en dbpreguntas preguntasTema
        /*
        final dbPreguntas dbPreguntas = new dbPreguntas(this);
        Preguntas[] preg = dbPreguntas.preguntasTema(12);

        for (int i = 0; i < preg.length; i++)
        {
            System.out.println(preg[i].getId_pregunta() + ". " + preg[i].getPregunta());
        }
        */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_preguntas_examen);

        for (int i = 0; i < Examen.getCbMarcados().length; i++)
        {
            System.out.println(Examen.getCbMarcados()[i]);
        }
    }

    public void retroceder(View view) {
        Intent intent = new Intent(view.getContext(), Examen.class);
        startActivityForResult(intent, 0);
        Examen.setZ(0);
    }
}