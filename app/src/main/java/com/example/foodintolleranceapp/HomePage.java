package com.example.foodintolleranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button btnResultsPage, btnFoodPage, btnSymptomsPage, btnGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnFoodPage = (Button)findViewById(R.id.btnFoodPage);
        btnFoodPage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openFoodPage();
            }

        });

        btnSymptomsPage = (Button)findViewById(R.id.btnSymptomsPage);
        btnSymptomsPage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openSymptomsPage();
            }

        });


        btnResultsPage = (Button)findViewById(R.id.btnResultsPage);
         btnResultsPage.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View v) {
                 openResultsPage();
             }

         });

         btnGraph = (Button)findViewById(R.id.btnGraph);
        btnGraph.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openGraphPage();
            }

        });
    }

    public void openFoodPage(){
        Intent intent5 = new Intent(this, MainActivity.class);
        startActivity(intent5);
    }

    public void openSymptomsPage(){
        Intent intent6 = new Intent(this, SymptomPage.class);
        startActivity(intent6);
    }

    public void openResultsPage(){
        Intent intent2 = new Intent(this, ResultsPage.class);
        startActivity(intent2);
    }

    public void openGraphPage(){
        Intent intent7 = new Intent(this, SymptomGraph.class);
        startActivity(intent7);
    }


}