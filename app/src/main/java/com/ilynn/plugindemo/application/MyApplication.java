package com.ilynn.plugindemo.application;

import android.app.Application;
import android.util.Log;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/12/21 0021 22:38
 * 修改日期: 2017/12/21 0021
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //以下两行可理解为一些第三方SDK初始化操作

        //完成moduleA的初始化操作,即将各module的初始化操作迁移到此
        Log.e("tag", "ApplicationA");
        //完成moduleB的初始化操作
        Log.e("tag", "ApplicationB");
    }
}
