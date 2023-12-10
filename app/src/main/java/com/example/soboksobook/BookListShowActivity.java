package com.example.soboksobook;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class BookListShowActivity extends AppCompatActivity {


    DBHelper helper;
    SQLiteDatabase db;
    Button editBtn;
    EditText titleEdit,dateEdit;
    TextInputEditText contentEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booknoteview2);

        titleEdit = (EditText) findViewById(R.id.editTextTextMultiLine);
        contentEdit = (TextInputEditText) findViewById(R.id.editBOOkContent);
        dateEdit=(EditText)findViewById(R.id.editTextDate);
        editBtn=(Button) findViewById(R.id.saveBtn);


        //db
        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();

        } catch (SQLException ex) {
            db = helper.getReadableDatabase();
        }

        Intent intent = getIntent();
        //int noteNo = intent.getIntExtra("noteNo", 0);
//        Log.d("noteNo", String.valueOf(noteNo));
//        System.out.println("noteNo = " + noteNo);
//        String sql = "SELECT * FROM mybook WHERE id="+(noteNo-1);
        String content = intent.getStringExtra("content");
        String title =intent.getStringExtra("title");
        //String title2 =intent.getStringExtra("title2");
        String date =intent.getStringExtra("date");


        contentEdit.setText(content);
        titleEdit.setText(title);
        dateEdit.setText(date);
        contentEdit.setEnabled(false);
        titleEdit.setEnabled(false);
        dateEdit.setEnabled(false);

//        Cursor c = db.rawQuery("SELECT * FROM mybook WHERE id=0", null);
//        while (c.moveToNext()) {
//            content = String.valueOf(c.getString(1));
//            contentEdit.setText(content);
//        }


    }
}




