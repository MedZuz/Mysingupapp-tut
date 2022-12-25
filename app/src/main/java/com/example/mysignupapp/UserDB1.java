package com.example.mysignupapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDB1 {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "user.db";




    private static final String TABLE_USER ="table_user";
    private static final String COL_ID ="numT";
    private static final int NUM_COL_ID = 0;
    private static final String COL_Nom ="Nom";
    private static final int NUM_COL_Nom = 1;
    private static final String COL_Add ="Addresse";
    private static final int NUM_COL_COL_Add = 2;
    private static final String COL_Mtps ="mps";
    private static final int NUM_COL_Password = 3;



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
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_Nom, user.getNom());
        values.put(COL_ID, user.getNumT());
        values.put(COL_Add, user.getAddresse());
        values.put(COL_Mtps, user.getMps());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_USER, null, values);

    }


    public int getnbrUser(String FindName)
    {
        Cursor c = bdd.rawQuery("select * from " + TABLE_USER , new String[] {});
        return c.getCount();
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
