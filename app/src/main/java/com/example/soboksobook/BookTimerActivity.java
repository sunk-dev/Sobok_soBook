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
import android.widget.LinearLayout;
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
    LinearLayout continueEndView;

    Button mButton ,ContinueBtn,EndBtn;
    EditText h, min,sec;
    boolean isFirst=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        continueEndView=(LinearLayout) findViewById(R.id.ButtonsView);
        continueEndView.setVisibility(View.GONE);

        h=(EditText)findViewById(R.id.hour);
        min=(EditText) findViewById(R.id.min);
        sec=(EditText)findViewById(R.id.second);

        ContinueBtn=(Button)findViewById(R.id.coinueBtn);
        EndBtn=(Button)findViewById(R.id.endBtn);

//        countdownTimer = findViewById(R.id.countdown_timer);

        mButton = findViewById(R.id.start);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //텍스트가 Start면 startTimer
                //Stop면 일시중지

                //에러: 일시 중지는 되는데 다시 시작이 안됨.



                /**
                 * start -> stop로 바꾸기
                 * stop-> stop버튼 없개고 continueEndView 보이게 하기
                 *         continue -> 계속 카운트 다운
                 *         end-> 완전히 끝내고 리셋
                 */


                if(mButton.getText().toString().equals("Start")){
                    mButton.setText("Stop");
                    startTimer(isFirst);

                }else if(mButton.getText().toString().equals("Stop")){
                    timer.cancel();
                    mButton.setText("Start");
                    mButton.setVisibility(View.GONE);
                    continueEndView.setVisibility(View.VISIBLE);
                    isFirst=false;

                }

            }
        });

        ContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mButton.setText("Stop");
                mButton.setVisibility(View.VISIBLE);
                continueEndView.setVisibility(View.GONE);
                isFirst=true;
                startTimer(isFirst);

            }
        });

        EndBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.onFinish();
                mButton.setVisibility(View.VISIBLE);
                continueEndView.setVisibility(View.GONE);

            }
        });

    }



    private void startTimer(boolean isFirst) {

        int second = Integer.parseInt(sec.getText().toString());
        int minute=Integer.parseInt(min.getText().toString());
        int hour=Integer.parseInt(h.getText().toString());

        //작동시 수정 안되게
        h.setEnabled(false);
        min.setEnabled(false);
        sec.setEnabled(false);


        int countDownTime=second*1000+minute*60000+hour*3600000;

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
                mButton.setText("Start");
                h.setEnabled(true);
                min.setEnabled(true);
                sec.setEnabled(true);
//                countdownTimer.setText("00:00:00");
                Toast.makeText(BookTimerActivity.this, "Time's up", Toast.LENGTH_SHORT).show();
//                MediaPlayer mysong = MediaPlayer.create (BookTimerActivity.this,R.raw.alarm); // please add your alarm tone mp3 file
//                mysong.start ();
            }



        };
        if(isFirst){
            timer.start();

        }else{
            second = Integer.parseInt(sec.getText().toString());
            minute=Integer.parseInt(min.getText().toString());
            hour=Integer.parseInt(h.getText().toString());
            countDownTime=second*1000+minute*60000+hour*3600000;
            timer.onTick(countDownTime);

        }


        }











    }
