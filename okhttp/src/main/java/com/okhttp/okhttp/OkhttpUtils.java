package com.okhttp.okhttp;

import android.text.TextUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 创建时间：2019/12/11
 * <p>
 * 作者：Mr.Liu
 * <p>
 * 描述：网络请求的工具类
 **/
public class OkhttpUtils {

    private static OkhttpUtils mOkhttp;
    private OkHttpClient.Builder builder;
    private Request.Builder requestBuilder;
    private String baseUrl;

    private OkhttpUtils(){initOkhttp();}

    /**
     * 网络请求工具单例
     * */
    public static OkhttpUtils getInstance(){

        if (mOkhttp == null){

            synchronized (OkhttpUtils.class){

                mOkhttp = new OkhttpUtils();
            }
        }
        return mOkhttp;
    }

    /**
     * 配置baseUrl
     * */
    public void setBaseUrl(String BaseUrl){

        baseUrl = BaseUrl;
    }

    /**
     * 初始化okhttp
     * */
    private void initOkhttp(){

        builder = new OkHttpClient.Builder();

        requestBuilder = new Request.Builder();
    }

    /**
     * 获取OkHttpClient.Builder对象，用于添加日志打印和设置请求超时时间
     * */
    public OkHttpClient.Builder getBuilder(){
        return builder;
    }

    /**
     * 获取Request.Builder对象，用户添加head和body
     * */
    public Request.Builder getRequestBuilder(){
        return requestBuilder;
    }

    /**
     * 请求
     * */
    public void getHttp(String url, Map<String,String> params){

        StringBuffer sbUrl = new StringBuffer();
        try {
            if (params != null && params.size() != 0) {
                //拼接url
                int index = 0;
                for (String key : params.keySet()) {
                    if (index > 0)
                        sbUrl.append("&");

                    sbUrl.append(String.format("%s=%s", key, URLEncoder.encode(params.get(key), "utf-8")));

                    index++;
                }
            }

            url = String.format("%s%s?%s",baseUrl,url,sbUrl.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

        requestBuilder.get();
        requestBuilder.url(url);

        OkHttpClient build = builder.build();

        Request request = requestBuilder.build();

        build.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) {

                
            }
        });


    }
}
