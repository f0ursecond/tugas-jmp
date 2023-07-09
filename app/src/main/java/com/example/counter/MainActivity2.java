package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.counter.databinding.ActivityMain2Binding;

import java.util.Objects;


public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userText = Objects.requireNonNull(binding.textInputEditText.getText()).toString();
                binding.textView.setText(userText);
            }
        });


    }
}