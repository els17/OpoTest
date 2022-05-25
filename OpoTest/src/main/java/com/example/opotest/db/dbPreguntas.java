package com.example.opotest.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.opotest.Entidades.Preguntas;
import com.example.opotest.Entidades.Temas;
import com.example.opotest.Entidades.Users;

public class dbPreguntas extends DbHelper{

    Context context;

    public dbPreguntas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public Preguntas verPregunta(int id) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

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
        SQLiteDatabase db = dbHelper.getReadableDatabase();

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
        SQLiteDatabase db = dbHelper.getReadableDatabase();

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
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        int min = 0;
        Cursor cursorPreguntas;

        cursorPreguntas = db.rawQuery("SELECT min(id_pregunta) FROM " + TABLE_PREGUNTAS + " WHERE id_tema = " + tema +  " LIMIT 1", null);
        if (cursorPreguntas.moveToFirst()) {
            min = cursorPreguntas.getInt(0);
        }
        cursorPreguntas.close();

        return (min);
    }

    public Preguntas[] preguntasTema(int tema)
    {
        int z = 0;
        int idMin = minIdPregunta(tema);
        Preguntas[] pregs = new Preguntas[cuentaPreguntas(tema)];
        System.out.println(cuentaPreguntas(tema) + " " + pregs.length);
        for(int i = idMin; i < (idMin + cuentaPreguntas(tema)); i++)
        {
            pregs[z] = verPregunta(i);
            z++;
        }

        return (pregs);
    }

    public Temas verTema(int id) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

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
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        int numTemas = 0;
        Cursor cursorPreguntas;

        cursorPreguntas = db.rawQuery("SELECT count(id_tema) FROM " + TABLE_TEMAS + " LIMIT 1", null);
        if (cursorPreguntas.moveToFirst()) {
            numTemas = cursorPreguntas.getInt(0);
        }
        cursorPreguntas.close();

        return (numTemas);
    }

    public boolean comprobarUsuario(CharSequence nombre){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        boolean existe = false;
        Cursor cursorUsers;

        cursorUsers = db.rawQuery("SELECT EXISTS (SELECT 1 FROM " + TABLE_USERS + " WHERE nombre_usuario LIKE '" + nombre + "') LIMIT 1", null);

        if (cursorUsers.moveToFirst()) {
            if (cursorUsers.getInt(0) == 1)
            {
                existe = true;
            }
        }
        cursorUsers.close();

        return existe;
    }

    public Users buscarUsuario(CharSequence nombre){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Users user = null;
        Cursor cursorUsers;

        cursorUsers = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE nombre_usuario LIKE '" + nombre + "' LIMIT 1", null);

        if (cursorUsers.moveToFirst()) {
            user = new Users();
            user.setId_usuario(cursorUsers.getInt(0));
            user.setNombre_usuario(cursorUsers.getString(1));
            user.setContraseña(cursorUsers.getString(2));
        }
        cursorUsers.close();

        return user;
    }

    public void insertarUsuario(CharSequence nombre_usuario, CharSequence contraseña){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.execSQL("INSERT INTO " + TABLE_USERS + " (nombre_usuario, contraseña) VALUES ('" + nombre_usuario + "', '" + contraseña + "')");
    }

    public void insertarLogin(int id_user, String tema_test, String num_test, int fallos){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.execSQL("INSERT INTO " + TABLE_LOGIN + " (id_user, tema_test, num_test, fallos) VALUES ( " + id_user + ", '" + tema_test + "', '" + num_test + "', " + fallos + " )");
    }
}
