package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TestTemas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_temas);
    }

    public void retroceder(View view)
    {
        Intent intent = new Intent (view.getContext(), PantallaPrincipal.class);
        startActivityForResult(intent, 0);
    }
    
    public void pruebaBoton(View view){
        Toast.makeText(this, "FUNCIONA NICE :))", Toast.LENGTH_SHORT).show();
    }
}