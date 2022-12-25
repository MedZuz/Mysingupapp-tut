package com.example.mysignupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button eLogin;
    private EditText eName;
    private EditText ePassword;
    private TextView txterroruser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
///hide barr mysignup
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);


        eLogin = findViewById(R.id.btnconnect1);



        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText txtuserjava = findViewById(R.id.txtuser);
                EditText txtpwdjava = findViewById(R.id.txtpwd);

                String name = txtuserjava.getText().toString();
                String password = txtpwdjava.getText().toString();

                TextView txterroruser = findViewById(R.id.txterroruser);
                TextView txterrorpwd = findViewById(R.id.txterrorpwd);




                TextView txtmsgjava  = findViewById(R.id.msg);

                Boolean ok=Boolean.TRUE;

                if (name.matches("")) {
                    txterroruser.setText("Ce champ est requis !");
                        ok=Boolean.FALSE;

                } else {

                    txterroruser.setText("");

                }


                if (password.matches("")) {
                    txterrorpwd.setText("zab!");
                    ok = Boolean.FALSE;

                } else {


                    txterroruser.setVisibility(View.INVISIBLE);


                }

                if(ok){

                    Intent act2 = new Intent(MainActivity.this ,Activity2.class);

                    act2.putExtra("username" ,name) ;
                    act2.putExtra("password" ,password) ;


                    startActivity(act2);
                    finish();
                }


/////////////////  down there creation mta user should be relied to da mainactiv 2


                User u1 = new User();     ///  u1 object with X and shit info
                u1.setCin("123");
                u1.setFirstname("bronnie");
                u1.setLastname("gotham");
                u1.setPwd("98302752");


                UserDB udb = new UserDB(getApplicationContext());           // ??

                udb.open();

                udb.insertUser(u1);

                User res =  udb.getUserWithusername(u1.getFirstname());




                udb.close();




                if (res!=null){
                    Toast.makeText(MainActivity.this, "user in the data base with this name ", Toast.LENGTH_SHORT).show();

                }














            }









        });




    }
}