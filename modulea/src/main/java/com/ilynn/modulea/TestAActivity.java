package com.ilynn.modulea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class TestAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_a);
        String data = getIntent().getStringExtra("data");
        Toast.makeText(this, "我是A="+data, Toast.LENGTH_SHORT).show();
    }

    public void gotoModuleB(View view) {
        try {
            Class aClass = Class.forName("com.ilynn.moduleb.TestBActivity");
            Intent intent = new Intent(TestAActivity.this,aClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void gotoApp(View view) {
        try {
            Class aClass = Class.forName("com.ilynn.plugindemo.MainActivity");
            Intent intent = new Intent(TestAActivity.this,aClass);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
