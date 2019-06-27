package com.example.apirestapp;



public class Connection {

    private  Connection(){

    }

    public  static final String API_URL = "http://127.0.0.1:8000/api/";

        public  static ReportService getServiceRemote(){
        return  Client.getClient(API_URL).create(ReportService.class);
    }





}








