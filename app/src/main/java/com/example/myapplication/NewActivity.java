package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class NewActivity extends AppCompatActivity {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    EditText ctc1;
    Button btncal;

    TextView basicpayPer1;
    TextView basicpayAmt1;

    TextView hraPer1;
    TextView hraAmt1;

    TextView saPer1;
    TextView saAmt1;

    TextView caPer1;
    TextView caAmt1;

    TextView sdaPer1;
    TextView sdaAmt1;

    TextView epfPer1;
    TextView epfAmt1;

    TextView taxPer1;
    TextView taxAmt1;

    TextView netsalaryAmt1;

    TextView total;
    TextView ded;
    TextView net;

    double bpPer=30;
    double hrap=10;
    double sap=20;
    double cap=5;
    double sdap=5;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_res, menu);
        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        ctc1 = findViewById(R.id.ctc);
        btncal = findViewById(R.id.btnCalculate);

        basicpayPer1 = findViewById(R.id.basicPayPer);
        basicpayAmt1 = findViewById(R.id.basicPayAmt);

        hraPer1 = findViewById(R.id.hraPer);
        hraAmt1 = findViewById(R.id.hraAmt);

        saPer1 = findViewById(R.id.saPer);
        saAmt1 = findViewById(R.id.saAmt);

        caPer1 = findViewById(R.id.caPer);
        caAmt1 = findViewById(R.id.caAmt);

        sdaPer1 = findViewById(R.id.sdaPer);
        sdaAmt1 = findViewById(R.id.sdaAmt);

        epfPer1 = findViewById(R.id.epfPer);
        epfAmt1 = findViewById(R.id.epfAmt);

        taxPer1 = findViewById(R.id.taxPer);
        taxAmt1 = findViewById(R.id.taxAmt);

        netsalaryAmt1 = findViewById(R.id.netsalaryAmt);



        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorMethod();

            }
        });

    }
    public void calculatorMethod() {

        double ctcSalary = Double.parseDouble(ctc1.getText().toString());
        double bpAmt = Double.parseDouble(basicpayAmt1.getText().toString());
        double hraA = Double.parseDouble(hraAmt1.getText().toString());
        double saa = Double.parseDouble(saAmt1.getText().toString());
        double caa = Double.parseDouble(caAmt1.getText().toString());
        double sdaa = Double.parseDouble(sdaAmt1.getText().toString());
        double epfp = Double.parseDouble(epfPer1.getText().toString());
        double epfa = Double.parseDouble(epfAmt1.getText().toString());
        double taxp = Double.parseDouble(taxPer1.getText().toString());
        double taxa = Double.parseDouble(taxAmt1.getText().toString());
        double neta = Double.parseDouble(netsalaryAmt1.getText().toString());

        epfp = 12;


        if (ctcSalary >= 0 && ctcSalary <= 250000) {
            taxp = 0;
            taxa = (ctcSalary * taxp / 100)/12;

        } else if (ctcSalary > 250000 && ctcSalary <= 500000) {
            taxp = 5;
            taxa = (ctcSalary * taxp / 100)/12;

        } else if (ctcSalary > 500000 && ctcSalary <= 1000000) {
            taxp = 20;
            double above5=ctcSalary-500000;
            taxa =(12500+(above5 * taxp /100))/12;

        } else {
            taxp=30;
            double above5=ctcSalary-1000000;

            taxa =(112500+(above5 * taxp /100))/12;

        }

        bpAmt = (ctcSalary / 12) * bpPer / 100;
        hraA = (ctcSalary / 12) * hrap / 100;
        saa = (ctcSalary / 12) * sap / 100;
        caa = (ctcSalary / 12) * cap / 100;
        sdaa = (ctcSalary / 12) * sdap / 100;
        epfa = (ctcSalary / 12) * epfp / 100;

        neta = (ctcSalary / 12) - (epfa + taxa);


        basicpayAmt1.setText(String.valueOf(df2.format(bpAmt)));
        hraAmt1.setText(String.valueOf(df2.format(hraA)));
        saAmt1.setText(String.valueOf(df2.format(saa)));
        caAmt1.setText(String.valueOf(df2.format(caa)));
        sdaAmt1.setText(String.valueOf(df2.format(sdaa)));
        epfPer1.setText(String.valueOf(epfp));
        epfAmt1.setText(String.valueOf(df2.format(epfa)));
        taxPer1.setText(String.valueOf(taxp));
        taxAmt1.setText(String.valueOf(df2.format(taxa)));
        netsalaryAmt1.setText(String.valueOf(df2.format(neta)));
    }




    boolean isEmpty(EditText text)
    {
        CharSequence str= text.getText().toString();
        return TextUtils.isEmpty(str);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.setting_on_action_bar:
                Intent intent = new Intent(this, ThirdActivity.class);

                this.startActivityForResult(intent, 1);
                break;
            case R.id.show_history:

                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String text= data.getStringExtra("bp1");
                String texth=data.getStringExtra("hra1");
                String texts=data.getStringExtra("sa1");
                String textc=data.getStringExtra("ca1");
                String textsd=data.getStringExtra("sda1");

                bpPer = Double.parseDouble(text);
                hrap = Double.parseDouble(texth);
                sap = Double.parseDouble(texts);
                cap = Double.parseDouble(textc);
                sdap = Double.parseDouble(textsd);

                basicpayPer1.setText(String.valueOf(bpPer));
                hraPer1.setText(String.valueOf(hrap));
                saPer1.setText(String.valueOf(sap));
                caPer1.setText(String.valueOf(cap));
                sdaPer1.setText(String.valueOf(sdap));

            }
        }
    }
}

