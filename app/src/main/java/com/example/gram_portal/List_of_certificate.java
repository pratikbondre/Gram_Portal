package com.example.gram_portal;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

public class List_of_certificate extends AppCompatActivity {

    ListView lview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_certificate);

        lview = (ListView) findViewById(R.id.lview1);
        String filepath = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/Gram_Portal/";
        File f = new File(filepath);//converted string object to file
        String[] values = f.list();//getting the list of files in string array
        //now presenting the data into screen
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, values);
        lview.setAdapter(adapter);//setting the adapter


    }
}
