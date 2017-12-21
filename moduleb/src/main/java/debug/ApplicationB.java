package debug;

import android.app.Application;
import android.util.Log;

/**
 * 描述：TODO
 * 作者：gong.xl
 * 创建日期：2017/12/21 0021 22:33
 * 修改日期: 2017/12/21 0021
 * 修改备注：
 * 邮箱：gong.xl@wonhigh.cn
 */
public class ApplicationB extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //用打印一句话作为此个项目一些初始化操作
        Log.e("tag","ApplicationB");
    }
}
