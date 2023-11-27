package com.example.soboksobook;

import androidx.appcompat.app.AppCompatActivity;

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

    public void   onBtnClick(View v){
        switch (v.getId()){

        }

    }

}