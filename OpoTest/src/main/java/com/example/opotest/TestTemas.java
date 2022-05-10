package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TestTemas extends AppCompatActivity {

    static int id;

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

    public void testPre(View view)
    {
        Intent intent = new Intent (view.getContext(), CargaTests.class);
        startActivityForResult(intent, 0);
        switch (view.getId())
        {
            case R.id.imgPre:
                id = 1;
                break;
            case R.id.txtPre:
                id = 1;
                break;
            case R.id.imgTituloI:
                id = 2;
                break;
            case R.id.txtTituloI:
                id = 2;
                break;
            case R.id.imgTituloII:
                id = 3;
                break;
            case R.id.txtTituloII:
                id = 3;
                break;
            case R.id.imgTituloIII:
                id = 4;
                break;
            case R.id.txtTituloIII:
                id = 4;
                break;
            case R.id.imgTituloIV:
                id = 5;
                break;
            case R.id.txtTituloIV:
                id = 5;
                break;
            case R.id.imgTituloV:
                id = 6;
                break;
            case R.id.txtTituloV:
                id = 6;
                break;
            case R.id.imgTituloVI:
                id = 7;
                break;
            case R.id.txtTituloVI:
                id = 7;
                break;
            case R.id.imgTituloVII:
                id = 8;
                break;
            case R.id.txtTituloVII:
                id = 8;
                break;
            case R.id.imgTituloVIII:
                id = 9;
                break;
            case R.id.txtTituloVIII:
                id = 9;
                break;
            case R.id.imgTituloIX:
                id = 10;
                break;
            case R.id.txtTituloIX:
                id = 10;
                break;
            case R.id.imgTituloX:
                id = 11;
                break;
            case R.id.txtTituloX:
                id = 11;
                break;
            case R.id.imgTituloXI:
                id = 12;
                break;
            case R.id.txtTituloXI:
                id = 12;
                break;
        }
    }

    public static int getId() {
        return id;
    }

}