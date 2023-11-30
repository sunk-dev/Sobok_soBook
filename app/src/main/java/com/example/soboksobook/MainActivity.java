package com.example.soboksobook;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.network.UtilityKt;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText editTextDate;
    TextView loginText;
    static  final int  GET_RESULT=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Utility.getKeyHash(this);가 에러날때 아래 이용할것
//        String keyHash = Utility.INSTANCE.getKeyHash(this);
//        Log.d("kakao keyyhash",keyHash);

        ImageButton bookNoteBtn  =(ImageButton) findViewById(R.id.bookNote);
        ImageButton bookListBtn  =(ImageButton) findViewById(R.id.booklist);
        ImageButton bookMapBtn  =(ImageButton) findViewById(R.id.bookMap);
        ImageButton bookTimerBtn  =(ImageButton) findViewById(R.id.bookTimer);
        loginText=(TextView) findViewById(R.id.nameText);



    }

    //터치시 버튼값 별로 구분하기

    public void  onBtnClick(View v){

        Intent intent = new Intent();
        //로그인 화면에 이름이 있으면 버튼 활성화 아니면 로그인 화면으로 먼저가게 하기!
        if(loginText.getText().toString().equals("로그인해주세요!")){
            intent=new Intent(MainActivity.this, LoginActivity.class);
            startActivityForResult(intent,GET_RESULT);
        }else{

            int id = v.getId();
            if (id==R.id.booklist)intent=new Intent(MainActivity.this, BookNoteActivity.class);
            else if (id==R.id.bookNote) intent=new Intent(MainActivity.this, BookListActivity.class);
            else if(id==R.id.bookMap){
                Uri uri=Uri.parse("geo: 37.564213,127.001698");
//            intent= new Intent(MainActivity.this,uri,BookMapActivity.class);

//            intent=new Intent(Intent.ACTION_VIEW,uri); //명시적..
            }
            else if (id==R.id.bookTimer) intent=new Intent(MainActivity.this, BookMapActivity.class);


            startActivity(intent);

        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_RESULT) {
            if (resultCode == RESULT_OK) {
                loginText.setText("" + data.getStringExtra("RESULT"));
            }
        }
    }
}