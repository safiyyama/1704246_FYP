package com.example.foodintolleranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        AddData();
    }

    public void AddData(){ //add functionality to the addFood button created on GUI
        btnAddFood.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editFood.getText().toString());
                        if(isInserted=true)
                            Toast.makeText(MainActivity.this,"Your food has been added", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"There was a problem adding your entry", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
