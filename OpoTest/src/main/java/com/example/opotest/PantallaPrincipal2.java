package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.opotest.Entidades.Preguntas;
import com.example.opotest.db.DbHelper;
import com.example.opotest.db.dbPreguntas;

public class PantallaPrincipal2 extends AppCompatActivity {

    private TextView tv;
    private RadioGroup rg;
    private RadioButton cb1;
    private RadioButton cb2;
    private RadioButton cb3;
    private RadioButton cb4;

    Preguntas preg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal2);

        DbHelper dbHelper = new DbHelper(PantallaPrincipal2.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        tv = (TextView) findViewById(R.id.textoo);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        cb1 = (RadioButton) findViewById(R.id.respuesta1);
        cb2 = (RadioButton) findViewById(R.id.respuesta2);
        cb3 = (RadioButton) findViewById(R.id.respuesta3);
        cb4 = (RadioButton) findViewById(R.id.respuesta4);

        cargarPregunta();
    }

    public void cargarPregunta()
    {
        final dbPreguntas dbPreguntas = new dbPreguntas(PantallaPrincipal2.this);
        preg = dbPreguntas.verPregunta((int) (Math.random()*500 + 1));

        tv.setText(preg.getPregunta().trim());
        cb1.setText(preg.getRespuesta1().trim());
        cb2.setText(preg.getRespuesta2().trim());
        cb3.setText(preg.getRespuesta3().trim());
        cb4.setText(preg.getRespuesta4().trim());
    }

    public void cargarPregunta(View View)
    {
        cargarPregunta();
        rg.clearCheck();
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
        cb4.setEnabled(true);
        cb1.setTextColor(Color.BLACK);
        cb2.setTextColor(Color.BLACK);
        cb3.setTextColor(Color.BLACK);
        cb4.setTextColor(Color.BLACK);
    }

    public void comprobarRespuesta(View view)
    {
        RadioButton selectedRadioButton;
        int selectedRadioButtonId = rg.getCheckedRadioButtonId();
        String selectedRbText = "";
        String[] textRadio = new String[]{(String) cb1.getText(),(String) cb2.getText(),(String) cb3.getText(),(String) cb4.getText()};
        if (selectedRadioButtonId != -1) {
            selectedRadioButton = findViewById(selectedRadioButtonId);
            selectedRbText = selectedRadioButton.getText().toString();
            if (selectedRbText.trim().equals(preg.getRespuesta_correcta().trim()))
            {
                selectedRadioButton.setText("✔. " + selectedRbText);
                selectedRadioButton.setTextColor(Color.GREEN);
            }else{
                selectedRadioButton.setText("X. " + selectedRbText);
                selectedRadioButton.setTextColor(Color.RED);
                for (int i = 0; i < textRadio.length; i++)
                {
                    if (textRadio[i].equals(preg.getRespuesta_correcta())){
                        if(i == 0)
                        {
                            cb1.setText("✔. " + preg.getRespuesta_correcta());
                            cb1.setTextColor(Color.GREEN);
                        }
                        if(i == 1)
                        {
                            cb2.setText("✔. " + preg.getRespuesta_correcta());
                            cb2.setTextColor(Color.GREEN);
                        }
                        if(i == 2)
                        {
                            cb3.setText("✔. " + preg.getRespuesta_correcta());
                            cb3.setTextColor(Color.GREEN);
                        }
                        if(i == 3)
                        {
                            cb4.setText("✔. " + preg.getRespuesta_correcta());
                            cb4.setTextColor(Color.GREEN);
                        }
                    }
                }
            }
        }
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
        cb4.setEnabled(false);
    }
}