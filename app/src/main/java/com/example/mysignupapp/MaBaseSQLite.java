package com.example.mysignupapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;




/// the mother file that we will use to create Db and tables



public class MaBaseSQLite extends SQLiteOpenHelper  {   //  SQLiteOpenHelperto do the ddl and dml things in the DB

    private static final String TABLE_USER ="table_user";   /// the mother table here
    private static final String COL_ID ="numT";
    private static final String COL_Nom ="Nom";
    private static final String COL_Add ="Addresse";
    private static final String COL_Mtps ="mps";

    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " ( "+ COL_ID + "TEXT PRIMARY KEY , " + COL_Nom
            +"TEXT ," + COL_Add + "TEXT," +COL_Mtps + "TEXT NOT NULL );";

    private static final String update_db = "DROP TABLE " + TABLE_USER + ";";

     ////creation of the data base

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
        //remove the data base
        db.execSQL(update_db);
        //then recreate it by :
        onCreate(db);

    }

}
