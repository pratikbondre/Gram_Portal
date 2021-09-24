package com.example.gram_portal;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button Register;
    EditText UserID, Password, CPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        openHelper=new DatabaseHelper(this);
        Register = (Button) findViewById(R.id.Register);
        UserID = (EditText) findViewById(R.id.editText4);
        Password = (EditText) findViewById(R.id.editText5);
        CPassword = (EditText) findViewById(R.id.editText6);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String editText4 = UserID.getText().toString();
                String editText5 = Password.getText().toString();
                String editText6 = CPassword.getText().toString();
                insertdata(editText4, editText5, editText6);
                Toast.makeText(getApplicationContext(),"Register Successfully", Toast.LENGTH_LONG).show();

            }
        });
        TextView textView1=(TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1= new Intent(Register.this,Login.class);
                startActivity(int1);
                Toast.makeText(Register.this, "Login",Toast.LENGTH_LONG).show();
            }
        });

    }


    public void insertdata(String editText4, String editText5, String editText6){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, editText4);
        contentValues.put(DatabaseHelper.COL_3, editText5);
        contentValues.put(DatabaseHelper.COL_4, editText6);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);



    }
}
