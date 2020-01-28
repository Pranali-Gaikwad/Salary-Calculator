package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.DoubleBuffer;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText salary;
    EditText tax;
    EditText epf;
    EditText netsalary;
    Button btnSetting;
    Button btnCalculator;


    EditText epfPer;
    EditText taxPer;
    Button btnadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.username);
        salary = findViewById(R.id.salary);
        tax = findViewById(R.id.tax);
        epf = findViewById(R.id.epf);
        netsalary = findViewById(R.id.netsalary);


        btnSetting = findViewById(R.id.btnSetting);
        btnCalculator = findViewById(R.id.btnCalculate);


        btnadd = findViewById(R.id.btnaddDetails);


        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                netSalaryCalculation();
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });


    }



    public void netSalaryCalculation()
    {
        double ctcSalary= Double.parseDouble(salary.getText().toString());
        double ctcTax=0;
        double ctcEpf=0;
        double netsalaryOfMonth;

       /* if(s1==0 && s2==0)
        {
            Toast t=Toast.makeText(this, "You must Add details in Settings", Toast.LENGTH_SHORT);
            t.show();
        }
        else
        {
            ctcTax=(ctcSalary*s2/100)/12;
            ctcEpf=(ctcSalary*s1/100)/12;


        }*/
        if(ctcSalary>=500000)
        {
            ctcTax=(ctcSalary*10/100)/12;
            ctcEpf=(ctcSalary*12/100)/12;

        }
        else if(ctcSalary>=300000)
        {
            ctcTax=(ctcSalary*5/100)/12;
            ctcEpf=(ctcSalary*12/100)/12;

        }
        else
        {
            ctcTax=0;
            ctcEpf=(ctcSalary*12/100)/12;
        }

     tax.setText(String.valueOf(ctcTax));
        epf.setText(String.valueOf(ctcEpf));

netsalaryOfMonth=(ctcSalary/12)-(ctcTax+ctcEpf);
netsalary.setText(String.valueOf(netsalaryOfMonth));

    }

    public void openNewActivity()
    {
        Intent intent=new Intent(this, NewActivity.class);
        startActivity(intent);
    }





}
