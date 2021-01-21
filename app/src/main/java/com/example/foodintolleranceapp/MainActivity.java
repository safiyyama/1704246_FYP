package com.example.foodintolleranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb; //use this to create instance of databaseHelper method from the databaseHelper class

    EditText editFood;
    Button btnAddFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this); //instance of this class and method created, so that database and table are created

        editFood = (EditText)findViewById(R.id.editFood);
        btnAddFood = (Button)findViewById(R.id.btnAddFood);
    }
}
