package com.example.opotest.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.opotest.Entidades.Preguntas;

public class dbPreguntas extends DbHelper{

    Context context;

    public dbPreguntas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public Preguntas verPregunta(int id) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Preguntas pregunta = null;
        Cursor cursorPreguntas;

        cursorPreguntas = db.rawQuery("SELECT * FROM " + TABLE_PREGUNTAS + " WHERE id_pregunta = " + id + " LIMIT 1", null);

        if (cursorPreguntas.moveToFirst()) {
            pregunta = new Preguntas();
            pregunta.setId_pregunta(cursorPreguntas.getInt(0));
            pregunta.setId_tema(cursorPreguntas.getInt(1));
            pregunta.setPregunta(cursorPreguntas.getString(2));
            pregunta.setRespuesta1(cursorPreguntas.getString(3));
            pregunta.setRespuesta2(cursorPreguntas.getString(4));
            pregunta.setRespuesta3(cursorPreguntas.getString(5));
            pregunta.setRespuesta4(cursorPreguntas.getString(6));
            pregunta.setRespuesta_correcta(cursorPreguntas.getString(7));

        }
        cursorPreguntas.close();

        return pregunta;
    }
}
