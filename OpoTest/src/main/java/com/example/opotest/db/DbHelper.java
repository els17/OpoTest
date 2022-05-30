package com.example.opotest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "opoTest.db";
    public static final String TABLE_PREGUNTAS = "t_preguntas";
    public static final String TABLE_TEMAS = "t_temas";
    public static final String TABLE_LOGIN = "t_login";
    public static final String TABLE_USERS = "t_users";

    /*private static String DB_PATH = "C://Users//elena//OneDrive//Escritorio//tfg//";
    private static String DB_NAME = "opotest";
    private static final String DATABASE_NOMBRE2 = DB_PATH+DB_NAME;*/


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    /*
    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    */

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        /*
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PREGUNTAS + "(" +
                "id_pregunta INTEGER," +
                "id_tema INTEGER NOT NULL," +
                "pregunta TEXT NOT NULL," +
                "respuesta1 TEXT NOT NULL," +
                "respuesta2 TEXT NOT NULL," +
                "respuesta3 TEXT NOT NULL," +
                "respuesta_correcta TEXT NOT NULL," +
                "CONSTRAINT preguntas_pk PRIMARY KEY (id_pregunta)," +
                "CONSTRAINT preguntas_fk FOREIGN KEY (id_tema)" +
                "REFERENCES " + TABLE_TEMAS + " (id_tema) MATCH SIMPLE)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_TEMAS + "(" +
                "id_tema INTEGER NOT NULL," +
                "nombre_tema TEXT NOT NULL," +
                "CONSTRAINT tema_pk PRIMARY KEY (id_tema))");
    */


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PREGUNTAS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PREGUNTAS);
        onCreate(sqLiteDatabase);
    }
}
