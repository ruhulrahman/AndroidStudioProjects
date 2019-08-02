package com.example.dailyexpenseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "Expense.db";
    public static String TABLE_NAME = "expense";
    public static String COL_ID = "id";
    public static String COL_EXPENSE_TYPE = "expense_type";
    public static String COL_AMOUNT = "amount";
    public static String COL_DATE = "expanseDate";
    public static String COL_TIME = "expanseTime";
    public static String COL_IMAGE = "image";
    public static int VERSION= 1;

    public static String create_table = "create table "+TABLE_NAME+"(id Integer primary key, expense_type Text, amount Text, expanseDate Text, expanseTime Text)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(String expanseType, Double amount, String expanseDate, String expanseTime){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EXPENSE_TYPE, expanseType);
        contentValues.put(COL_AMOUNT, amount);
        contentValues.put(COL_DATE, expanseDate);
        contentValues.put(COL_TIME, expanseTime);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return  id;


    }




}
