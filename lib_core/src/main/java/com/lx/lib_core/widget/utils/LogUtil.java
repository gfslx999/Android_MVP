package com.lx.lib_core.widget.utils;

import android.util.Log;

public
/**
 *@author : 阿森
 *@date : 2020-11-03 10:08
 *@params : 
 *@description:
 */
class LogUtil {

    private static LogUtil instance = new LogUtil();

    public static LogUtil getInstance() {
        return instance;
    }

    public void logI(Object msg) {
        Log.i("gfslx", "logI: "+msg);
    }

    public void logE(Object msg) {
        Log.e("gfslx", "logE: "+msg);
    }

}
