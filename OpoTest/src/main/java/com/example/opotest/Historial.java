package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.opotest.Entidades.Login;
import com.example.opotest.db.dbPreguntas;

public class Historial extends AppCompatActivity {

    LinearLayout layout;
    LinearLayout layoutBtn;
    LinearLayout.LayoutParams layoutParamsTxt;
    LinearLayout.LayoutParams layoutParamsBtn;
    Button btn;

    final com.example.opotest.db.dbPreguntas dbPreguntas = new dbPreguntas(Historial.this);
    int idUsuario;
    Login[] logins;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        layout = (LinearLayout) findViewById(R.id.layout);
        layoutBtn = new LinearLayout(this);
        layoutParamsTxt = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsBtn = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsBtn.setMargins(40, 40, 70, 0);
        idUsuario = InicioSesion.getUser().getId_usuario();
        logins = new Login[dbPreguntas.cuentaLogins(idUsuario)];
        logins = dbPreguntas.logins(idUsuario);


        for (int i = 0; i < logins.length; i++) {
            crearFilas(i + 1, logins[i].getTema_test(), logins[i].getNum_test(), logins[i].getFallos(), logins[i].getFecha(), logins[i].getHora());
        }
        /*
        btn = new Button(this);
        btn.setText("Generar PDF");
        btn.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,150,getResources().getDisplayMetrics()));
        btn.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,getResources().getDisplayMetrics()));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        layoutBtn.addView(btn, layoutParamsBtn);
        layout.addView(layoutBtn, layoutParamsBtn);
        */
    }

    public void crearFilas(int i, String tema, String numTest, int fallo, String fecha, String hora){
        LinearLayout layoutHorizontal = new LinearLayout(this);
        layoutHorizontal.setOrientation(LinearLayout.HORIZONTAL);
        TextView txtID = new TextView(this);
        TextView txtTema = new TextView(this);
        TextView txtNumTest = new TextView(this);
        TextView txtFallos = new TextView(this);
        TextView txtFecha = new TextView(this);
        TextView txtHora = new TextView(this);

        txtID.setText(String.valueOf(i));
        txtID.setTextSize(13);
        txtID.setGravity(Gravity.CENTER);
        txtID.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20,getResources().getDisplayMetrics()));
        txtID.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,29,getResources().getDisplayMetrics()));
        txtID.setBackground(ContextCompat.getDrawable(this, R.drawable.style_borde));
        txtID.setTextColor(Color.DKGRAY);
        layoutHorizontal.addView(txtID, layoutParamsTxt);

        txtTema.setText(tema);
        txtTema.setTextSize(13);
        txtTema.setGravity(Gravity.CENTER);
        txtTema.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,47,getResources().getDisplayMetrics()));
        txtTema.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,29,getResources().getDisplayMetrics()));
        txtTema.setBackground(ContextCompat.getDrawable(this, R.drawable.style_borde));
        txtTema.setTextColor(Color.DKGRAY);
        layoutHorizontal.addView(txtTema, layoutParamsTxt);

        txtNumTest.setText(numTest);
        txtNumTest.setTextSize(13);
        txtNumTest.setGravity(Gravity.CENTER);
        txtNumTest.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,90,getResources().getDisplayMetrics()));
        txtNumTest.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,29,getResources().getDisplayMetrics()));
        txtNumTest.setBackground(ContextCompat.getDrawable(this, R.drawable.style_borde));
        txtNumTest.setTextColor(Color.DKGRAY);
        layoutHorizontal.addView(txtNumTest, layoutParamsTxt);

        txtFallos.setText(String.valueOf(fallo));
        txtFallos.setTextSize(13);
        txtFallos.setGravity(Gravity.CENTER);
        txtFallos.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,48,getResources().getDisplayMetrics()));
        txtFallos.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,29,getResources().getDisplayMetrics()));
        txtFallos.setBackground(ContextCompat.getDrawable(this, R.drawable.style_borde));
        txtFallos.setTextColor(Color.DKGRAY);
        layoutHorizontal.addView(txtFallos, layoutParamsTxt);

        txtFecha.setText(fecha);
        txtFecha.setTextSize(13);
        txtFecha.setGravity(Gravity.CENTER);
        txtFecha.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,80,getResources().getDisplayMetrics()));
        txtFecha.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,29,getResources().getDisplayMetrics()));
        txtFecha.setBackground(ContextCompat.getDrawable(this, R.drawable.style_borde));
        txtFecha.setTextColor(Color.DKGRAY);
        layoutHorizontal.addView(txtFecha, layoutParamsTxt);

        txtHora.setText(hora);
        txtHora.setTextSize(13);
        txtHora.setGravity(Gravity.CENTER);
        txtHora.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,80,getResources().getDisplayMetrics()));
        txtHora.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,29,getResources().getDisplayMetrics()));
        txtHora.setBackground(ContextCompat.getDrawable(this, R.drawable.style_borde));
        txtHora.setTextColor(Color.DKGRAY);
        layoutHorizontal.addView(txtHora, layoutParamsTxt);

        layout.addView(layoutHorizontal);
    }

    public void retroceder(View view) {
        Intent intent = new Intent(view.getContext(), PantallaPrincipal.class);
        startActivityForResult(intent, 0);
    }

}