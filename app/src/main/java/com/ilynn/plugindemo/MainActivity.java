package com.ilynn.plugindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ilynn.modulea.util.LoginUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.textview);
//        tv.append(TestAUtil.name);
    }

    public void gotoA(View view) {
        try {
            Class aClass = Class.forName("com.ilynn.modulea.TestAActivity");
            Intent intent = new Intent(MainActivity.this, aClass);
            intent.putExtra("data", "123-A");
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void gotoB(View view) {
        try {
            Class aClass = Class.forName("com.ilynn.moduleb.TestBActivity");
            Intent intent = new Intent(MainActivity.this, aClass);
            intent.putExtra("data", "456-B");
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loginOut(View view) {
        LoginUtil.loginOut(this);
        try {
            Class aClass = Class.forName("com.ilynn.modulea.LoginActivity");
            Intent intent = new Intent(MainActivity.this, aClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
