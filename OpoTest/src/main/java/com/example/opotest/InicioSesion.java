package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opotest.Entidades.Users;
import com.example.opotest.db.dbPreguntas;

public class InicioSesion extends AppCompatActivity {

    TextView txtUser;
    TextView txtPwd;
    static Users user;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        txtUser = (TextView) findViewById(R.id.txtUser);
        txtPwd = (TextView) findViewById(R.id.txtPwd);

    }

    public void iniciarSesion(View view)
    {
        final dbPreguntas dbPreguntas = new dbPreguntas(this);
        boolean existe = false;

        if (!txtUser.getText().toString().isEmpty() && !txtPwd.getText().toString().isEmpty())
        {
            existe = dbPreguntas.comprobarUsuario(txtUser.getText());
            user = dbPreguntas.buscarUsuario(txtUser.getText());
            if(existe && (txtPwd.getText().toString().equals(user.getContraseña())))
            {
                id = user.getId_usuario();
                Intent intent = new Intent (view.getContext(), PantallaPrincipal.class);
                startActivityForResult(intent, 0);
            }
            else{
                Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
            }
        }
        if (txtUser.getText().toString().isEmpty() && txtPwd.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Introduzca un nombre y una contraseña", Toast.LENGTH_LONG).show();
        }
        else if (txtUser.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Introduzca un nombre de usuario", Toast.LENGTH_LONG).show();
        }
        else if (txtPwd.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Introduzca una contraseña", Toast.LENGTH_LONG).show();
        }
    }

    public void crearUsuario(View view)
    {
        Intent intent = new Intent (view.getContext(), NuevoUsuario.class);
        startActivityForResult(intent, 0);
    }

    public static Users getUser() {
        return user;
    }
}