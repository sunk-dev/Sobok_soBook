package com.example.soboksobook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton bookNoteBtn  =(ImageButton) findViewById(R.id.bookNote);
        ImageButton bookListBtn  =(ImageButton) findViewById(R.id.booklist);
        ImageButton bookMapBtn  =(ImageButton) findViewById(R.id.bookMap);
        ImageButton bookTimerBtn  =(ImageButton) findViewById(R.id.bookTimer);
    }

    //터치시 버튼값 별로 구분하기

    public void  onBtnClick(View v){

        Intent intent = new Intent();
        int id = v.getId();
        if (id==R.id.booklist)intent=new Intent(MainActivity.this, BookNoteActivity.class);
        else if (id==R.id.bookNote) intent=new Intent(MainActivity.this, BookListActivity.class);
        else if(id==R.id.bookMap) intent=new Intent(MainActivity.this, BookMapActivity.class);
        else if (id==R.id.bookTimer) intent=new Intent(MainActivity.this, BookTimerActivity.class);

        startActivity(intent);

    }

}