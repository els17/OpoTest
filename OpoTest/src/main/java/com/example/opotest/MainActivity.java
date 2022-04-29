package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opotest.Entidades.Preguntas;
import com.example.opotest.db.DbHelper;
import com.example.opotest.db.dbPreguntas;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private RadioGroup rg;
    private RadioButton cb1;
    private RadioButton cb2;
    private RadioButton cb3;
    private RadioButton cb4;
    private CheckBox cbCorr;

    /*private TextView tv2;
    private CheckBox cb12;
    private CheckBox cb22;
    private CheckBox cb32;
    private CheckBox cb42;
    private CheckBox cb52;*/

    Preguntas preg;
//    Preguntas preg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        tv = (TextView) findViewById(R.id.textoo);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        cb1 = (RadioButton) findViewById(R.id.respuesta1);
        cb2 = (RadioButton) findViewById(R.id.respuesta2);
        cb3 = (RadioButton) findViewById(R.id.respuesta3);
        cb4 = (RadioButton) findViewById(R.id.respuesta4);
        cbCorr = (CheckBox) findViewById(R.id.respuestaCorrecta);

        /*tv2 = (TextView) findViewById(R.id.textoo2);
        cb12 = (CheckBox) findViewById(R.id.respuesta12);
        cb22 = (CheckBox) findViewById(R.id.respuesta22);
        cb32 = (CheckBox) findViewById(R.id.respuesta32);
        cb42 = (CheckBox) findViewById(R.id.respuesta42);
        cb52 = (CheckBox) findViewById(R.id.respuestaCorrecta2);*/

        cargarPregunta();
    }

    public void cargarPregunta(){
        //preg2 = dbPreguntas.verPregunta((int) (Math.random()*500 + 1));
        final dbPreguntas dbPreguntas = new dbPreguntas(MainActivity.this);
        preg = dbPreguntas.verPregunta((int) (Math.random()*500 + 1));

        tv.setText(preg.getPregunta().trim());
        cb1.setText(preg.getRespuesta1().trim());
        cb2.setText(preg.getRespuesta2().trim());
        cb3.setText(preg.getRespuesta3().trim());
        cb4.setText(preg.getRespuesta4().trim());
        cbCorr.setText(preg.getRespuesta_correcta().trim());

        /*tv2.setText(preg2.getPregunta().trim());
        cb12.setText(preg2.getRespuesta1().trim());
        cb22.setText(preg2.getRespuesta2().trim());
        cb32.setText(preg2.getRespuesta3().trim());
        cb42.setText(preg2.getRespuesta4().trim());
        cb52.setText(preg2.getRespuesta_correcta().trim());*/

    }

    public void cargarPregunta(View View){

        //preg2 = dbPreguntas.verPregunta((int) (Math.random()*500 + 1));

        cargarPregunta();

        /*tv2.setText(preg2.getPregunta().trim());
        cb12.setText(preg2.getRespuesta1().trim());
        cb22.setText(preg2.getRespuesta2().trim());
        cb32.setText(preg2.getRespuesta3().trim());
        cb42.setText(preg2.getRespuesta4().trim());
        cb52.setText(preg2.getRespuesta_correcta().trim());*/

    }

    public void comprobarRespuesta(View view)
    {
        RadioButton selectedRadioButton;
        int selectedRadioButtonId = rg.getCheckedRadioButtonId();
        String selectedRbText = "";

        if (selectedRadioButtonId != -1) {
            selectedRadioButton = findViewById(selectedRadioButtonId);
            selectedRbText = selectedRadioButton.getText().toString();
        } else {
        }
        if (selectedRbText == preg.getRespuesta_correcta())
        {
            Toast.makeText(this, "CORRECTAAA", Toast.LENGTH_SHORT).show();
        }
    }


}