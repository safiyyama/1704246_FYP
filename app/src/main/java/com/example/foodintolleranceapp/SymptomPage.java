package com.example.foodintolleranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class SymptomPage extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText editNausea, editStomach, editBloat, editHeart, editSkin;
    TextView avgRating;
    Button btnAddSymptoms, btnHome2;
    String currentDate;
    Double intNausea, intStomach, intBloat, intHeart, intSkin, intRating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_page);

        myDb = new DatabaseHelper(this);

        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        editNausea = (EditText)findViewById(R.id.editNausea);
        editStomach = (EditText)findViewById(R.id.editStomach);
        editBloat = (EditText)findViewById(R.id.editBloat);
        editHeart = (EditText)findViewById(R.id.editHeart);
        editSkin = (EditText)findViewById(R.id.editSkin);

       avgRating = (TextView) findViewById(R.id.avgRating);


        btnAddSymptoms = (Button)findViewById(R.id.btnAddSymptoms);

        AddSymptomData();

        btnHome2 = (Button)findViewById(R.id.btnHome2);
        btnHome2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openHomePage();
            }
        });
    }




    public void AddSymptomData(){
        btnAddSymptoms.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        boolean isInserted = myDb.insertSymptomData(currentDate,
                                intNausea = Double.parseDouble(editNausea.getText().toString()),
                                intStomach = Double.parseDouble(editStomach.getText().toString()),
                                intBloat = Double.parseDouble(editBloat.getText().toString()),
                                intHeart = Double.parseDouble(editHeart.getText().toString()),
                                intSkin = Double.parseDouble(editSkin.getText().toString()),
                                intRating = (intNausea + intStomach + intBloat + intHeart + intSkin)/5);

                        if(isInserted=true) {
                            avgRating.setText(intRating.toString());
                        } else
                            Toast.makeText(SymptomPage.this,"There was a problem adding your entry", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void openHomePage(){
        Intent intent4 = new Intent(this, HomePage.class);
        startActivity(intent4);
    }
}
