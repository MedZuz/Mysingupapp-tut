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

                TextView txtmsgjava  = findViewById(R.id.txtmsg);

                Boolean ok=Boolean.TRUE;
                if (name.matches("")) {
                    txterroruser.setText("Ce champ est requis !");
                        ok=Boolean.FALSE;

                } else {

                    txterroruser.setText("");

                }



                if (password.matches("")) {
                    txterroruser.setText("Ce champ est requis!");
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



            }
//check states of activits


        });




    }
}