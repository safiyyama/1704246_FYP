package com.example.foodintolleranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ResultsPage extends AppCompatActivity {

    DatabaseHelper myDb;
    Button btnResults;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);

        myDb = new DatabaseHelper(this);

        textResult = (TextView)findViewById(R.id.textResult);

        btnResults = (Button)findViewById(R.id.btnResults);

        btnResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDb = new DatabaseHelper(ResultsPage.this);
                List<String> results = myDb.getResults();
                textResult.setText(results.toString());
            }
        });
    }






}