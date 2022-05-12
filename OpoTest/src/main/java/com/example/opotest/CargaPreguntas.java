package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.opotest.Entidades.Preguntas;
import com.example.opotest.db.dbPreguntas;

public class CargaPreguntas extends AppCompatActivity {

    int numPreguntas;
    int idMin;
    int idMax;
    Preguntas preg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_preguntas);
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        LinearLayout.LayoutParams layoutParamsTxt = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams. MATCH_PARENT ,
                LinearLayout.LayoutParams. WRAP_CONTENT ) ;
        layoutParamsTxt.setMargins(0,60,0,0);
        final dbPreguntas dbPreguntas = new dbPreguntas(CargaPreguntas.this);
        numPreguntas = dbPreguntas.cuentaPreguntas(TestTemas.getId());
        idMin = dbPreguntas.minIdPregunta(TestTemas.getId());
        idMax = idMin + (numPreguntas - 1);
        preg = dbPreguntas.verPregunta((int)(Math.random() * (idMax - idMin + 1) + idMin), TestTemas.getId());

        System.out.println("NUMERO PREGUNTAS DEL TEMA " + TestTemas.getId() + ": " + numPreguntas);
        System.out.println("PREGUNTAS " + preg.getId_pregunta());

        TextView txt = new TextView(this);
        txt.setText(preg.getPregunta().trim());
        txt.setTextSize(20);
        txt.setLayoutParams(layoutParamsTxt);
        layout.addView(txt, layoutParamsTxt);

    }

    public void retroceder(View view)
    {
        Intent intent = new Intent (view.getContext(), CargaTests.class);
        startActivityForResult(intent, 0);
    }
}