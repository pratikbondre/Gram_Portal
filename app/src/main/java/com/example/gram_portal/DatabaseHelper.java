package com.example.gram_portal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME="Student_table";
    public static final String COL_1="ID";
    public static final String COL_2="UserID";
    public static final String COL_3="Password";
    public static final String COL_4="CPassword";

    public DatabaseHelper( Context context) {

        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, UserID TEXT, Password TEXT, CPassword TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public Cursor getAllData() {

         SQLiteDatabase db=this.getWritableDatabase();
         Cursor c=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
         return c; }
    }

