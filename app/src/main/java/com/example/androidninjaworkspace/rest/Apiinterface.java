package com.example.androidninjaworkspace.rest;

import com.example.androidninjaworkspace.models.data;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Apiinterface {
    @Headers("Accept:application/json")

//    //1
//    //Post Login for Registration
//    @FormUrlEncoded
//    @POST("api/login?")
//    Call<LoginResponse> postLogin(@Field("email") String email,
//                                  @Field("password") String password);

    //1
    //Post Login for Registration
//    @FormUrlEncoded
//    @POST("api/login?")
//    Call<LoginResponse> postLogin(@Field("email") String email,
//                                  @Field("password") String password);

    @GET("users?per_page=6&page=1")
    Call<data> getData();





}
