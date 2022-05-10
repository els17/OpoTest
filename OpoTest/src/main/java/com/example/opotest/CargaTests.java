package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.opotest.db.dbPreguntas;

public class CargaTests extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_tests);

        switch (TestTemas.getId())
        {
            case 1:
                cargarTests(TestTemas.getId());
                break;
            case 2:
                cargarTests(TestTemas.getId());
                break;
            case 3:
                cargarTests(TestTemas.getId());
                break;
            case 4:
                cargarTests(TestTemas.getId());
                break;
            case 5:
                cargarTests(TestTemas.getId());
                break;
            case 6:
                cargarTests(TestTemas.getId());
                break;
            case 7:
                cargarTests(TestTemas.getId());
                break;
            case 8:
                cargarTests(TestTemas.getId());
                break;
            case 9:
                cargarTests(TestTemas.getId());
                break;
            case 10:
                cargarTests(TestTemas.getId());
                break;
            case 11:
                cargarTests(TestTemas.getId());
                break;
            case 12:
                cargarTests(TestTemas.getId());
                break;
        }
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
        final dbPreguntas dbPreguntas = new dbPreguntas(CargaTests.this);
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