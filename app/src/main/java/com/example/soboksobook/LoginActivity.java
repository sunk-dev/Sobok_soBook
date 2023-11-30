package com.example.soboksobook;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import com.kakao.sdk.common.util.Utility;


import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);
        String keyHash = Utility.INSTANCE.getKeyHash(this);
        System.out.println("keyHash = " + keyHash);


        Log.d(TAG, "keyhash : ${Utility.getKeyHash(this)}");

    }

}
