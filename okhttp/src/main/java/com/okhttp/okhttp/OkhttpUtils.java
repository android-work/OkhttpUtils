package com.okhttp.okhttp;

import android.os.Handler;

import com.google.gson.Gson;

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
    private String baseUrl = "";
    private Handler handler;
    private OkHttpClient okHttpClient;

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
     * 配置全局的handler
     * */
    public void setHandler(Handler handler){

        this.handler = handler;
    }

    /**
     * 初始化okhttp
     * */
    private void initOkhttp(){

//        builder = new OkHttpClient.Builder();

        okHttpClient = new OkHttpClient();

        builder = okHttpClient.newBuilder();

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
     * get请求
     * */
    public void getHttp(String url, Map<String, String> params, String tag, Class tClass, HttpRequestCallback callback){

        StringBuffer sbUrl = new StringBuffer();

            if (params != null && params.size() != 0) {
                try {
                    //拼接url
                    int index = 0;
                    for (String key : params.keySet()) {
                        if (index > 0)
                            sbUrl.append("&");

                        sbUrl.append(String.format("%s=%s", key, URLEncoder.encode(params.get(key), "utf-8")));

                        index++;
                    }
                    url = String.format("%s%s?%s",baseUrl,url,sbUrl.toString());

                }catch (Exception e){
                    e.printStackTrace();
                }
            }


        LogUtils.loge("url:"+url);
        requestBuilder.get();
        requestBuilder.url(url);
        requestBuilder.tag(tag);

        OkHttpClient build = builder.build();

        Request request = requestBuilder.build();

        build.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handThread(callback,false,e.toString());
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) {
                String body = "";
                try {
                    body = response.body().string();

                    LogUtils.loge(body);
                    Object o = new Gson().fromJson(body, tClass);
                    handThread(callback,true,o);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });


    }


    /**
     * 取消网络请求
     * */
    public void cancelTag(String tag)
    {
        for (Call call : okHttpClient.dispatcher().queuedCalls())
        {
            if (tag.equals(call.request().tag()))
            {
                call.cancel();
            }
        }
        for (Call call : okHttpClient.dispatcher().runningCalls())
        {
            if (tag.equals(call.request().tag()))
            {
                call.cancel();
            }
        }
    }






    /**
     *  线程切换
     * */
    private void handThread(HttpRequestCallback callback, boolean isSuc, Object o){

        if (isSuc){
            handler.post(()->callback.requestSuccess(o));
        }else{
            handler.post(()->callback.requestFail(o.toString()));
        }
    }
}
