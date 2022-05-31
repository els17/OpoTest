package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opotest.Entidades.Preguntas;
import com.example.opotest.db.dbPreguntas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class CargaPreguntasExamen extends AppCompatActivity {

    static int fallo;
    static int respondidas;
    int numPreguntas = 3;
    String numTemas;
    Button btn;
    LinearLayout layout;
    LinearLayout.LayoutParams layoutParamsTxt;
    LinearLayout.LayoutParams layoutParamsBtn;
    final dbPreguntas dbPreguntas = new dbPreguntas(CargaPreguntasExamen.this);
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date(System.currentTimeMillis());

    SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
    Date date2 = new Date(System.currentTimeMillis());

    int[] ids2 = new int[numPreguntas];
    Preguntas[] pregs = new Preguntas[numPreguntas];
    RadioGroup[] rgs = new RadioGroup[numPreguntas];
    RadioButton[] rb1s = new RadioButton[numPreguntas];
    RadioButton[] rb2s = new RadioButton[numPreguntas];
    RadioButton[] rb3s = new RadioButton[numPreguntas];
    RadioButton[] rb4s = new RadioButton[numPreguntas];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_preguntas_examen);
        layout = (LinearLayout) findViewById(R.id.layout);
        layoutParamsTxt = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsTxt.setMargins(0, 60, 0, 0);
        layoutParamsBtn = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsBtn.setMargins(40, 40, 70, 0);
        fallo = 0;
        respondidas = 0;

        numTemas = String.valueOf(Examen.getCbMarcados()[0] - 1);
        for (int i = 1; i < Examen.getCbMarcados().length; i++)
        {
            if (Examen.getCbMarcados()[i] != 0)
            {
                numTemas +=  " " + (Examen.getCbMarcados()[i] - 1);
            }
        }

        ids2 = cargarIds();
        for (int i = 0; i < ids2.length; i++)
        {
            cargaElementos((i + 1),numPreguntas,ids2[i]);
        }

        btn = new Button(this);
        btn.setText("Corregir examen");
        btn.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,150,getResources().getDisplayMetrics()));
        btn.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,getResources().getDisplayMetrics()));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corregirExamen();
            }
        });
        layout.addView(btn, layoutParamsBtn);

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

    /*
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

     */

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
        rg.addView(rb1);
        rb2.setText(preg.getRespuesta2().trim());
        rg.addView(rb2);
        rb3.setText(preg.getRespuesta3().trim());
        rg.addView(rb3);
        rb4.setText(preg.getRespuesta4().trim());
        rg.addView(rb4);
        layout.addView(rg, layoutParamsTxt);

        pregs[numpregunta - 1] = preg;
        rgs[numpregunta - 1] = rg;
        rb1s[numpregunta - 1] = rb1;
        rb2s[numpregunta - 1] = rb2;
        rb3s[numpregunta - 1] = rb3;
        rb4s[numpregunta - 1] = rb4;
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

    }

    public void corregirExamen(){

        for (int i = 0; i < numPreguntas; i++)
        {
            comprobarRespuesta(pregs[i], rgs[i], rb1s[i], rb2s[i], rb3s[i], rb4s[i]);
        }
        if (fallo >= 3) {
            Toast.makeText(this, "Has suspendido la prueba. " + fallo + " fallos", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Enhorabuena!! Has pasado la prueba " + fallo + " fallos", Toast.LENGTH_LONG).show();
        }
        dbPreguntas.insertarLogin(InicioSesion.getUser().getId_usuario(), numTemas, "Examen", fallo, formatter.format(date), formatter2.format(date2));
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
        numTemas = "";
    }


}