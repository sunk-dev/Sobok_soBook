package com.example.soboksobook;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.*;

import java.util.Calendar;

public class BookNoteActivity extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    Button cancelBtn, saveBtn,datePickBtn;
    EditText editText,titleEdit;

    TextInputEditText contentEdit;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booknote);


        titleEdit=(EditText)findViewById(R.id.editTextTextMultiLine);
        contentEdit=(TextInputEditText) findViewById(R.id.editBOOkContent);

        //db
        helper=new DBHelper(this);
        try{
            db=helper.getWritableDatabase();

        }catch (SQLException ex){
            db=helper.getReadableDatabase();
        }






        cancelBtn=(Button) findViewById(R.id.cancelBtn);
        saveBtn=(Button) findViewById(R.id.saveBtn);
        datePickBtn=(Button)findViewById(R.id.datepickBtn);

        editText=(EditText) findViewById(R.id.editTextDate);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BookNoteActivity.this, BookListActivity.class);
                startActivity(intent);
            }
        });

        datePickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar=Calendar.getInstance();
                int pYear=calendar.get(Calendar.YEAR);
                int pMonth= calendar.get(Calendar.MONTH);
                int pDay=calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog= new DatePickerDialog(BookNoteActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                //1월은 0부터 시작함
                                month+=1;
                                String date= year+"/"+month+"/"+day;
                                editText.setText(date);


                            }
                        },pYear,pMonth,pDay);

                datePickerDialog.show();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date=editText.getText().toString();
                String title=titleEdit.getText().toString();
                String content=contentEdit.getText().toString();
                db.execSQL("INSERT INTO mybook VALUES ( null,'"+ date +"','"+ title +"','"+ content +"'); ");
                Toast.makeText(getApplicationContext(),"성공적으로 추가되었습니다",Toast.LENGTH_LONG).show();
            }
        });




    }


}
