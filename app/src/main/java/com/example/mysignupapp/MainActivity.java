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

public class MainActivity extends AppCompatActivity {
    private Button eLogin;
    private EditText eName;
    private EditText ePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);


        eLogin = findViewById(R.id.btnconnect1);

        String username ="aziz";
        String password = "1234";

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText txtuserjava = findViewById(R.id.txtuser);
                EditText txtpwdjava = findViewById(R.id.txtpwd);

                String name = txtuserjava.getText().toString();
                String password = txtpwdjava.getText().toString();

                TextView txterroruser = findViewById(R.id.txterroruser);
                TextView txterrorpwd = findViewById(R.id.txterrorpwd);

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

                    txterroruser.setText("");
                }

            }


        });




    }
}