package com.example.mysignupapp;





import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

    public class UserDB {

        private static final int VERSION_BDD = 1;
        private static final String NOM_BDD = "Bis2.db";

        private static final String TABLE_USER = "table_user";
        private static final String COL_ID = "cin";
        private static final int NUM_COL_ID = 0;
        private static final String COL_First_Name = "Firstname";
        private static final int NUM_COL_First_Name = 1;
        private static final String COL_Last_Name = "Lastname";
        private static final int NUM_COL_Last_Name = 2;
        private static final String COL_username = "username";
        private static final int NUM_COL_Email = 3;
        private static final String COL_Password = "pwd";
        private static final int NUM_COL_Password = 4;

        private SQLiteDatabase bdd;

        private MaBaseSQLite maBaseSQLite;

        public UserDB(Context context) {
            //On créer la BDD et sa table
            maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
        }

        public void open() {
            //on ouvre la BDD en écriture
            bdd = maBaseSQLite.getWritableDatabase();
        }

        public void close() {
            //on ferme l'accès à la BDD
            bdd.close();
        }

        public SQLiteDatabase getBDD() {
            return bdd;
        }

        public long insertUser(User user) {
            //Création d'un ContentValues
            ContentValues values = new ContentValues();
            //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
            values.put(COL_First_Name, user.getFirstname());
            values.put(COL_Last_Name, user.getLastname());
            values.put(COL_username, user.getUsername());
            values.put(COL_Password, user.getPwd());
            //on insère l'objet dans la BDD via le ContentValues
            return bdd.insert(TABLE_USER, null, values);
        }

        public User getUserWithusername(String username){
            //Récupère dans un Cursor les valeur correspondant à un etudiant contenu dans la BDD (ici on sélectionne le etudiant grâce à son prenom)
            Cursor c = bdd.query(TABLE_USER, new String[] {COL_ID, COL_First_Name, COL_Last_Name, COL_username, COL_Password}, COL_username + " LIKE \"" + username +"\"", null, null, null, null);
            return cursorToUser(c);
        }

        private User cursorToUser(Cursor c){
            //si aucun élément n'a été retourné dans la requête, on renvoie null
            if (c.getCount() == 0)
                return null;

            //Sinon on se place sur le premier élément
            c.moveToFirst();
            //On créé un etudiant
            User user = new User();
            //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
            //user.set(c.getInt(NUM_COL_ID));
            user.setFirstname(c.getString(NUM_COL_First_Name));
            user.setLastname(c.getString(NUM_COL_Last_Name));
            user.setUsername(c.getString(NUM_COL_Email));
            user.setPwd(c.getString(NUM_COL_Password));
            //On ferme le cursor
            c.close();

            //On retourne le user
            return user;
        }

    }





