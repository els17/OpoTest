package com.example.opotest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opotest.db.dbPreguntas;

import org.w3c.dom.Text;

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
        Intent intent = new Intent (view.getContext(), TestPreliminar.class);
        startActivityForResult(intent, 0);
        switch (view.getId())
        {
            case R.id.txtTituloPrelim:
                System.out.println("FUNCIONA");
                id = 1;
        }
    }

    public static int getId() {
        return id;
    }

}