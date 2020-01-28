package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText salary;

    Button btnSetting;
    Button btnCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.username);
        salary = findViewById(R.id.salary);

        btnSetting = findViewById(R.id.btnSetting);
        btnCalculator = findViewById(R.id.btnCalculate);


        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openThirdActivity();
            }
        });


    }


    public void openNewActivity() {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }

    public void openThirdActivity() {
        Intent intent = new Intent(this, ThirdActivity.class);

        String message2 =salary.getText().toString();

        intent.putExtra("ctc", message2);
        startActivity(intent);
    }


}
