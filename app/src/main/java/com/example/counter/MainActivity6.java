package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnSave;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        dbHelper = new DataHelper(this);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into person(nama, alamat) values('" +
                        e1.getText().toString() + "','" +
                        e2.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                MainActivity5.ma.RefreshList();
                finish();
            }
        });


    }
}