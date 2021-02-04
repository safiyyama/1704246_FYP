package com.example.foodintolleranceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="food_intolerance.db";
    public static final String TABLE_NAME="food_eaten";
    public static final String COLUMN_1 ="Date";
    public static final String COLUMN_2 ="Breakfast";
    public static final String COLUMN_3 ="Lunch";
    public static final String COLUMN_4 ="Dinner";
    public static final String COLUMN_5 ="Snack";


    public DatabaseHelper(@Nullable Context context) //when this constructor is called the database is created
    {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //Here we can execute an SQL statements like create table
        db.execSQL("create table " + TABLE_NAME +" (DATE TEXT, BREAKFAST TEXT, LUNCH TEXT, DINNER TEXT, SNACK TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//this drops the table if there are upgrade issues

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String date, String breakfast,String lunch, String dinner, String snack){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_1, date);
        contentValues.put(COLUMN_2, breakfast);
        contentValues.put(COLUMN_3, lunch);
        contentValues.put(COLUMN_4, dinner);
        contentValues.put(COLUMN_5, dinner);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
}
