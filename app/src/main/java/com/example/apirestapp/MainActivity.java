package com.example.apirestapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.EditText;

import com.example.apirestapp.connection.Connection;
import com.example.apirestapp.controller.ReportService;
import com.example.apirestapp.model.Report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ImageView img;
    private Bitmap bmp;
    private EditText verificarPalabra;
    private Intent i;
    final static int cons = 0;
    private String pFilePath = "No hay foto, no ruta";
    private String palabra = "";
    private Report report;
    private ReportService reportService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialActivityMain();
        reportService = Connection.getServiceRemote();
    }

    public void initialActivityMain() {
        verificarPalabra = findViewById(R.id.verificar);
    }

    public void main(View view) {
        Report miReport = new Report();
        palabra = verificarPalabra.getText().toString();
        char arr [] = palabra.toCharArray();
        String letra = ""+arr[palabra.length()-1];

        miReport.setDescription(letra);
        miReport.setImage(letra);
        miReport.setTitle(letra);
        addReport(miReport);
    }


    public void addReport(Report report) {
        Call<Report> call = reportService.addReport(report);

        call.enqueue(new Callback<Report>() {
            @Override
            public void onResponse(Call<Report> call, Response<Report> response) {
                if (response.isSuccessful())
                    Toast.makeText(MainActivity.this, "Data Insertado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Report> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());

            }
        });
    }
}