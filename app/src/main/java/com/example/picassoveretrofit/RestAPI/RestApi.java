package com.example.picassoveretrofit.RestAPI;

import com.example.picassoveretrofit.Models.Bilgi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/photos")
    Call<List<Bilgi>> getir();
}
