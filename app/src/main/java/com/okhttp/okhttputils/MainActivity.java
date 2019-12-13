package com.okhttp.okhttputils;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.okhttp.okhttp.HttpRequestCallback;
import com.okhttp.okhttp.LogUtils;
import com.okhttp.okhttp.OkhttpUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkhttpUtils.getInstance().setHandler(new Handler());
//        OkhttpUtils.getInstance().cancelTag("111");
        LogUtils.isLoge(true,false,false,false);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkhttpUtils.getInstance().getBuilder().addInterceptor(logging);

        OkhttpUtils.getInstance().getRequestBuilder().addHeader("X-APP-PACKAGE-NAME","com.apb");
        OkhttpUtils.getInstance().getHttp("http://rest.vn.starblingbling.com/v2/index/homePageInfo", null, "111",
                HomeProdctB.class, new HttpRequestCallback() {
                    @Override
                    public void requestSuccess(Object o) {

                    }

                    @Override
                    public void requestFail(String error) {

                    }
                });
    }
}
