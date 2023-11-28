package com.example.soboksobook;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BookNoteActivity extends AppCompatActivity {
    Button cancelBtn, saveBtn,datePickBtn;
    EditText editText;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booknote);
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


    }


}
