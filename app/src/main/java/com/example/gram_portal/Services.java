package com.example.gram_portal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Button button1=(Button) findViewById(R.id.angry_btn8);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1= new Intent(Services.this,BirthRagister.class);
                startActivity(int1);
            }

        });
        Button button2=(Button) findViewById(R.id.angry_btn9);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2= new Intent(Services.this,DeathRegister.class);
                startActivity(int2);
            }

        });
        Button button3=(Button) findViewById(R.id.angry_btn10);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3= new Intent(Services.this,List_of_certificate.class);
                startActivity(int3);
            }

        });

        Button button4=(Button) findViewById(R.id.angry_btn11);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4= new Intent(Services.this,Tenders.class);
                startActivity(int4);
            }

        });

        Button button5=(Button) findViewById(R.id.angry_btn12);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5= new Intent(Services.this,Taxes.class);
                startActivity(int5);
            }

        });

        AlertDialog.Builder builder = new AlertDialog.Builder(Services.this);
        builder.setCancelable(true);

        builder.setTitle("Death Register");
        builder.setMessage("Sorry for the inconvinience  this page is underconstruction");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();

            }
        });

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {


            }
        });

        builder.show();
    }

}



