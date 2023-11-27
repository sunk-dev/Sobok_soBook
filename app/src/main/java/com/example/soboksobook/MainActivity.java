package com.example.soboksobook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        de.hdodenhof.circleimageview.CircleImageView bookNoteBtn  =(de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.bookNote);
        de.hdodenhof.circleimageview.CircleImageView bookListBtn  =(de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.booklist);
        de.hdodenhof.circleimageview.CircleImageView bookMapBtn  =(de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.bookMap);
        de.hdodenhof.circleimageview.CircleImageView bookTimerBtn  =(de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.bookTimer);
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