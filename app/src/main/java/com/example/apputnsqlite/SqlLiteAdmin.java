package com.example.apputnsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlLiteAdmin extends SQLiteOpenHelper {

    public SqlLiteAdmin(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS autores ( id INT NOT NULL PRIMARY KEY, nombres TEXT(50), apellidos TEXT(50), isoPais Text(5), edad INT )");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS libros ( id INT NOT NULL PRIMARY KEY, titulo TEXT(100), idAutor INT, isbn TEXT(30), anioPublicacion INT, revision INT, nroHojas INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
