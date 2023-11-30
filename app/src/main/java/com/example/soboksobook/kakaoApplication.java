package com.example.soboksobook;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class kakaoApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        //kakao sdk 초기화
        KakaoSdk.init(this,"4a224fa5b29addfa992cef2e09436b2b");

    }
}
