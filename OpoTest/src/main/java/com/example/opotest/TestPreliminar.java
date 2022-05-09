package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        int numTests;
        final dbPreguntas dbPreguntas = new dbPreguntas(TestPreliminar.this);
        numTests = dbPreguntas.cuentaPreguntas(2)/10;

        for (int i = 0; i < numTests; i++)
        {
            ImageView img = new ImageView(this);
            img.setBackgroundResource(R.mipmap.test2);
            img.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.addView(img);
            TextView txt = new TextView(this);
            txt.setText("Test " + (i+1));
            txt.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.addView(txt);
        }
        /*
        ImageView img = new ImageView(this);
        img.setBackgroundResource(R.mipmap.test2);
        img.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView txt = new TextView(this);
        txt.setText("pruebitasss");
        txt.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(txt);
        layout.addView(img);
        */
    }
}