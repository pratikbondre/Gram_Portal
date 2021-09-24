package com.example.gram_portal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=(Button) findViewById(R.id.angry_btn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2= new Intent(MainActivity.this,Login.class);
                startActivity(int2);
            }
        });

        Button button3=(Button) findViewById(R.id.angry_btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1= new Intent(MainActivity.this,Services.class);
                startActivity(int1);
            }
        });

        Button button4=(Button) findViewById(R.id.angry_btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4= new Intent(MainActivity.this,Flash_News.class);
                startActivity(int4);
            }
        });

        Button button5=(Button) findViewById(R.id.angry_btn5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5= new Intent(MainActivity.this,Commities.class);
                startActivity(int5);
            }
        });


        Button button6=(Button) findViewById(R.id.angry_btn6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int6= new Intent(MainActivity.this,about_us.class);
                startActivity(int6);
            }
        });

        Button button7=(Button) findViewById(R.id.angry_btn7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int7= new Intent(MainActivity.this,Help.class);
                startActivity(int7);
            }
        });



    }
}


