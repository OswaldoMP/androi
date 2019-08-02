package com.example.apirestapp.controller;

import com.example.apirestapp.model.Report;

import  java.util.List;

import retrofit2.Call;
import retrofit2.http.*;



public interface ReportService {

    @GET("reports/")
    Call<List<Report>> getReports();

    @GET("reports/{id}")
    Call<Report> getByIdReport(@Path("id") int id);


    @POST("reports/")
    Call<Report> addReport(@Body Report report);

    @PUT("reports/{id}")
    Call<Report> updateReport(@Path("id") int id, @Body Report report);

    @DELETE("reports/{id}")
    Call<Report> deleteReport(@Path("id") int id);





}









