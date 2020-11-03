package com.lx.lib_core.widget.network;

import com.lx.lib_core.widget.utils.LogUtil;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public
/**
 *@author : 阿森
 *@date : 2020-11-03 09:51
 *@params : 
 *@description:
 */
class HttpRetrofitManager {

    private static HttpRetrofitManager instance = new HttpRetrofitManager();

    public static HttpRetrofitManager getInstance() {
        return instance;
    }

    private Retrofit retrofit;
    private String oldUrl = "";

    public Retrofit getRetrofit(String url) {
        if(retrofit == null || !oldUrl.equals(url)) {
            oldUrl = url;
            createRetrofit("","");
        }
        return retrofit;
    }

    public Retrofit addHeadRetrofit(String url,String headerName,String headerValue) {
        if(retrofit == null || !oldUrl.equals(url)) {
            oldUrl = url;
            createRetrofit(headerName,headerValue);
        }
        return retrofit;
    }

    private void createRetrofit(String headerName,String headerValue) {
        //拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //客户端
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.addInterceptor(httpLoggingInterceptor);
        clientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        clientBuilder.readTimeout(30, TimeUnit.SECONDS);
        clientBuilder.callTimeout(30, TimeUnit.SECONDS);

        //添加请求头
        if(!headerName.isEmpty() && !headerValue.isEmpty()) {
            clientBuilder.addInterceptor(chain -> {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader(headerName, headerValue)
                        .build();
                LogUtil.getInstance().logI("添加请求头成功:"+headerName);
                return chain.proceed(request);
            });
        }

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(oldUrl);
        builder.client(clientBuilder.build());
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        retrofit = builder.build();
    }

}
