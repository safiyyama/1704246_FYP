package com.example.foodintolleranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb; //use this to create instance of databaseHelper method from the databaseHelper class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this); //instance of this class and method created, so that database and table are created
    }
}
