package com.bakhshi.mylogin;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnB1, btnB2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnB1=(Button)findViewById(R.id.btnLogin);
        btnB2=(Button)findViewById(R.id.btnRegister);


        btnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });











/*
        btnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();

                Intent loginIntent= new Intent(MainActivity.this,LoginActivity.class);
                startActivity(loginIntent);

            }
        });

        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Register Successfull", Toast.LENGTH_SHORT).show();

                Intent RegisterIntent= new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(RegisterIntent);

            }
        });
        */


    }

    private void sendEmail() {

        Log.d("","");
        Intent emailintent = new Intent(Intent.ACTION_SEND);

        String [] TO ={""};
        String[] CC = {""};

        emailintent.setData(Uri.parse("mailto"));
        emailintent.setType("text/plain");
        emailintent.putExtra(Intent.EXTRA_CC,CC);
        emailintent.putExtra(Intent.EXTRA_EMAIL,TO);
        emailintent.putExtra(Intent.EXTRA_SUBJECT,"SUBJECT");
        emailintent.putExtra(Intent.EXTRA_TEXT,"XYZ");

        try {
            Log.d("sending","");

            startActivity(Intent.createChooser(emailintent, "SEND"));

        }

        catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(this, "Sending Failed", Toast.LENGTH_SHORT).show();
        }

    }
}

