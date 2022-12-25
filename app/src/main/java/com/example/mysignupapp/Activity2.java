package com.example.mysignupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_2);



      Button ins = findViewById(R.id.btninscri2);


      ins.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

             EditText numt = findViewById(R.id.numTT);

             EditText Nom = findViewById(R.id.Noomm);

             EditText ads = findViewById(R.id.add);

             EditText pss = findViewById(R.id.txtpwd4);





              User1 u1 = new User1();     ///  u1 will be created with the essential infos once insc has been clicked

              u1.setNumT(numt.getText().toString());
              u1.setNom(Nom.getText().toString());
              u1.setAddresse(ads.getText().toString());
              u1.setMps(pss.getText().toString());


              UserDB1 udb = new UserDB1(getApplicationContext());

              udb.open();

              long d = udb.insertUser(u1);

              if (d ==1) {
                  Toast.makeText(Activity2.this , "inscriptions valide",Toast.LENGTH_SHORT);
              }


              User1 res =  udb.getUserWithusername(u1.getNom());






          }
      });






























        //
        //         TextView  m  = findViewById(R.id.msg);
        // Bundle bundle = getIntent().getExtras();

          //  if(bundle !=null){
              //  String username = bundle.getString("username");
            //    String password = bundle.getString("pasw");

                //m.setText(username +" "+password );

           // }



    }
}