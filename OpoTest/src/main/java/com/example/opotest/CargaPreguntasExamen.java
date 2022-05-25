package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opotest.Entidades.Preguntas;
import com.example.opotest.db.dbPreguntas;

import java.util.Stack;

public class CargaPreguntasExamen extends AppCompatActivity {

    static int fallo = 0;
    static int respondidas = 0;
    int numPreguntas = 3;
    LinearLayout layout;
    LinearLayout.LayoutParams layoutParamsTxt;
    final dbPreguntas dbPreguntas = new dbPreguntas(CargaPreguntasExamen.this);

    int[] ids2 = new int[numPreguntas];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_preguntas_examen);
        layout = (LinearLayout) findViewById(R.id.layout);
        layoutParamsTxt = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsTxt.setMargins(0, 60, 0, 0);

        for (int i = 0; i < Examen.getCbMarcados().length; i++)
        {
            System.out.println(Examen.getCbMarcados()[i]);
        }

        ids2 = cargarIds();
        for (int i = 0; i < ids2.length; i++)
        {
            System.out.println(ids2[i]);
            cargaElementos((i + 1),numPreguntas,ids2[i]);
        }
    }

    public int[] cargarIds(){
        Stack <Integer> ids = new Stack<Integer>();
        int[] ids2 = new int[numPreguntas];

        final dbPreguntas dbPreguntas = new dbPreguntas(CargaPreguntasExamen.this);
        int idMin;
        int idMax;
        int tema;
        int id;

        for (int i = 0; i < numPreguntas; i++)
        {
            do{
                tema = Examen.getCbMarcados()[aleatorio((Examen.getCbMarcados().length - 1), 0)];
            }while(tema == 0);
            idMin = dbPreguntas.minIdPregunta(tema);
            idMax = (dbPreguntas.minIdPregunta(tema) + dbPreguntas.cuentaPreguntas(tema)) - 1;
            id = aleatorio(idMin, idMax);
            while (ids.contains(id))
            {
                id = aleatorio(idMin, idMax);
            }
            ids.push(id);
        }
        for (int z = 0; z < numPreguntas;z++)
        {
            ids2[z] = ids.pop();
        }

        return ids2;
    }

    public Preguntas[] cargarPreguntas(){
        Preguntas[] pregs = new Preguntas[numPreguntas];
        Preguntas preg;

        final dbPreguntas dbPreguntas = new dbPreguntas(CargaPreguntasExamen.this);
        int idMin = 0;
        int idMax = 0;
        int tema;

        for (int i = 0; i < pregs.length; i++)
        {
            do{
                tema = Examen.getCbMarcados()[aleatorio((Examen.getCbMarcados().length - 1), 0)];
            }while(tema == 0);
            idMin = dbPreguntas.minIdPregunta(tema);
            idMax = (dbPreguntas.minIdPregunta(tema) + dbPreguntas.cuentaPreguntas(tema)) - 1;
            preg = dbPreguntas.verPregunta(aleatorio(idMin, idMax), tema);
            pregs[i] = preg;
        }

        return pregs;
    }

    public void cargaElementos(int numpregunta, int totPreguntas, int id) {
        TextView txt = new TextView(this);
        RadioGroup rg = new RadioGroup(this);
        RadioButton rb1 = new RadioButton(this);
        RadioButton rb2 = new RadioButton(this);
        RadioButton rb3 = new RadioButton(this);
        RadioButton rb4 = new RadioButton(this);
        Preguntas preg = dbPreguntas.verPregunta(id);

        txt.setText(numpregunta + "/" + totPreguntas + ". " + preg.getPregunta().trim());
        txt.setTextSize(16);
        txt.setLayoutParams(layoutParamsTxt);
        layout.addView(txt, layoutParamsTxt);

        rg.setOrientation(RadioGroup.VERTICAL);

        rb1.setText(preg.getRespuesta1().trim());
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(preg, rg, rb1, rb2, rb3, rb4);
            }
        });
        rg.addView(rb1);
        rb2.setText(preg.getRespuesta2().trim());
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(preg, rg, rb1, rb2, rb3, rb4);
            }
        });
        rg.addView(rb2);
        rb3.setText(preg.getRespuesta3().trim());
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(preg, rg, rb1, rb2, rb3, rb4);
            }
        });
        rg.addView(rb3);
        rb4.setText(preg.getRespuesta4().trim());
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(preg, rg, rb1, rb2, rb3, rb4);
            }
        });
        rg.addView(rb4);
        layout.addView(rg, layoutParamsTxt);
    }

    public void comprobarRespuesta(Preguntas preg, RadioGroup rg, RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4) {
        RadioButton selectedRadioButton;
        int selectedRadioButtonId = rg.getCheckedRadioButtonId();
        String selectedRbText = "";
        String[] textRadio = new String[]{(String) rb1.getText(), (String) rb2.getText(), (String) rb3.getText(), (String) rb4.getText()};
        if (selectedRadioButtonId != -1) {
            selectedRadioButton = findViewById(selectedRadioButtonId);
            selectedRbText = selectedRadioButton.getText().toString();
            if (selectedRbText.trim().equals(preg.getRespuesta_correcta().trim())) {
                selectedRadioButton.setText("✔. " + selectedRbText);
                selectedRadioButton.setTextColor(Color.GREEN);
                respondidas++;
            } else {
                selectedRadioButton.setText("X. " + selectedRbText);
                selectedRadioButton.setTextColor(Color.RED);
                fallo++;
                respondidas++;
                for (int i = 0; i < textRadio.length; i++) {
                    if (textRadio[i].equals(preg.getRespuesta_correcta())) {
                        if (i == 0) {
                            rb1.setText("✔. " + preg.getRespuesta_correcta());
                            rb1.setTextColor(Color.GREEN);
                        }
                        if (i == 1) {
                            rb2.setText("✔. " + preg.getRespuesta_correcta());
                            rb2.setTextColor(Color.GREEN);
                        }
                        if (i == 2) {
                            rb3.setText("✔. " + preg.getRespuesta_correcta());
                            rb3.setTextColor(Color.GREEN);
                        }
                        if (i == 3) {
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

        if (respondidas == numPreguntas) {
            if (fallo >= 3) {
                Toast.makeText(this, "Has suspendido la prueba. " + fallo + " fallos", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Enhorabuena!! Has pasado la prueba " + fallo + " fallos", Toast.LENGTH_LONG).show();
            }
        }
    }

    public int aleatorio(int max, int min)
    {
        max = max + 1;
        return (int)(Math.random() * (max - min) + min);
    }

    public void retroceder(View view) {
        Intent intent = new Intent(view.getContext(), Examen.class);
        startActivityForResult(intent, 0);
        Examen.setZ(0);
    }


}