package com.example.apirestapp.connection;


import com.example.apirestapp.Client;
import com.example.apirestapp.controller.ReportService;

public class Connection {

    private  Connection(){

    }

    public  static final String API_URL = "http://192.168.49.200:8000/api/";

        public  static ReportService getServiceRemote(){
        return  Client.getClient(API_URL).create(ReportService.class);
    }





}








