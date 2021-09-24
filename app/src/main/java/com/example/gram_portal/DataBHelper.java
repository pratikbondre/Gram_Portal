package com.example.gram_portal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="DUser.db";
    public static final String TABLE_NAME="User_table";
    public static final String COL_1="ID";
    public static final String COL_2="FName";
    public static final String COL_3="LName";
    public static final String COL_4="DateOfDeath";
    public static final String COL_5="TimeOfDeath";
    public static final String COL_6="Address";
    public static final String COL_7="Phone";
    public static final String COL_8="Hospital_Address";



    public DataBHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, FName TEXT, LName TEXT, DateOfBirth TEXT, TimeOfBirth TEXT, Address TEXT, Phone TEXT, Hospital_Address TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
