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

    int numTests;
    static int idTest;

    LinearLayout layout;
    LinearLayout.LayoutParams layoutParamsImg;
    LinearLayout.LayoutParams layoutParamsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_tests);
        layout = (LinearLayout) findViewById(R.id.layout);
        layoutParamsImg = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams. MATCH_PARENT ,
                LinearLayout.LayoutParams. WRAP_CONTENT ) ;
        layoutParamsImg.setMargins(0,60,0,0);
        layoutParamsTxt = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams. MATCH_PARENT ,
                LinearLayout.LayoutParams. WRAP_CONTENT ) ;
        layoutParamsTxt.setMargins(0,10,0,0);
        TextView txt = new TextView(this);

        switch (TestTemas.getId())
        {
            case 1:
                txt.setText("Test sobre el " + getString(R.string.txtTituloPrelim));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
            case 2:
                txt.setText("Test sobre el " + getString(R.string.txtTituloI));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
            case 3:
                txt.setText("Test sobre el " + getString(R.string.txtTituloII));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
            case 4:
                txt.setText("Test sobre el " + getString(R.string.txtTituloIII));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
            case 5:
                txt.setText("Test sobre el " + getString(R.string.txtTituloIV));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
            case 6:
                txt.setText("Test sobre el " + getString(R.string.txtTituloV));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
            case 7:
                txt.setText("Test sobre el " + getString(R.string.txtTituloVI));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
            case 8:
                txt.setText("Test sobre el " + getString(R.string.txtTituloVII));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
            case 9:
                txt.setText("Test sobre el " + getString(R.string.txtTituloVIII));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
            case 10:
                txt.setText("Test sobre el " + getString(R.string.txtTituloIX));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
            case 11:
                txt.setText("Test sobre el " + getString(R.string.txtTituloX));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
            case 12:
                txt.setText("Test sobre el " + getString(R.string.txtTituloXI));
                txt.setTextSize(24);
                layout.addView(txt, layoutParamsTxt);
                cargarTests(TestTemas.getId());
                break;
        }
    }

    public void cargarTests(int tema)
    {
        final dbPreguntas dbPreguntas = new dbPreguntas(CargaTests.this);
        numTests = dbPreguntas.cuentaPreguntas(tema)/10;

        for (int i = 0; i < numTests; i++)
        {
            ImageView img = new ImageView(this);
            img.setBackgroundResource(R.mipmap.test1);
            img.setLayoutParams(layoutParamsImg);
            int finalI = i;
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (v.getContext(), CargaPreguntas.class);
                    startActivityForResult(intent, 0);
                    idTest = (finalI + 1);
                }
            });
            layout.addView(img, layoutParamsImg);
            TextView txt = new TextView(this);
            txt.setText("Test " + (i+1));
            txt.setTextSize(20);
            txt.setTypeface(null, Typeface.BOLD_ITALIC);
            txt.setLayoutParams(layoutParamsTxt);
            layout.addView(txt, layoutParamsTxt);
        }
    }

    public static int getIdTest() {
        return idTest;
    }

    public void retroceder(View view)
    {
        Intent intent = new Intent (view.getContext(), TestTemas.class);
        startActivityForResult(intent, 0);
    }
}