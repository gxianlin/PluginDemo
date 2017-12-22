package com.ilynn.plugindemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ilynn.base.util.LogUtils;
import com.ilynn.modulea.util.LoginUtil;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (LoginUtil.isLogin(WelcomeActivity.this)) {
                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                    Log.e("tag","已登录，跳转主页面");
                    finish();
                } else {
                    try {
                        Class aClass = Class.forName("com.ilynn.modulea.LoginActivity");
                        Intent intent = new Intent(WelcomeActivity.this, aClass);
                        intent.putExtra("isOther", true);
                        startActivityForResult(intent, 1);
                        Log.e("tag","未登录，跳转登录模块登录页面");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 1500);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 0) {
            if (data != null && data.getBooleanExtra("isLogin", false)) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                Log.e("tag","登录模块登录页面登录成功，跳转主页面");
                finish();
            }
        }
    }
}
