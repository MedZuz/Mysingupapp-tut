package com.example.mysignupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {



    UserDB1 db  = new UserDB1(Activity2.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_2);




      Button ins = findViewById(R.id.btninscri2);


      ins.setOnClickListener(new View.OnClickListener()
      {
                                 @Override
                                 public void onClick(View view)  {




                                     EditText numt = findViewById(R.id.numTT);
                                     EditText Nom = findViewById(R.id.Noomm);
                                     TextView Nomerr = findViewById(R.id.Noommerr);
                                     EditText ads = findViewById(R.id.add);
                                     EditText pss = findViewById(R.id.txtpwd4);


                                     Boolean ok = Boolean.TRUE;

                                     String name = Nom.getText().toString();
                                     String password = pss.getText().toString();
                                     String ph = numt.getText().toString();
                                     String ADDS = ads.getText().toString();



                                     String errormessage = "tous les champs sans requies !";


                                     if (name.matches("")) {
                                         Nomerr.setText(errormessage);
                                         ok = Boolean.FALSE;

                                     } else {

                                         Nomerr.setText("");

                                     }
                                     //--
                                     if (ph.matches("")) {
                                         Nomerr.setText(errormessage);
                                         ok = Boolean.FALSE;

                                     } else {

                                         Nomerr.setText("");

                                     }
                                     //--
                                     if (password.matches("")) {
                                         Nomerr.setText(errormessage);
                                         ok = Boolean.FALSE;

                                     } else {

                                         Nomerr.setText("");

                                     }
                                     //--
                                     if (ADDS.matches("")) {
                                         Nomerr.setText(errormessage);
                                         ok = Boolean.FALSE;

                                     } else {

                                         Nomerr.setText("");

                                     }


                                     if (ok) {







                                         db.open();
                                         User1 u1 = new User1(numt.getText().toString(),Nom.getText().toString(),ads.getText().toString(), pss.getText().toString());     ///  u1 will be created with the essential infos once insc has been clicked

                                         db.insertUser(u1);
                                         db.close();


/*
                                         if (checku == false ){

                                                User1 u1 = new User1();     ///  u1 will be created with the essential infos once insc has been clicked
                                                Toast.makeText(Activity2.this,"pcheww ",Toast.LENGTH_SHORT).show();

                                                u1.setNumT(numt.getText().toString());
                                                u1.setNom(Nom.getText().toString());
                                                u1.setAddresse(ads.getText().toString());
                                                u1.setMps(pss.getText().toString());




                                                db.open();

                                              Long checkinss =   db.insertUser(u1);

                                              if ( checkinss == 0){

                                                  Toast.makeText(Activity2.this,"inscription faied ",Toast.LENGTH_SHORT).show();
                                                  db.close();

                                              }
                                              else{
                                                  Toast.makeText(Activity2.this,"inscription ok ",Toast.LENGTH_SHORT).show();
                                                  db.close();


                                            }









                                            }
*/



//                                 User1 u1 = new User1();     ///  u1 will be created with the essential infos once insc has been clicked


                                 }






























                                     //
        //         TextView  m  = findViewById(R.id.msg);
        // Bundle bundle = getIntent().getExtras();

          //  if(bundle !=null){
              //  String username = bundle.getString("username");
            //    String password = bundle.getString("pasw");

                //m.setText(username +" "+password );

           // }




    }});}}