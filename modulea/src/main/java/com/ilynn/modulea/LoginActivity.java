package com.ilynn.modulea;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ilynn.base.util.SPUtils;

public class LoginActivity extends AppCompatActivity {

    EditText et_name;
    EditText et_password;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulea_activity_login);
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
    }

    public void login(View view) {
        final String name = et_name.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
            showDialog();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (name.equals("admin") && password.equals("123456")) {

                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        SPUtils.put(LoginActivity.this, "isLogin", true);

                        Intent intent = getIntent();
                        if (intent!= null && intent.getBooleanExtra("isOther", false)) {
                            //如果是从其他模块跳转来的
                            Intent go = new Intent();
                            go.putExtra("isLogin", true);
                            setResult(0, go);
                        } else {
                            //
                            startActivity(new Intent(LoginActivity.this, TestAActivity.class));
                        }
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                    closeDialog();
                }
            }, 1000);
        }

    }

    private void showDialog() {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
            dialog.setTitle("提示");
            dialog.setMessage("正在登录，请稍后...");
        }
        dialog.show();
    }

    private void closeDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }


    //连按两次返回键推出程序
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long secondTime = System.currentTimeMillis();

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (secondTime - firstTime < 2000) {
                finish();
//                System.exit(0);
            } else {
                Toast.makeText(LoginActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
