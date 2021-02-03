package com.example.foodintolleranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb; //use this to create instance of databaseHelper method from the databaseHelper class

    EditText editBreakfast, editLunch, editDinner, editSnack;
    Button btnAddFood;
    String currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this); //instance of this class and method created, so that database and table are created

        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        editBreakfast = (EditText)findViewById(R.id.editBreakfast);
        editLunch = (EditText)findViewById(R.id.editLunch);
        editDinner = (EditText)findViewById(R.id.editDinner);
        editSnack = (EditText)findViewById(R.id.editSnack);

        btnAddFood = (Button)findViewById(R.id.btnAddFood);

        AddData();
    }

    public void AddData(){ //add functionality to the addFood button created on GUI
        btnAddFood.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(currentDate, editBreakfast.getText().toString(),
                                editLunch.getText().toString(),
                                editDinner.getText().toString(),
                                editSnack.getText().toString());
                        if(isInserted=true)
                            Toast.makeText(MainActivity.this,"Your food entry has been added", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"There was a problem adding your entry", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
