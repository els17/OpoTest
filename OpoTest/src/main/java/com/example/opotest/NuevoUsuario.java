package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opotest.Entidades.Users;
import com.example.opotest.db.dbPreguntas;

public class NuevoUsuario extends AppCompatActivity {

    TextView txtUser;
    TextView txtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);
        txtUser = (TextView) findViewById(R.id.txtUser);
        txtPwd = (TextView) findViewById(R.id.txtPwd);
    }

    public void crearUsuario(View view)
    {
        final dbPreguntas dbPreguntas = new dbPreguntas(this);
        boolean existe = false;

        if (!txtUser.getText().toString().isEmpty() && !txtPwd.getText().toString().isEmpty())
        {
            existe = dbPreguntas.comprobarUsuario(txtUser.getText());
            if(existe)
            {
                Toast.makeText(this, "Ya existe un usuario con ese nombre", Toast.LENGTH_LONG).show();
            }
            else{
                dbPreguntas.insertarUsuario(txtUser.getText(), txtPwd.getText());
                //Toast.makeText(this, "Usuario creado", Toast.LENGTH_LONG).show();
                Intent intent = new Intent (view.getContext(), PantallaPrincipal.class);
                startActivityForResult(intent, 0);
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
}