package com.ilynn.modulea.util;

import android.content.Context;

import com.ilynn.base.util.SPUtils;
import com.ilynn.modulea.LoginActivity;

/**
 * 描述： TODO
 * 作者： gong.xl
 * 邮箱： gong.xl@belle.com.cn
 * 创建时间： 2017/12/22 14:23
 * 修改时间： 2017/12/22 14:23
 * 修改备注：
 */

public class LoginUtil {
    public static boolean isLogin(Context context) {
        return (boolean) SPUtils.get(context, "isLogin", false);
    }

    public static void loginOut(Context context){
        SPUtils.put(context, "isLogin", false);
    }
}
