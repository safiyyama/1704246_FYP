package com.example.foodintolleranceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="food.db";
    public static final String TABLE_NAME="food_table";
    public static final String COLUMN_1 ="Food";

    public DatabaseHelper(@Nullable Context context) //when this constructor is called the database is created
    {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //Here we can execute an SQL statements like create table
        db.execSQL("create table " + TABLE_NAME +" (FOOD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//this drops the table if there are upgrade issues

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String food){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_1, food);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
}
