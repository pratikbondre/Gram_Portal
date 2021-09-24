package com.example.gram_portal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button Login;
    EditText UserID, Password;
    Cursor cursor;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView=(TextView) findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);

                Toast.makeText(Login.this, "Register",Toast.LENGTH_LONG).show();
            }
        });
        openHelper= new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        Login= (Button)findViewById(R.id.Login);
        UserID = (EditText) findViewById(R.id.editText2);
        Password = (EditText) findViewById(R.id.editText3);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editText2 = UserID.getText().toString();
                String editText3 = Password.getText().toString();
                cursor = db.rawQuery(" SELECT * FROM " + DatabaseHelper.TABLE_NAME+ " WHERE " + DatabaseHelper.COL_2 + " =? AND " + DatabaseHelper.COL_3 + "=?", new String[]{editText2, editText3});
                if (cursor!=null){
                    if (cursor.getCount()>0){
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Error Occure", Toast.LENGTH_LONG).show();

                    }
                }

            }
        });
    }
}



