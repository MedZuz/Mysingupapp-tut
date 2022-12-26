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
    private Button btninscri;

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


        eName = findViewById(R.id.txtuser);

        ePassword =  findViewById(R.id.txtpwd);

        eLogin = findViewById(R.id.btnconnect1);

        btninscri=findViewById(R.id.btninscri);

        btninscri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent act20 = new Intent(MainActivity.this ,Activity2.class);
                startActivity(act20);




            }
        });

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

                String errormessage = "tous les champs sans requies !";

                Boolean ok=Boolean.TRUE;

                if (name.matches("")) {
                    txterroruser.setText(errormessage);
                        ok=Boolean.FALSE;

                } else {

                    txterroruser.setText("");

                }


                if (password.matches("")) {
                    txterrorpwd.setText(errormessage);
                    ok = Boolean.FALSE;

                } else {


                    txterroruser.setVisibility(View.INVISIBLE);


                }

                if(ok){




                        }


/////////////////  down there creation mta user should be relied to da mainactiv 2



            }




        });





    }
}