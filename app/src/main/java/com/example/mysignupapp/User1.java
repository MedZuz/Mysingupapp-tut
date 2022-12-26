package com.example.mysignupapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class User1 {



    private String Nom ;
    private String addresse  ;
    private String numT  ;
    private String mps  ;






    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
            addresse = addresse;
    }

    public String getNumT() {
        return numT;
    }

    public void setNumT(String numT) {
        this.numT = numT;
    }

    public String getMps() {
        return mps;
    }

    public void setMps(String mps) {
        this.mps = mps;
    }


    public User1() {
    }

    public User1(String nom, String addresse, String numT, String mps) {
        this.Nom = nom;
        this.addresse = addresse;
        this.numT = numT;
        this.mps = mps;
    }



    public static class MaBaseSQLitee extends SQLiteOpenHelper {


        private static final String TABLE_USER ="table_user";
        private static final String COL_ID ="numT";
        private static final String COL_Nom ="Nom";
        private static final String COL_Add ="addresse";
        private static final String COL_Mtps ="mps";

        public MaBaseSQLitee(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE " + TABLE_USER + " ( "+ COL_ID + "TEXT PRIMARY KEY , " + COL_Nom
                    +"TEXT ," + COL_Add + "TEXT,"  +COL_Mtps + "TEXT NOT NULL );");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {

            db.execSQL("DROP TABLE " + TABLE_USER + ";");
            onCreate(db);


        }
    }


    }
