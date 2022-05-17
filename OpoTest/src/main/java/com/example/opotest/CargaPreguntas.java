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

    int idMin;
    int temp = 1;
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


        System.out.println("TEST SELECCIONADO ------> " + CargaTests.getIdTest());
        cargarPregunta();

    }

    public void cargarPregunta()
    {
        final dbPreguntas dbPreguntas = new dbPreguntas(CargaPreguntas.this);
        idMin = dbPreguntas.minIdPregunta(TestTemas.getId());

        switch (CargaTests.getIdTest())
        {
            case 1:
                System.out.println("ENTRO EN 1");
                for (int i = idMin; i < (idMin + 10); i++)
                {
                    preg = dbPreguntas.verPregunta(i);
                    generaElementos(temp, 10, preg, i);
                    temp++;
                }
                temp = 1;
                break;
            case 2:
                System.out.println("ENTRO EN 2");
                idMin += 10;
                for (int i = idMin; i < (idMin + 10); i++)
                {
                    preg = dbPreguntas.verPregunta(i);
                    generaElementos(temp, 10, preg, i);
                    temp++;
                }
                temp = 1;
                break;
            case 3:
                System.out.println("ENTRO EN 3");
                idMin += 20;
                for (int i = idMin; i < (idMin + 10); i++)
                {
                    preg = dbPreguntas.verPregunta(i);
                    generaElementos(temp, 10, preg, i);
                    temp++;
                }
                temp = 1;
                break;
            case 4:
                System.out.println("ENTRO EN 4");
                idMin += 30;
                for (int i = idMin; i < (idMin + 10); i++)
                {
                    preg = dbPreguntas.verPregunta(i);
                    generaElementos(temp, 10, preg, i);
                    temp++;
                }
                temp = 1;
                break;
            case 5:
                System.out.println("ENTRO EN 5");
                idMin += 40;
                for (int i = idMin; i < (idMin + 10); i++)
                {
                    preg = dbPreguntas.verPregunta(i);
                    generaElementos(temp, 10, preg, i);
                    temp++;
                }
                temp = 1;
                break;
        }

    }

    public void generaElementos(int numpregunta, int totPreguntas, Preguntas preg, int i)
    {
        TextView txt;
        RadioGroup rg;
        RadioButton rb1;
        RadioButton rb2;
        RadioButton rb3;
        RadioButton rb4;
        txt = new TextView(this);
        txt.setText(numpregunta + "/" + totPreguntas + ". " + preg.getPregunta().trim());
        txt.setTextSize(16);
        txt.setLayoutParams(layoutParamsTxt);
        layout.addView(txt, layoutParamsTxt);
        rg = new RadioGroup(this);
        rb1 = new RadioButton(this);
        rb2 = new RadioButton(this);
        rb3 = new RadioButton(this);
        rb4 = new RadioButton(this);
        rg.setOrientation(RadioGroup.VERTICAL);
        rg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(rg, rb1, rb2, rb3, rb4);
            }
        });
        rb1.setText(preg.getRespuesta1().trim());
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(rg, rb1, rb2, rb3, rb4);
            }
        });
        rg.addView(rb1);
        rb2.setText(preg.getRespuesta2().trim());
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(rg, rb1, rb2, rb3, rb4);
            }
        });
        rg.addView(rb2);
        rb3.setText(preg.getRespuesta3().trim());
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(rg, rb1, rb2, rb3, rb4);
            }
        });
        rg.addView(rb3);
        rb4.setText(preg.getRespuesta4().trim());
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta(rg, rb1, rb2, rb3, rb4);
            }
        });
        rg.addView(rb4);
        layout.addView(rg, layoutParamsTxt);
    }

    public void comprobarRespuesta(RadioGroup rg, RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4)
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

    public void retroceder(View view)
    {
        Intent intent = new Intent (view.getContext(), CargaTests.class);
        startActivityForResult(intent, 0);
    }


}