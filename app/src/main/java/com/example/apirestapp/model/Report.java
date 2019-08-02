package com.example.apirestapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Report {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("image")
    @Expose
    private String image;


    public void setId(int id) { this.id = id; }

    public  void setTitle(String title) { this.title = title; }

    public void setDescription(String description) { this.description = description; }

    public void setImage (String image) { this.image = image; }

    public int getId(){return  id;}

    public String getTitle() {return  title;}

    public String getDescription() {return  description;}

    public String getImage() {return  image;}




}







