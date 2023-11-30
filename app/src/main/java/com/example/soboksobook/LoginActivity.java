package com.example.soboksobook;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public  class LoginActivity extends AppCompatActivity {
    Button kakaoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklogin);
        kakaoBtn=(Button)findViewById(R.id.btnLogin);
        Log.d("getkwyHash",""+getKeyHash(LoginActivity.this));

        //kakaosdk초기화

        Function2<OAuthToken,Throwable, Unit>callback= new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                updateKakaoLoginUi();
                return  null;
            }
        };

//        카카오 로그인 버튼
        kakaoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                카카오톡이 핸드폰에 설치되어있는지 확인
                if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)){
                    UserApiClient.getInstance().loginWithKakaoTalk(LoginActivity.this,callback);
                }else{
                    UserApiClient.getInstance().loginWithKakaoAccount(LoginActivity.this,callback);
                }
            }
        });

    }

    public  void updateKakaoLoginUi(){
        UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override
            public Unit invoke(User user, Throwable throwable) {

                if(user!=null){
                    Log.d("invoke:nickName",user.getKakaoAccount().getProfile().getNickname());
                    //프로파일에서 가져올수 있는거 닉네임 이미지 파일
                    String nickname = user.getKakaoAccount().getProfile().getNickname();
                    Intent intent= new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("RESULT",nickname);
                    Log.d("name",nickname);
                    setResult(RESULT_OK,intent);
                    finish();
                }else{
                    Log.d("isLogin","로그인 안됨!");

                }
                return null;
            }
        });
    }
    public static String getKeyHash(final Context context){
        PackageManager pm= context.getPackageManager();
        try{
            PackageInfo packageInfo=pm.getPackageInfo(context.getPackageName(),PackageManager.GET_SIGNATURES);
            if(packageInfo==null){
                return null;
            }
            for(Signature signature : packageInfo.signatures){
                try{
                    MessageDigest md=MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    return android.util.Base64.encodeToString(md.digest(), Base64.NO_WRAP);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        return  null;
    }
}