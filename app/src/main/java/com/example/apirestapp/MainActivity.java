package com.example.apirestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    ReportService reportService;
    TextView pantalla;
    Button peticion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialActivityMain();
        reportService = Connection.getServiceRemote();
    }

    public void initialActivityMain(){
        pantalla = findViewById(R.id.pantalla);
        peticion = findViewById(R.id.peticion);
    }

    public void main(View view){
        Report miReport = new Report();
        miReport.setTitle(pantalla.getText().toString());
        addReport(miReport);
    }


    public  void addReport(Report report){
        Call<Report> call = reportService.addReport(report);

        call.enqueue(new Callback<Report>() {
            @Override
            public void onResponse(Call<Report> call, Response<Report> response) {
                if (response.isSuccessful())
                    Toast.makeText(MainActivity.this,"Data Insertado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Report> call, Throwable t) {
                Log.e("ERROR: ",t.getMessage());

            }
        });
    }












}














