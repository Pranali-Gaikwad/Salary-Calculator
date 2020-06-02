package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    EditText bpN;
    EditText hraN;
    EditText saN;
    EditText caN;
    EditText sdaN;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        bpN = findViewById(R.id.basicPayPer);

        btnSubmit = findViewById(R.id.btnaddDetails);
        hraN = findViewById(R.id.hraPer);
        saN = findViewById(R.id.saPer);
        caN = findViewById(R.id.caPer);
        sdaN = findViewById(R.id.sdaPer);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                againGotoMain();
            }
        });
    }

    public void againGotoMain() {

        Intent i = new Intent();

        Double bp = Double.parseDouble(bpN.getText().toString());
        Double hra=Double.parseDouble(hraN.getText().toString());
        Double sa=Double.parseDouble(saN.getText().toString());
        Double ca=Double.parseDouble(caN.getText().toString());
        Double sda=Double.parseDouble(sdaN.getText().toString());

        i.putExtra("bp1", bp);
        i.putExtra("hra1",hra);
        i.putExtra("sa1",sa);
        i.putExtra("ca1", ca);
        i.putExtra("sda1",sda);
        setResult(RESULT_OK, i);

        finish();


    }







}