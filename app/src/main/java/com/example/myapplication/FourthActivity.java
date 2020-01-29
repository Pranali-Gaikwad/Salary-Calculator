package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class FourthActivity extends AppCompatActivity {

    EditText epfPer;
    EditText taxPer;
    Button btn1;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_activity);

        epfPer = findViewById(R.id.epfPercentage);
        taxPer = findViewById(R.id.taxPercentage);
        btn1 = findViewById(R.id.btnaddDetails);
        btn2 = findViewById(R.id.btnOfBack);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDetailsAboutPer();
            }
        });




    }
     public void addDetailsAboutPer()
     {
         Intent intent = new Intent(this, NewActivity.class);
        /* String message3 =epfPer.getText().toString();
         String message4 =taxPer.getText().toString();

         intent.putExtra("epfPer1", message3);
         intent.putExtra("taxPer1", message4);*/
         startActivity(intent);

     }
}