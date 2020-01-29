package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.btnOfClickToNext);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                next();
            }
        });


    }

    public void next() {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }


}
