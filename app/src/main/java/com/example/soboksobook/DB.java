package com.example.soboksobook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    private static final  String  DB_NAME="mybookapp.db";
    private  static  final int DB_VERSION=2;

    public DB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE mybookapp (_id INTRGER PRIMARY KEY"+" AUTOINCREMENT , date DATE , title TEXT,content TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS mybookapp");
        onCreate(db);

    }
}

