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
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;

    Preguntas preg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal2);

        DbHelper dbHelper = new DbHelper(PantallaPrincipal2.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        tv = (TextView) findViewById(R.id.textoo);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rb1 = (RadioButton) findViewById(R.id.respuesta1);
        rb2 = (RadioButton) findViewById(R.id.respuesta2);
        rb3 = (RadioButton) findViewById(R.id.respuesta3);
        rb4 = (RadioButton) findViewById(R.id.respuesta4);

        cargarPregunta();
    }

    public void cargarPregunta()
    {
        final dbPreguntas dbPreguntas = new dbPreguntas(PantallaPrincipal2.this);
        preg = dbPreguntas.verPregunta((int) (Math.random()*500 + 1));

        tv.setText(preg.getPregunta().trim());
        rb1.setText(preg.getRespuesta1().trim());
        rb2.setText(preg.getRespuesta2().trim());
        rb3.setText(preg.getRespuesta3().trim());
        rb4.setText(preg.getRespuesta4().trim());
    }

    public void cargarPregunta(View View)
    {
        cargarPregunta();
        rg.clearCheck();
        rb1.setEnabled(true);
        rb2.setEnabled(true);
        rb3.setEnabled(true);
        rb4.setEnabled(true);
        rb1.setTextColor(Color.BLACK);
        rb2.setTextColor(Color.BLACK);
        rb3.setTextColor(Color.BLACK);
        rb4.setTextColor(Color.BLACK);
    }

    public void comprobarRespuesta(View view)
    {
        RadioButton selectedRadioButton;
        int selectedRadioButtonId = rg.getCheckedRadioButtonId();
        String selectedRbText = "";
        String[] textRadio = new String[]{(String) rb1.getText(),(String) rb2.getText(),(String) rb3.getText(),(String) rb4.getText()};
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
                            rb1.setText("✔. " + preg.getRespuesta_correcta());
                            rb1.setTextColor(Color.GREEN);
                        }
                        if(i == 1)
                        {
                            rb2.setText("✔. " + preg.getRespuesta_correcta());
                            rb2.setTextColor(Color.GREEN);
                        }
                        if(i == 2)
                        {
                            rb3.setText("✔. " + preg.getRespuesta_correcta());
                            rb3.setTextColor(Color.GREEN);
                        }
                        if(i == 3)
                        {
                            rb4.setText("✔. " + preg.getRespuesta_correcta());
                            rb4.setTextColor(Color.GREEN);
                        }
                    }
                }
            }
        }
        rb1.setEnabled(false);
        rb2.setEnabled(false);
        rb3.setEnabled(false);
        rb4.setEnabled(false);
    }
}