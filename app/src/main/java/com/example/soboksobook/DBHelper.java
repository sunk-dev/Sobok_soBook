package com.example.soboksobook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final  String  DB_NAME="mybookapp.db";
    private  static  final int DB_VERSION=2;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE mybook (_id INTEGER PRIMARY KEY"+" AUTOINCREMENT , date TEXT , title TEXT,content TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS mybook");
        onCreate(db);

    }
}

