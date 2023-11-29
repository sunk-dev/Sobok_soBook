package com.example.soboksobook;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class BookTimerActivity extends AppCompatActivity {
    private TextView countdownTimer;
    private CountDownTimer timer;

    Button mButton;
    EditText h, min,sec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        h=(EditText)findViewById(R.id.hour);
        min=(EditText) findViewById(R.id.min);
        sec=(EditText)findViewById(R.id.second);

//        countdownTimer = findViewById(R.id.countdown_timer);

        mButton = findViewById(R.id.start);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //텍스트가 Start면 startTimer
                //Stop면 일시중지




                if(mButton.getText().toString().equals("stop")){
                    timer.cancel();
                    mButton.setText("Start");
                }else{
                    mButton.setText("stop");
                    startTimer();

                }
            }
        });
    }


    private void startTimer() {

        int second = Integer.parseInt(sec.getText().toString());
        int minute=Integer.parseInt(min.getText().toString());
        int hour=Integer.parseInt(h.getText().toString());

        //작동시 수정 안되게
        h.setEnabled(false);
        min.setEnabled(false);
        sec.setEnabled(false);


        int countDownTime=second*1000+minute*60000+hour*3600000;
        
        //시간 입력해서 들어가게

        timer = new CountDownTimer(countDownTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long hours = (millisUntilFinished / 1000) / 3600;
                long minutes = ((millisUntilFinished / 1000) % 3600) / 60;
                long seconds = (millisUntilFinished / 1000) % 60;
//
//                h=(EditText)findViewById(R.id.hour);
//                min=(EditText) findViewById(R.id.min);
//                sec
//
                h.setText(String.format(Locale.getDefault(),"%02d",hours));
                min.setText(String.format(Locale.getDefault(),"%02d",minutes));
                sec.setText(String.format(Locale.getDefault(),"%02d",seconds));
//                String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
//                countdownTimer.setText(timeLeftFormatted);
            }


            @Override
            public void onFinish() {
                h.setText("00");
                min.setText("00");
                sec.setText("00");
//                countdownTimer.setText("00:00:00");
                Toast.makeText(BookTimerActivity.this, "Time's up", Toast.LENGTH_SHORT).show();
//                MediaPlayer mysong = MediaPlayer.create (BookTimerActivity.this,R.raw.alarm); // please add your alarm tone mp3 file
//                mysong.start ();
            }



        }.start();




    }}
