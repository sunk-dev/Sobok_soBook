package com.example.soboksobook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BookNoteActivity extends AppCompatActivity {
    Button cancelBtn, saveBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booknote);
        cancelBtn=(Button) findViewById(R.id.cancelBtn);
        saveBtn=(Button) findViewById(R.id.saveBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BookNoteActivity.this, BookListActivity.class);
                startActivity(intent);
            }
        });
    }


}
