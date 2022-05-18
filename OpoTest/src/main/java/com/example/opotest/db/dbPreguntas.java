package com.example.opotest.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.opotest.Entidades.Preguntas;
import com.example.opotest.Entidades.Temas;

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

    public Preguntas verPregunta(int id, int tema) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Preguntas pregunta = null;
        Cursor cursorPreguntas;

        cursorPreguntas = db.rawQuery("SELECT * FROM " + TABLE_PREGUNTAS + " WHERE id_pregunta = " + id + " AND id_tema = " + tema +  " LIMIT 1", null);

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

    public int cuentaPreguntas(int tema)
    {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int numPregs = 0;
        Cursor cursorPreguntas;

        cursorPreguntas = db.rawQuery("SELECT count(id_pregunta) FROM " + TABLE_PREGUNTAS + " WHERE id_tema = " + tema +  " LIMIT 1", null);
        if (cursorPreguntas.moveToFirst()) {
            numPregs = cursorPreguntas.getInt(0);
        }
        cursorPreguntas.close();

        return (numPregs);
    }

    public int minIdPregunta(int tema)
    {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int min = 0;
        Cursor cursorPreguntas;

        cursorPreguntas = db.rawQuery("SELECT min(id_pregunta) FROM " + TABLE_PREGUNTAS + " WHERE id_tema = " + tema +  " LIMIT 1", null);
        if (cursorPreguntas.moveToFirst()) {
            min = cursorPreguntas.getInt(0);
        }
        cursorPreguntas.close();

        return (min);
    }

    public Temas verTema(int id) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Temas tema = null;
        Cursor cursorTemas;

        cursorTemas = db.rawQuery("SELECT * FROM " + TABLE_TEMAS + " WHERE id_tema = " + id + " LIMIT 1", null);

        if (cursorTemas.moveToFirst()) {
            tema = new Temas();
            tema.setId_tema(cursorTemas.getInt(0));
            tema.setNombre_tema(cursorTemas.getString(1));

        }
        cursorTemas.close();

        return tema;
    }

    public int cuentaTemas()
    {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int numTemas = 0;
        Cursor cursorPreguntas;

        cursorPreguntas = db.rawQuery("SELECT count(id_tema) FROM " + TABLE_TEMAS + " LIMIT 1", null);
        if (cursorPreguntas.moveToFirst()) {
            numTemas = cursorPreguntas.getInt(0);
        }
        cursorPreguntas.close();

        return (numTemas);
    }
}
