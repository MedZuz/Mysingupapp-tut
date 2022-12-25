package com.example.mysignupapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class User {


    private String username ;
    private String pwd ;
    private String cin ;
    private String firstname , lastname ;



    public User(String username, String pwd, String cin, String firstname, String lastname) {


        this.username = username;
        this.pwd = pwd;
        this.cin = cin;
        this.firstname = firstname;
        this.lastname = lastname;



    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    //**********************************  setting up the database of the user

    public static class MaBaseSQLite extends SQLiteOpenHelper {

        ///**** table infos

        private static final String TABLE_USER ="table_user";
        private static final String COL_ID ="CIN";
        private static final String COL_First_Name ="Firstname";
        private static final String COL_Last_Name ="Lastname";
        private static final String COL_Username ="user";
        private static final String COL_password ="Password";





        ///* to create the data base

        public MaBaseSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)

         {

              super(context, name, factory, version);

         }


        ///******* to create the Tabel of the User

        @Override
        public void onCreate(SQLiteDatabase db)
        {


                db.execSQL("CREATE TABLE " + TABLE_USER + " ( "+ COL_ID + "TEXT PRIMARY KEY , " + COL_First_Name
                        +"TEXT ," + COL_Last_Name + "TEXT," +COL_Username + "TEXT NOT NULL ,"
                          +COL_password + "TEXT NOT NULL );");


        }




        @Override
        public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion )
        {

            db.execSQL("DROP TABLE " + TABLE_USER + ";");

            onCreate(db);

        }

    }
}



