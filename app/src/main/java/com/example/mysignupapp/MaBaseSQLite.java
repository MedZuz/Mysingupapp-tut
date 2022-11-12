package com.example.mysignupapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MaBaseSQLite extends SQLiteOpenHelper  {

    private static final String TABLE_USER ="table_user";
    private static final String COL_ID ="CIN";
    private static final String COL_First_Name ="Firstname";
    private static final String COL_Last_Name ="Lastname";
    private static final String COL_Username ="user";
    private static final String COL_password ="Password";

    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " ( "+ COL_ID + "TEXT PRIMARY KEY , " + COL_First_Name
            +"TEXT ," + COL_Last_Name + "TEXT," +COL_Username + "TEXT NOT NULL ,"
            +COL_password + "TEXT NOT NULL );";

    private static final String update_db = "DROP TABLE " + TABLE_USER + ";";


    public MaBaseSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {

        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL(CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion )
    {

        db.execSQL(update_db);

        onCreate(db);

    }

}

