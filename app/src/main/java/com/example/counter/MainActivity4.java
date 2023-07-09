package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.counter.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {

    ActivityMain4Binding binding;
    private  EditText e1;
    private EditText e2;
    private Button btnTambah;
    private Button btnKurang;
    private Button btnKali;
    private Button btnBagi;
    private  TextView textResult;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        textResult = findViewById(R.id.textResult);


        btnTambah.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if((e1.getText().length()>0) && (e2.getText().length()>0)){
                    double operation1 = Double.parseDouble(e1.getText().toString());
                    double operation2 = Double.parseDouble(e2.getText().toString());

                    double result  = operation1 + operation2;
                    textResult.setText(Double.toString(result));
                } else {
                    Toast toast= Toast.makeText(MainActivity4.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if((e1.getText().length()>0) && (e2.getText().length()>0)){
                    double operation1 = Double.parseDouble(e1.getText().toString());
                    double operation2 = Double.parseDouble(e2.getText().toString());

                    double result  = operation1 - operation2;
                    textResult.setText(Double.toString(result));
                } else {
                    Toast toast= Toast.makeText(MainActivity4.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if((e1.getText().length()>0) && (e2.getText().length()>0)){
                    double operation1 = Double.parseDouble(e1.getText().toString());
                    double operation2 = Double.parseDouble(e2.getText().toString());

                    double result  = operation1 * operation2;
                    textResult.setText(Double.toString(result));
                } else {
                    Toast toast= Toast.makeText(MainActivity4.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if((e1.getText().length()>0) && (e2.getText().length()>0)){
                    double operation1 = Double.parseDouble(e1.getText().toString());
                    double operation2 = Double.parseDouble(e2.getText().toString());

                    double result  = operation1 / operation2;
                    textResult.setText(Double.toString(result));
                } else {
                    Toast toast= Toast.makeText(MainActivity4.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });




    }
}