package com.example.foodintolleranceapp;

import androidx.appcompat.app.AppCompatActivity;

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
    TextView textRating;
    Button btnAddSymptoms;
    String currentDate;

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

        textRating = (TextView) findViewById(R.id.textRating);

        btnAddSymptoms = (Button)findViewById(R.id.btnAddSymptoms);

        AddSymptomData();
    }

    public void AddSymptomData(){
        btnAddSymptoms.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertSymptomData(currentDate,
                                editNausea.getText().toString(),
                                editStomach.getText().toString(),
                                editBloat.getText().toString(),
                                editHeart.getText().toString(),
                                editSkin.getText().toString(),
                                textRating.getText().toString());
                        if(isInserted=true)
                            Toast.makeText(SymptomPage.this,"Your food entry has been added", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SymptomPage.this,"There was a problem adding your entry", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
