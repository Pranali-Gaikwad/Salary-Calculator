package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {

    EditText epfPer;
    EditText taxPer;
    Button btnadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        epfPer=findViewById(R.id.epfPercentage);
        taxPer=findViewById(R.id.taxPercentage);
        btnadd=findViewById(R.id.btnaddDetails);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            addDetailsOfTax();

            }
        });



    }
    public void addDetailsOfTax()
    {
        Intent intent = new Intent(this, ThirdActivity.class);

        String perOfepf =epfPer.getText().toString();
        String perOftax =taxPer.getText().toString();
        intent.putExtra("perOfepf", perOfepf);
        intent.putExtra("perOftax", perOftax);
        startActivity(intent);
    }

}