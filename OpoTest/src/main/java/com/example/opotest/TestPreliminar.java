package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
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

        System.out.println("ID FUNCIONANDO ----> " + TestTemas.getId());
        //cargarTests(1);

    }

    public void retroceder(View view)
    {
        Intent intent = new Intent (view.getContext(), TestTemas.class);
        startActivityForResult(intent, 0);
    }

    public void cargarTests(int tema)
    {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        LinearLayout.LayoutParams layoutParamsImg = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams. MATCH_PARENT ,
                LinearLayout.LayoutParams. WRAP_CONTENT ) ;
        layoutParamsImg.setMargins(0,50,0,0);
        LinearLayout.LayoutParams layoutParamsTxt = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams. MATCH_PARENT ,
                LinearLayout.LayoutParams. WRAP_CONTENT ) ;
        layoutParamsImg.setMargins(0,60,0,0);
        int numTests;
        final dbPreguntas dbPreguntas = new dbPreguntas(TestPreliminar.this);
        numTests = dbPreguntas.cuentaPreguntas(tema)/10;

        for (int i = 0; i < numTests; i++)
        {
            ImageView img = new ImageView(this);
            img.setBackgroundResource(R.mipmap.test1);
            img.setLayoutParams(layoutParamsImg);
            layout.addView(img, layoutParamsImg);
            TextView txt = new TextView(this);
            txt.setText("Test " + (i+1));
            txt.setTextSize(20);
            txt.setTypeface(null, Typeface.BOLD_ITALIC);
            txt.setLayoutParams(layoutParamsTxt);
            layout.addView(txt, layoutParamsTxt);
        }
    }
}