package com.sabbirtech.mobidoc.helper;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by SABBIR TECH on 31-Aug-18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();
    ContentResolver mContentResolver;
    SQLiteDatabase db;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DoctorDb.db";
    private static final String TABLE_NAME = "doctor";
    public static final String TABLE_IMAGE="image";

    private static final String COLUMN_DOCTOR_ID = "ID";
    private static final String COLUMN_DOCTOR_NAME = "NAME";
    private static final String COLUMN_DOCTOR_DETAILS = "DETAILS";
    private static final String COLUMN_DOCTOR_APPOINTMENT = "APPOINTMENT";
    private static final String COLUMN_DOCTOR_PHONE = "PHONE";
    private static final String COLUMN_DOCTOR_EMAIL = "EMAIL";
    private static final String COLUMN_IMAGE_ID = "ID";
    public static final String COLUMN_IMAGE = "IMAGE";







    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        mContentResolver = context.getContentResolver();

        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME,DETAILS,APPOINTMENT,PHONE,EMAIL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_IMAGE+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE,DETAILS,PHONE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVerSion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_IMAGE);
        onCreate(db);

    }

  public boolean adduser(String name,String details,String appointment,String phone,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DOCTOR_NAME,name);
        values.put(COLUMN_DOCTOR_DETAILS,details);
        values.put(COLUMN_DOCTOR_APPOINTMENT,appointment);
        values.put(COLUMN_DOCTOR_PHONE,phone);
        values.put(COLUMN_DOCTOR_EMAIL,email);

      long result=  db.insert(TABLE_NAME, null, values);
      if(result== -1)
          return false;
      else

        return true;
    }

    public void addimage(byte[] image, String details, String name)
    {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues values = new ContentValues();
       values.put(COLUMN_IMAGE, image);
       values.put(COLUMN_DOCTOR_DETAILS,details);
       values.put(COLUMN_DOCTOR_NAME,name);

       db.insert(TABLE_IMAGE,null,values);


    }

    public Cursor getinfo()
    {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);


            return cursor;
    }

    public boolean updateinfo(String id,String name,String details, String appointment, String phone, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DOCTOR_ID,id);
        values.put(COLUMN_DOCTOR_NAME,name);
        values.put(COLUMN_DOCTOR_DETAILS,details);
        values.put(COLUMN_DOCTOR_APPOINTMENT,appointment);
        values.put(COLUMN_DOCTOR_PHONE,phone);
        values.put(COLUMN_DOCTOR_EMAIL,email);

        db.update(TABLE_NAME,values, "ID=?",new String[]{id});
        return true;
    }
}
