package com.example.counter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity5 extends AppCompatActivity {
    String[] person;
    Menu menu;
    ListView listView1;
    protected Cursor cursor;
    DataHelper dbCenter;
    @SuppressLint("StaticFieldLeak")
    public static MainActivity5 ma;
     FloatingActionButton buttonFloating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        buttonFloating = (FloatingActionButton) findViewById(R.id.buttonfloating);
        buttonFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPersonPage = new Intent(MainActivity5.this, MainActivity6.class);
                startActivity(addPersonPage);
            }
        });

        ma = this;
        dbCenter = new DataHelper(this);
        RefreshList();
    }
    public void RefreshList(){
        SQLiteDatabase db = dbCenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM person",null);
        person = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            person[cc] = cursor.getString(1).toString();
        }
        listView1 = (ListView)findViewById(R.id.listView1);
        listView1.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, person));
        listView1.setSelected(true);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = person[arg2]; //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogItem = {"Delete"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity5.this);
                builder.setTitle("Choose");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        if (item == 0) {
                            SQLiteDatabase db = dbCenter.getWritableDatabase();
                            db.execSQL("delete from person where nama = '" + selection + "'");
                            RefreshList();
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter<?>)listView1.getAdapter()).notifyDataSetInvalidated();
    }
}

