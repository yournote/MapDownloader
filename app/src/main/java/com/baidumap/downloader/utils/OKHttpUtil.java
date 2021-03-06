package com.baidumap.downloader.utils;


import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * Created by weilei04 on 2017/2/13.
 */
public class OKHttpUtil {
    private static OKHttpUtil sInstance;

    public static OKHttpUtil getInstance() {
        if (sInstance == null) {
            sInstance = new OKHttpUtil();
        }
        return sInstance;
    }

    //GET
    public void request(String url,Callback callback) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);
    }

    //POST
    public void request(String url,String key ,String value,Callback callback) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add(key,value);

        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }
}
