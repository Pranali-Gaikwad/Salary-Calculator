package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    TextView tax;
    TextView epf;
    TextView netsalary;
    String salary1;
    String perOfepf1;
    String perOftax1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        Intent intent = getIntent();


     salary1=intent.getExtras().getString("ctc");
             perOfepf1 =intent.getExtras().getString("perOfepf");
             perOftax1=intent.getExtras().getString("perOftax");
             tax = findViewById(R.id.tax);
             epf = findViewById(R.id.epf);
             netsalary = findViewById(R.id.netsalary);

        netSalaryCalculation();

    }
    boolean isEmpty(TextView text)
    {
        CharSequence str= text.getText().toString();
        return TextUtils.isEmpty(str);

    }
    public void netSalaryCalculation()
    {
        double ctcSalary= Double.parseDouble(salary1);
       /* double taxPer=Double.parseDouble(perOftax1);
        double epfPer=Double.parseDouble(perOfepf1);*/
        double netsalaryOfMonth;
        double ctcTax;
        double ctcEpf;
      /* if(isEmpty(tax) && isEmpty(epf))
        {
            Toast t=Toast.makeText(this, "You must Add details in Settings", Toast.LENGTH_SHORT);
            t.show();
        }
        else
        {
            ctcTax=(ctcSalary*taxPer/100)/12;
            ctcEpf=(ctcSalary*epfPer/100)/12;


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

}