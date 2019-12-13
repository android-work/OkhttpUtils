package com.okhttp.okhttp;

import android.util.Log;

/**
 * 创建时间：2019/12/13
 * <p>
 * 作者：Mr.Liu
 * <p>
 * 描述： log工具
 **/

public class LogUtils {

    private static boolean isLoge;
    private static boolean isLogd;
    private static boolean isLogw;
    private static boolean isLogi;

    public static void isLoge(boolean isLoge,boolean isLogw,boolean isLogd,boolean isLogi){

        LogUtils.isLoge = isLoge;
        LogUtils.isLogw = isLogw;
        LogUtils.isLogd = isLogd;
        LogUtils.isLogi = isLogi;

    }

    public static void loge(String log){

        if (isLoge){

            Log.e("LogUtils",log);
        }
    }

    public static void logi(String log){

        if (isLogi){

            Log.i("LogUtils",log);
        }
    }

    public static void logd(String log){

        if (isLogd){

            Log.d("LogUtils",log);
        }
    }

    public static void logw(String log){

        if (isLogw){

            Log.w("LogUtils",log);
        }
    }
}
