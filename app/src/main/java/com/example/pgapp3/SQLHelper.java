package com.example.pgapp3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SQLHelper extends SQLiteOpenHelper {

    public SQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("CREATE TABLE USUARIOS(Codigo int primary key  , Usuario TEXT,Contrasenia INTERGER)");
        BaseDeDatos.execSQL("CREATE TABLE PERSONAS(Codigo int primary key  , Nombre TEXT,Rut TEXT,Edad TEXT,Sexo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}
