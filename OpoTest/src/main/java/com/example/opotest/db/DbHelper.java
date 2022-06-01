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

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PREGUNTAS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PREGUNTAS);
        onCreate(sqLiteDatabase);
    }
}
