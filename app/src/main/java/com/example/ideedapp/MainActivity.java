package com.example.ideedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //var
    String email;
    //widgets
    TextView emailTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTV = findViewById(R.id.email);

        email = getIntent().getStringExtra("email");

        emailTV.setText(email);

    }
}
