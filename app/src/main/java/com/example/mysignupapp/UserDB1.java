package com.example.mysignupapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDB1 {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "moumva.db";


    private static final String TABLE_USER ="table_user";


    private static final String COL_ID ="numT";
    private static final int NUM_COL_ID = 0;

    private static final String COL_Nom ="Nom";
    private static final int NUM_COL_Nom = 1;

    private static final String COL_Add ="addresse";
    private static final String NUM_COL_Add ="2";

    private static final String COL_Mtps ="mps";
    private static final String NUM_COL_Mtps ="3";





    private SQLiteDatabase bdd;       ///obj bcht7l byh w tsakr byh w taml byh l querrys asssl

    private User1.MaBaseSQLitee maBaseSQLite;

    public UserDB1(Context context) {

        maBaseSQLite  = new User1.MaBaseSQLitee(context,NOM_BDD,null,VERSION_BDD);

    }





    public void open()

    {
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }



    public void close()

    {
        //on ferme l 'accès  à la BDD
        bdd.close();
    }


    public SQLiteDatabase getBDD()

    {
        return bdd;
    }



    public long insertUser(User1 user)

    {

        //Création d'un ContentValues
        ContentValues vs1 = new ContentValues();
        vs1.put(COL_Add,user.getAddresse());
        vs1.put(COL_ID,user.getNumT());
        vs1.put(COL_Nom,user.getNom());
        vs1.put(COL_Mtps,user.getMps());


        return bdd.insert(TABLE_USER, null, vs1);

    }

    public int getnbrUser(String FindName)
    {
        Cursor c = bdd.rawQuery("select * from " + TABLE_USER , new String[] {});
        return c.getCount();
    }




    public Boolean checkuser(String eName)
    {
        Cursor m = bdd.rawQuery("select * from table_user where Nom = ? "  ,new String[]{eName});

        if (m.getCount() > 0)
            return true;
        else
            return  false;


    }

    public Boolean checkuserpass(String eName, String ePassword)
    {
        Cursor m = bdd.rawQuery("select * from table_user where mps = ? and  Nom= ? "  ,new String[]{eName,ePassword});

        if (m.getCount() > 0)
            return true;
        else
            return  false;


    }


    public User1 getUserWithusername(String Nom)
    {
        //Récupère dans un Cursor les valeur correspondant à un etudiant contenu dans la BDD (ici on sélectionne le etudiant grâce à son prenom)
        // Cursor c = bdd.query(TABLE_USER, new String[] {COL_ID, COL_First_Name, COL_Last_Name, COL_username, COL_Password}, COL_username + " LIKE \"" + username +"\"", null, null, null, null);
        // return cursorToUser(c);

        // prof work  //  Cursor z = bdd.rawQuery("select * from " +TABLE_USER+" where Nom="+Nom,new String[]{ });
        //  return cursorToUser(z);



        Cursor f = bdd.query(TABLE_USER ,new String[]{"numT","Nom","Addresse","mps"},"Nom=?",new String[]{String.valueOf(Nom)},
                null,null , null);

        if (f.getCount() == 0)
            return null;

        f.moveToFirst();

        User1 user = new User1(f.getString(0) , f.getString(1) , f.getString(2), f.getString(3));

        return user ;


    }


    //--!  private User1 cursorToUser(Cursor c)
    // ** {
    //si aucun élément n'a été retourné dans la requête, on renvoie null
    /**   if (c.getCount() == 0)
     return null;

     //Sinon on se place sur le premier élément
     c.moveToFirst();
     //On créé un etudiant
     User1 user = new User1();
     //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
     //user.set(c.getInt(NUM_COL_ID));

     user.setNom(c.getString(COL_Nom));
     user.setAddresse(c.getString(COL_Add));
     user.setNumT(c.getString(COL_ID));
     user.setMps(c.getString(COL_Mtps));
     //On ferme le cursor
     c.close();

     //On retourne le user
     return user;
     }**/























}