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
    LinearLayout layout;
    LinearLayout.LayoutParams layoutParamsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_preguntas);
        layout = (LinearLayout) findViewById(R.id.layout);
        layoutParamsTxt = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams. MATCH_PARENT ,
                LinearLayout.LayoutParams. WRAP_CONTENT ) ;
        layoutParamsTxt.setMargins(0,60,0,0);

        cargarPregunta();

    }

    public void cargarPregunta()
    {
        int i = 0;
        final dbPreguntas dbPreguntas = new dbPreguntas(CargaPreguntas.this);
        numPreguntas = dbPreguntas.cuentaPreguntas(TestTemas.getId());
        idMin = dbPreguntas.minIdPregunta(TestTemas.getId());

        for (i = idMin; i < (idMin + 10); i++)
        {
            preg = dbPreguntas.verPregunta(i);
            System.out.println("NUMERO PREGUNTAS DEL TEMA " + TestTemas.getId() + ": " + numPreguntas);
            System.out.println("PREGUNTAS " + preg.getId_pregunta());
            generaElementos(preg);
        }

    }

    public void generaElementos(Preguntas preg)
    {
        TextView txt = new TextView(this);
        txt.setText(preg.getPregunta().trim());
        txt.setTextSize(20);
        txt.setLayoutParams(layoutParamsTxt);
        layout.addView(txt, layoutParamsTxt);
        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(RadioGroup.VERTICAL);
        RadioButton rb1 = new RadioButton(this);
        rb1.setText(preg.getRespuesta1().trim());
        rg.addView(rb1);
        RadioButton rb2 = new RadioButton(this);
        rb2.setText(preg.getRespuesta2().trim());
        rg.addView(rb2);
        RadioButton rb3 = new RadioButton(this);
        rb3.setText(preg.getRespuesta3().trim());
        rg.addView(rb3);
        RadioButton rb4 = new RadioButton(this);
        rb4.setText(preg.getRespuesta4().trim());
        rg.addView(rb4);
        layout.addView(rg, layoutParamsTxt);
    }

    public void retroceder(View view)
    {
        Intent intent = new Intent (view.getContext(), CargaTests.class);
        startActivityForResult(intent, 0);
    }
}