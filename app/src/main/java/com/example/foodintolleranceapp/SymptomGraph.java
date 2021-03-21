package com.example.foodintolleranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SymptomGraph extends AppCompatActivity {

    DatabaseHelper myDb;
    SQLiteDatabase sqLiteDatabase;

    LineGraphSeries<DataPoint> dataseries = new LineGraphSeries<>(new DataPoint[0]);

    GraphView graph;
    Button btnOverview;

    SimpleDateFormat sdf= new SimpleDateFormat("d MMM");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_graph);

        myDb = new DatabaseHelper(this);
        sqLiteDatabase = myDb.getWritableDatabase();

        graph = (GraphView) findViewById(R.id.graph);

        btnOverview = (Button) findViewById(R.id.btnOverview);

        graph.addSeries(dataseries);
        graph.getGridLabelRenderer().setNumHorizontalLabels(6);

        getOverview();

    }

    public void getOverview(){
        btnOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dataseries.resetData(getData());

                graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    @Override
                    public String formatLabel(double value, boolean isValueX) {

                        if(isValueX){
                            return sdf.format(new Date((long)value));
                        }

                        else return super.formatLabel(value, isValueX);
                    }
                });

            }
        });
    }

    private DataPoint[] getData(){
        String [] columns = {"DateID", "Rating",};
        Cursor cursor = sqLiteDatabase.query("symptoms",columns,null,null, null, null, null);

        DataPoint[] dataPoints = new DataPoint[cursor.getCount()];

                for (int i=0; i<cursor.getCount();i++){
                    cursor.moveToNext();
                    dataPoints[i]= new DataPoint(cursor.getLong(0),cursor.getInt(1));
                }

                return dataPoints;
    }
}