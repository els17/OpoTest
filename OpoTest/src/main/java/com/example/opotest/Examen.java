package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.opotest.Entidades.Temas;
import com.example.opotest.db.dbPreguntas;

import org.w3c.dom.Text;

public class Examen extends AppCompatActivity {

    LinearLayout layout;
    LinearLayout.LayoutParams layoutParamsTxt;
    LinearLayout.LayoutParams layoutParamsCb;
    LinearLayout.LayoutParams layoutParamsBtn;

    static int[] cbMarcados = new int[12];

    static int z = 0;

    int numTemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);
        layout = (LinearLayout) findViewById(R.id.layout);
        layoutParamsTxt = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsTxt.setMargins(0, 60, 0, 0);
        layoutParamsCb = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsCb.setMargins(30, 60, 0, 0);
        layoutParamsBtn = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsBtn.setMargins(0, 20, 0, 0);
        TextView txt = new TextView(this);
        txt.setText("Elija los temas de los cuales se va a examinar:");
        txt.setTextSize(16);
        txt.setLayoutParams(layoutParamsTxt);
        layout.addView(txt, layoutParamsTxt);

        cargaTemas();

        Button btn = new Button(this);
        btn.setText("Empezar examen");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), CargaPreguntasExamen.class);
                startActivityForResult(intent, 0);
            }
        });
        layout.addView(btn, layoutParamsBtn);
    }

    public void cargaTemas(){
        final dbPreguntas dbPreguntas = new dbPreguntas(Examen.this);
        numTemas = dbPreguntas.cuentaTemas();

        for (int i = 1;i <= numTemas; i++)
        {
            Temas t;
            t = dbPreguntas.verTema(i);
            cargaCheckBox(t, i);
        }
    }

    public void cargaCheckBox(Temas t, int i){
        CheckBox cb = new CheckBox(this);
        cb.setText(t.getNombre_tema());
        cb.setId(i);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb.isChecked()){
                    cbMarcados[z] = cb.getId();
                    z++;
                }
            }
        });
        layout.addView(cb, layoutParamsCb);
    }

    public void retroceder(View view)
    {
        Intent intent = new Intent (view.getContext(), PantallaPrincipal.class);
        startActivityForResult(intent, 0);
    }

    public static int[] getCbMarcados() {
        return cbMarcados;
    }

    public static void setZ(int z) {
        Examen.z = z;
    }
}