package com.okhttp.okhttp;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
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
     *
     * @param url "接口地址"
     * @param params "参数拼接集合"
     * @param tag "用户取消网络请求的标记"
     * @param tClass "请求结果的序列化的字节码对象"
     * @param callback "请求成功与否的回调方法"
     *
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
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        url = String.format("%s%s?%s",baseUrl,url,sbUrl.toString());

        LogUtils.loge("url老客户回购:"+url);
        requestBuilder.get();
        requestBuilder.url(url);
        requestBuilder.tag(tag);

        Request request = requestBuilder.build();

        okHttpClient.newCall(request).enqueue(new Callback() {
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

                    LogUtils.loge("getBody:"+body);
                    Object o = new Gson().fromJson(body, tClass);
                    handThread(callback,true,o);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }


    /**
     * post 、 put 请求
     *
     * @param url "请求地址"
     * @param methed "请求方式"
     * @param body "请求body"
     * @param tag "取消请求的标记"
     * @param paramsMap "上传参数的map集合"
     * @param fileMap "上传图片的map集合"
     * @param tClass "请求结果序列化字节码对象"
     * @param callback "请求结果的回调方法"
     *
     * */
    public void multabNetwork(String url, String methed, String body, String tag, Map<String,String> paramsMap, Map<String, File> fileMap, Class tClass, HttpRequestCallback callback){

        MultipartBody.Builder multipartBody = new MultipartBody.Builder().setType(MultipartBody.FORM);

        //上传图片
        if ((fileMap != null) || (paramsMap != null)){

            for (Map.Entry<String,File> entry : fileMap.entrySet()){

                String key = entry.getKey();
                File value = entry.getValue();
                if (value == null) continue;
                RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpg;charset=utf-8"), value);
                multipartBody.addFormDataPart(key,value.getName(),fileBody);

            }

            for (Map.Entry<String,String> entry : paramsMap.entrySet()){

                String key = entry.getKey();
                String value = entry.getValue();
                multipartBody.addFormDataPart(key,value);
            }

            requestBuilder.method(methed,multipartBody.build());
        }

        //上传json body
        if (body != null){
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body);
            requestBuilder.method(methed,requestBody);
        }
        requestBuilder.tag(tag);
        requestBuilder.url(url);
        Request request = requestBuilder.build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handThread(callback,false,e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = "";
                try{
                    body = response.body().string();

                    LogUtils.loge(methed +"Body:"+body);
                    Object o = new Gson().fromJson(body, tClass);
                    handThread(callback,true,o);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 下载图片
     * */
    public void downFile(String url,HttpRequestCallback httpRequestCallback){

        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        Request request = builder.build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handThread(httpRequestCallback,false,e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handThread(httpRequestCallback,true,response.body().byteStream());
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
            handler.post(()->callback.requestFail((String)o));
        }
    }
}
