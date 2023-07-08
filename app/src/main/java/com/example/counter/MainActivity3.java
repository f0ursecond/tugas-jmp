package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity3 extends AppCompatActivity {


    ListView list;

    String City[]
            = { "Semarang", "Jogja",
            "Denpasar", "Solo",
            "Jakarta", "Kolaka",
            "Gorontalo", "Purwakarta",
            "Bandung" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        list = findViewById(R.id.list);

        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<>(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                City
        );
        list.setAdapter(arr);
    }
}