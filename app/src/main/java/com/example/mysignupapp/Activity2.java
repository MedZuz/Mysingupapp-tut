package com.example.mysignupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_2);

        TextView  m  = findViewById(R.id.msg);


        Bundle extras = getIntent().getExtras();

            if(extras !=null){
                String username = extras.getString("username");
                String password = extras.getString("pasw");

                m.setText(username +" "+password );

            }



    }
}