package org.example.api.service;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiService {

    protected final Retrofit retrofit;
    protected static final String BEARER_TOKEN = "Bearer 9a993f2ec2af52ec2a0ae37449ce086658ea389dde95c755b1626fd7def57adc";
    private static final String URL = "https://gorest.co.in/public/v2/";

    public ApiService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
