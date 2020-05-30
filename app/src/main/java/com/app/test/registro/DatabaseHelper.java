package com.app.test.registro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Estas constantes deberian estar en una clase aparte (SQLiteUtils o algo asi) pero el del curso las hace aca
    public static final String DATABASE_NAME = "registro_usuarios";
    public static final String TABLE_NAME = "usuarios";

    public static final String COLUMN0 = "id";
    public static final String COLUMN1 = "email";
    public static final String COLUMN2 = "contraseña";
    public static final String COLUMN3 = "nombre";
    public static final String COLUMN4 = "apellido";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL ("create table " + TABLE_NAME + " (" +
                    "id integer primary key autoincrement, " +
                    "email varchar(30), " +
                    "contraseña varchar(30), " +
                    "nombre varchar(40), " +
                    "apellido varchar(40))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + DATABASE_NAME);
        onCreate(db);
    }

    public boolean insert(String email, String contraseña, String nombre, String apellido){

        SQLiteDatabase db = this.getWritableDatabase(); //Crea o abre (si ya existe) la base de datos

        ContentValues content = new ContentValues();

        content.put(COLUMN1, email);
        content.put(COLUMN2, contraseña);
        content.put(COLUMN3, nombre);
        content.put(COLUMN4, apellido);

        if(db.insert(TABLE_NAME, null, content) == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData(String email, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN1 + " = \"" + email + "\" AND " + COLUMN2 + " = \"" + password + "\"";
        Cursor cursor = db.rawQuery(query, null);

        return cursor; //todo Look where i have to call this method. The code is not the same of the tutorial.
    }
}
