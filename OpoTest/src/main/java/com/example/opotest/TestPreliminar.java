package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.opotest.db.dbPreguntas;

public class TestPreliminar extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_preliminar);

        cargarTests();
    }

    public void retroceder(View view)
    {
        Intent intent = new Intent (view.getContext(), TestTemas.class);
        startActivityForResult(intent, 0);
    }

    public void cargarTests()
    {
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
        int numTests;
        final dbPreguntas dbPreguntas = new dbPreguntas(TestPreliminar.this);
        numTests = dbPreguntas.cuentaPreguntas(2)/10;

        ImageView img = new ImageView(this);
        img.setBackgroundResource(R.mipmap.test2);
        img.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}