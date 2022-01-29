package com.example.androidninjaworkspace.rest;

import com.example.androidninjaworkspace.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    public static Apiinterface apiInterface;
    private int index = 1;

    //live
    public static String baseUrl = "https://reqres.in/api/";

    public static Apiinterface getClient() {
        if (apiInterface == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });


            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                // Can be Level.BASIC, Level.HEADERS, or Level.BODY
                // See http://square.github.io/okhttp/3.x/logging-interceptor/ to see the options.
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
            }

            builder.connectTimeout(10, TimeUnit.MINUTES).readTimeout(10, TimeUnit.MINUTES);
            builder.build();
            OkHttpClient okHttpClient = builder.build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = client.create(Apiinterface.class);
        }
        return apiInterface;
    }

//    private static Cache provideCache() {
//        Cache cache = null;
//        try {
//            cache = new Cache(new File(GeetanjaliApplication.getContext().getCacheDir(), "http-cache"), 10 * 1024 * 1024);
//        } catch (Exception e) {
//
//        }
//        return cache;
//    }
}
