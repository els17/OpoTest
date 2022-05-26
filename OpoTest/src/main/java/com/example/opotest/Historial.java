package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.opotest.Entidades.Login;
import com.example.opotest.db.dbPreguntas;

public class Historial extends AppCompatActivity {

    LinearLayout layout;
    LinearLayout.LayoutParams layoutParamsTxt;
    final com.example.opotest.db.dbPreguntas dbPreguntas = new dbPreguntas(Historial.this);
    int idUsuario;
    Login[] logins;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        layout = (LinearLayout) findViewById(R.id.layout);
        layoutParamsTxt = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsTxt.setMargins(0, 0, 0, 0);
        idUsuario = InicioSesion.getUser().getId_usuario();
        logins = new Login[dbPreguntas.cuentaLogins(idUsuario)];

        logins = dbPreguntas.logins(idUsuario);


        for (int i = 0; i < logins.length; i++) {

            crearFilas(logins[i].getTema_test(), logins[i].getNum_test(), logins[i].getFallos(), logins[i].getFecha(), logins[i].getHora());

        }

    }

    public void crearFilas(String tema, String numTest, int fallo, String fecha, String hora){
        TextView txtTema = new TextView(this);
        TextView txtNumTest = new TextView(this);
        TextView txtFallos = new TextView(this);
        TextView txtFecha = new TextView(this);
        TextView txtHora = new TextView(this);

        txtTema.setText(tema);
        txtTema.setTextSize(13);
        //txtTema.setWidth(47);
        //txtTema.setHeight(29);
        txtTema.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,47,getResources().getDisplayMetrics()));
        txtTema.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,29,getResources().getDisplayMetrics()));
        txtTema.setBackground(ContextCompat.getDrawable(this, R.drawable.style_borde));
        txtTema.setTextColor(Color.DKGRAY);
        txtTema.setLayoutParams(layoutParamsTxt);
        layout.addView(txtTema, layoutParamsTxt);

        txtNumTest.setText(numTest);
        txtNumTest.setTextSize(13);
        //txtNumTest.setWidth(108);
        //txtNumTest.setHeight(29);
        txtNumTest.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,108,getResources().getDisplayMetrics()));
        txtNumTest.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,29,getResources().getDisplayMetrics()));
        txtNumTest.setBackground(ContextCompat.getDrawable(this, R.drawable.style_borde));
        txtNumTest.setTextColor(Color.DKGRAY);
        txtNumTest.setLayoutParams(layoutParamsTxt);
        layout.addView(txtNumTest, layoutParamsTxt);

        txtFallos.setText(String.valueOf(fallo));
        txtFallos.setTextSize(13);
        //txtFallos.setWidth(48);
        //txtFallos.setHeight(29);
        txtFallos.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,48,getResources().getDisplayMetrics()));
        txtFallos.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,29,getResources().getDisplayMetrics()));
        txtFallos.setBackground(ContextCompat.getDrawable(this, R.drawable.style_borde));
        txtFallos.setTextColor(Color.DKGRAY);
        txtFallos.setLayoutParams(layoutParamsTxt);
        layout.addView(txtFallos, layoutParamsTxt);

        txtFecha.setText(fecha);
        txtFecha.setTextSize(13);
        //txtFecha.setWidth(100);
        //txtFecha.setHeight(29);
        txtFecha.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100,getResources().getDisplayMetrics()));
        txtFecha.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,29,getResources().getDisplayMetrics()));
        txtFecha.setBackground(ContextCompat.getDrawable(this, R.drawable.style_borde));
        txtFecha.setTextColor(Color.DKGRAY);
        txtFecha.setLayoutParams(layoutParamsTxt);
        layout.addView(txtFecha, layoutParamsTxt);

        txtHora.setText(hora);
        txtHora.setTextSize(13);
        //txtHora.setWidth(100);
        //txtHora.setHeight(29);
        txtHora.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100,getResources().getDisplayMetrics()));
        txtHora.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,29,getResources().getDisplayMetrics()));
        txtHora.setBackground(ContextCompat.getDrawable(this, R.drawable.style_borde));
        txtHora.setTextColor(Color.DKGRAY);
        txtHora.setLayoutParams(layoutParamsTxt);
        layout.addView(txtHora, layoutParamsTxt);
    }

    public void retroceder(View view) {
        Intent intent = new Intent(view.getContext(), PantallaPrincipal.class);
        startActivityForResult(intent, 0);
    }

}