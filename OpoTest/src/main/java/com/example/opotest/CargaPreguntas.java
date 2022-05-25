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

public class CargaPreguntas extends AppCompatActivity {

    int idMin;
    int temp = 1;
    int numPreguntas = 10;
    static int fallo;
    static int respondidas;
    static String numTest;
    LinearLayout layout;
    LinearLayout.LayoutParams layoutParamsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_preguntas);
        layout = (LinearLayout) findViewById(R.id.layout);
        layoutParamsTxt = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsTxt.setMargins(0, 60, 0, 0);
        fallo = 0;
        respondidas = 0;

        cargarPregunta();
    }

    public void cargarPregunta() {
        final dbPreguntas dbPreguntas = new dbPreguntas(CargaPreguntas.this);
        idMin = dbPreguntas.minIdPregunta(TestTemas.getId());

        switch (CargaTests.getIdTest()) {
            case 1:
                numTest = "1";
                for (int i = idMin; i < (idMin + numPreguntas); i++) {
                    Preguntas preg;
                    preg = dbPreguntas.verPregunta(i);
                    cargaElementos(temp, numPreguntas, preg);
                    temp++;
                }
                temp = 1;
                break;
            case 2:
                numTest = "2";
                idMin += 10;
                for (int i = idMin; i < (idMin + numPreguntas); i++) {
                    Preguntas preg;
                    preg = dbPreguntas.verPregunta(i);
                    cargaElementos(temp, numPreguntas, preg);
                    temp++;
                }
                temp = 1;
                break;
            case 3:
                numTest = "3";
                idMin += 20;
                for (int i = idMin; i < (idMin + numPreguntas); i++) {
                    Preguntas preg;
                    preg = dbPreguntas.verPregunta(i);
                    cargaElementos(temp, numPreguntas, preg);
                    temp++;
                }
                temp = 1;
                break;
            case 4:
                numTest = "4";
                idMin += 30;
                for (int i = idMin; i < (idMin + numPreguntas); i++) {
                    Preguntas preg;
                    preg = dbPreguntas.verPregunta(i);
                    cargaElementos(temp, numPreguntas, preg);
                    temp++;
                }
                temp = 1;
                break;
            case 5:
                numTest = "5";
                idMin += 40;
                for (int i = idMin; i < (idMin + numPreguntas); i++) {
                    Preguntas preg;
                    preg = dbPreguntas.verPregunta(i);
                    cargaElementos(temp, numPreguntas, preg);
                    temp++;
                }
                temp = 1;
                break;
        }

    }

    public void cargaElementos(int numpregunta, int totPreguntas, Preguntas preg) {
        TextView txt = new TextView(this);
        RadioGroup rg = new RadioGroup(this);
        RadioButton rb1 = new RadioButton(this);
        RadioButton rb2 = new RadioButton(this);
        RadioButton rb3 = new RadioButton(this);
        RadioButton rb4 = new RadioButton(this);

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
            final dbPreguntas dbPreguntas = new dbPreguntas(CargaPreguntas.this);
            if (fallo >= 3) {
                Toast.makeText(this, "Has suspendido la prueba. " + fallo + " fallos", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Enhorabuena!! Has pasado la prueba " + fallo + " fallos", Toast.LENGTH_LONG).show();
            }
            dbPreguntas.insertarLogin(InicioSesion.getUser().getId_usuario(), String.valueOf(TestTemas.getId() - 1), numTest, fallo);
        }
    }

    public void retroceder(View view) {
        Intent intent = new Intent(view.getContext(), CargaTests.class);
        startActivityForResult(intent, 0);
    }
}