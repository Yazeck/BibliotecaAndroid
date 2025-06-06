package com.example.bibliotk.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import  retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    static final String BASE_URL="http://10.0.2.2:3000";
    Retrofit retrofit;
    public RetrofitClient(){}
        public Retrofit getRetrofit(){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.
                            create(new GsonBuilder().create()))
                    .build();
            return retrofit;
        }
    }

