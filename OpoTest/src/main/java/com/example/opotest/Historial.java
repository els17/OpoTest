package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
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
        txtTema.setTextColor(Color.DKGRAY);
        txtTema.setLayoutParams(layoutParamsTxt);
        layout.addView(txtTema, layoutParamsTxt);

        txtNumTest.setText(numTest);
        txtNumTest.setTextSize(13);
        txtNumTest.setTextColor(Color.DKGRAY);
        txtNumTest.setLayoutParams(layoutParamsTxt);
        layout.addView(txtNumTest, layoutParamsTxt);

        txtFallos.setText(String.valueOf(fallo));
        txtFallos.setTextSize(13);
        txtFallos.setTextColor(Color.DKGRAY);
        txtFallos.setLayoutParams(layoutParamsTxt);
        layout.addView(txtFallos, layoutParamsTxt);

        txtFecha.setText(fecha);
        txtFecha.setTextSize(13);
        txtFecha.setTextColor(Color.DKGRAY);
        txtFecha.setLayoutParams(layoutParamsTxt);
        layout.addView(txtFecha, layoutParamsTxt);

        txtHora.setText(hora);
        txtHora.setTextSize(13);
        txtHora.setTextColor(Color.DKGRAY);
        txtHora.setLayoutParams(layoutParamsTxt);
        layout.addView(txtHora, layoutParamsTxt);
    }
}