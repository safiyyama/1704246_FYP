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
    public static final String COLUMN_3 ="Food";
    //public static final String COLUMN_4 ="Lunch";
   // public static final String COLUMN_5 ="Dinner";
   // public static final String COLUMN_6 ="Snack";
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
        db.execSQL("create table " + TABLE2_NAME +" (DATEID TEXT PRIMARY KEY, NAUSEA INTEGER, STOMACH INTEGER, BLOAT INTEGER, HEART INTEGER, SKIN INTEGER, RATING FLOAT)");
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, FOOD TEXT, DATE TEXT, FOREIGN KEY (DATE) REFERENCES TABLE2_NAME (DATEID))");

        //insert test data into food_eaten table, 10 days of logging food from 14 feb - 23 feb
       db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('cereal', 'Feb 14, 2021')");
       db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('tuna sandwich', 'Feb 14, 2021')");
       db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('roast chicken', 'Feb 14, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('crisps', 'Feb 14, 2021')");

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('banana', 'Feb 15, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('cheese sandwich', 'Feb 15, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('meatballs', 'Feb 15, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('mars bar', 'Feb 15, 2021')");

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('coffee', 'Feb 16, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('spinach pasta', 'Feb 16, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('burger', 'Feb 16, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('milkshake', 'Feb 16, 2021')");

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('cereal', 'Feb 17, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('salad', 'Feb 17, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('shepherds pie', 'Feb 17, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('nuts', 'Feb 17, 2021')");

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('cereal', 'Feb 18, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('spinach pasta', 'Feb 18, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('salmon', 'Feb 18, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('banana', 'Feb 18, 2021')");

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('eggs', 'Feb 19, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('quiche', 'Feb 19, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('roast chicken', 'Feb 19, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('carrots', 'Feb 19, 2021')");

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('pancakes', 'Feb 20, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('brown rice', 'Feb 20, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('ravioli', 'Feb 20, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('muffin', 'Feb 20, 2021')");

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('eggs', 'Feb 21, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('spinach pasta', 'Feb 21, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('roast chicken', 'Feb 21, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('crisps', 'Feb 21, 2021')");

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('coffee', 'Feb 22, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('tuna sandwich', 'Feb 22, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('snickers', 'Feb 22, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('spinach pasta', 'Feb 22, 2021')");

        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('mars bar', 'Feb 23, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('brown rice', 'Feb 23, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('crisps', 'Feb 23, 2021')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(FOOD, DATE) VALUES ('roast chicken', 'Feb 23, 2021')");

        //insert test data into symptoms table, 10 days of logging symptoms from 14 feb  - 23 feb
        db.execSQL("INSERT INTO " + TABLE2_NAME+ "(DATEID, NAUSEA, STOMACH, BLOAT, HEART, SKIN, RATING) VALUES ('Feb 14, 2021', 2, 3, 0, 7, 5, 3.4)");
        db.execSQL("INSERT INTO " + TABLE2_NAME+ "(DATEID, NAUSEA, STOMACH, BLOAT, HEART, SKIN, RATING) VALUES ('Feb 15, 2021', 4, 5, 4, 3, 3, 3.8)");
        db.execSQL("INSERT INTO " + TABLE2_NAME+ "(DATEID, NAUSEA, STOMACH, BLOAT, HEART, SKIN, RATING) VALUES ('Feb 16, 2021', 2, 2, 1, 5, 4, 2.8)");
        db.execSQL("INSERT INTO " + TABLE2_NAME+ "(DATEID, NAUSEA, STOMACH, BLOAT, HEART, SKIN, RATING) VALUES ('Feb 17, 2021', 2, 0, 1, 1, 2, 1.2)");
        db.execSQL("INSERT INTO " + TABLE2_NAME+ "(DATEID, NAUSEA, STOMACH, BLOAT, HEART, SKIN, RATING) VALUES ('Feb 18, 2021', 1, 1, 3, 2, 2, 1.8)");
        db.execSQL("INSERT INTO " + TABLE2_NAME+ "(DATEID, NAUSEA, STOMACH, BLOAT, HEART, SKIN, RATING) VALUES ('Feb 19, 2021', 4, 3, 5, 6, 5, 4.6)");
        db.execSQL("INSERT INTO " + TABLE2_NAME+ "(DATEID, NAUSEA, STOMACH, BLOAT, HEART, SKIN, RATING) VALUES ('Feb 20, 2021', 3, 2, 1, 3, 2, 2.2)");
        db.execSQL("INSERT INTO " + TABLE2_NAME+ "(DATEID, NAUSEA, STOMACH, BLOAT, HEART, SKIN, RATING) VALUES ('Feb 21, 2021', 4, 3, 4, 4, 3, 3.6)");
        db.execSQL("INSERT INTO " + TABLE2_NAME+ "(DATEID, NAUSEA, STOMACH, BLOAT, HEART, SKIN, RATING) VALUES ('Feb 22, 2021', 2, 2, 2, 2, 2, 2.0)");
        db.execSQL("INSERT INTO " + TABLE2_NAME+ "(DATEID, NAUSEA, STOMACH, BLOAT, HEART, SKIN, RATING) VALUES ('Feb 23, 2021', 5, 3, 4, 3, 4, 3.8)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//this drops the table if there are upgrade issues

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        onCreate(db);

    }

    public boolean insertData(String date, String food){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_2, date);
        contentValues.put(COLUMN_3, food);
        //contentValues.put(COLUMN_4, lunch);
        //contentValues.put(COLUMN_5, dinner);
        //contentValues.put(COLUMN_6, snack);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean insertSymptomData(String dateid, Double nausea, Double stomach, Double bloat, Double heart, Double skin, Double rating){
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
