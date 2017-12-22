package com.ilynn.moduleb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class TestBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduleb_activity_test_b);
        String data = getIntent().getStringExtra("data");
        Toast.makeText(this, "我是B="+data, Toast.LENGTH_SHORT).show();
    }
    public void gotoModuleA(View view) {
        try {
            Class aClass = Class.forName("com.ilynn.modulea.TestAActivity");
            Intent intent = new Intent(TestBActivity.this,aClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void gotoApp(View view) {
        try {
            Class aClass = Class.forName("com.ilynn.plugindemo.MainActivity");
            Intent intent = new Intent(TestBActivity.this,aClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
