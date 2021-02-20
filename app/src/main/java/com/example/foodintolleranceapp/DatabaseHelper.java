package com.example.foodintolleranceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="food_intolerance.db";
    public static final String TABLE_NAME="food_eaten";
    public static final String TABLE2_NAME ="symptoms";
    public static final String COLUMN_1 = "ID";
    public static final String COLUMN_2 ="Date";
    public static final String COLUMN_3 ="Breakfast";
    public static final String COLUMN_4 ="Lunch";
    public static final String COLUMN_5 ="Dinner";
    public static final String COLUMN_6 ="Snack";
    //Columns for symptom table
    public static final String COL_DATEID = "DateID";
    public static final String COL_NAUSEA= "Nausea";
    public static final String COL_STOMACH = "Stomach";
    public static final String COL_BLOAT = "Bloat";
    public static final String COL_HEART = "Heart";
    public static final String COL_SKIN = "Skin";
    public static final String COL_RATING = "Rating";


    public DatabaseHelper(@Nullable Context context) //when this constructor is called the database is created
    {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //Here we can execute an SQL statements like create table
        db.execSQL("create table " + TABLE2_NAME +" (DATEID TEXT PRIMARY KEY, NAUSEA INTEGER, STOMACH INTEGER, BLOAT INTEGER, HEART INTEGER, SKIN INTEGER, RATING INTEGER)");
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, BREAKFAST TEXT, LUNCH TEXT, DINNER TEXT, SNACK TEXT, DATE TEXT, FOREIGN KEY (DATE) REFERENCES TABLE2_NAME (DATEID))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//this drops the table if there are upgrade issues

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        onCreate(db);

    }

    public boolean insertData(String date, String breakfast,String lunch, String dinner, String snack){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_2, date);
        contentValues.put(COLUMN_3, breakfast);
        contentValues.put(COLUMN_4, lunch);
        contentValues.put(COLUMN_5, dinner);
        contentValues.put(COLUMN_6, snack);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean insertSymptomData(String dateid, Integer nausea, Integer stomach, Integer bloat, Integer heart, Integer skin, Integer rating){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_DATEID, dateid);
        contentValues.put(COL_NAUSEA, nausea);
        contentValues.put(COL_STOMACH, stomach);
        contentValues.put(COL_BLOAT, bloat);
        contentValues.put(COL_HEART, heart);
        contentValues.put(COL_SKIN, skin);
        contentValues.put(COL_RATING, rating);
        long result = db.insert(TABLE2_NAME, null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
}
