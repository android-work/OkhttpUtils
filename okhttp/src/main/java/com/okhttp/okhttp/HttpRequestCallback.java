package com.okhttp.okhttp;

/**
 * 创建时间：2019/12/13
 * <p>
 * 作者：Mr.Liu
 * <p>
 * 描述：请求结果回调
 **/
public interface HttpRequestCallback {

    /**
     * 请求成功
     * */
    void requestSuccess(Object o);

    /**
     * 请求失败
     * */
    void requestFail(String error);
}
