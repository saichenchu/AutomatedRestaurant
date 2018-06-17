package com.example.arpitnarang.automatedrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String database_name = "AutomatedRestaurant.db";
    public static final String table_name = "main_menu";
    public static final String column1 = "S.No.";
    public static final String column2 = "DISH_NAME";
    public static final String column3 = "PRICE";
    public static final String column4 = "CATEGORY";

    public DatabaseHelper(Context context) {
        super(context, database_name,null,1);
        //super(context, Environment.getExternalStorageDirectory() + File.separator + "/sdcard/AR/" + File.separator + database_name, null, 1);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("/storage/emulated/0/AR/AR.db",null,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table main_menu (DISH_CODE INTEGER PRIMARY KEY AUTOINCREMENT,DISH_NAME TEXT, PRICE INTEGER, CATEGORY TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists main_menu");
        onCreate(db);
    }

    public boolean insertData(String dish_name, int price, String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column2, dish_name);
        contentValues.put(column3, price);
        contentValues.put(column4,category);
        long result = db.insert(table_name, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getData(String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resultSet = db.rawQuery("select * from main_menu where category ="+"'"+category+"'", null);
        return resultSet;
    }
}