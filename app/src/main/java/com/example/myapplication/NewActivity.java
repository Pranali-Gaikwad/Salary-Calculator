package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class NewActivity extends AppCompatActivity {

    private static DecimalFormat df2 = new DecimalFormat("#.##");
    public static String SHARED_PREFS="sharedPrefs";
    EditText ctc1;
    TextView basicPayPer1, basicPayAmt1, hraPer1, hraAmt1,saPer1,saAmt1,caPer1,caAmt1,sdaPer1,sdaAmt1 ,epfPer1,epfAmt1,taxPer1;
    TextView taxAmt1, total, ded,net;
    SharedPreferences sharedPreferences;

     double bpPer;
    double hrap;
    double sap;
    double cap;
    double sdap;
    double epfp;
    double taxp;
    double epfa;
    double taxa;

    double neta;
    double bpAmt, hraA, saa, caa, sdaa;
    double ctcSalary;

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

        basicPayPer1 = findViewById(R.id.basicPayPer);
        basicPayAmt1 = findViewById(R.id.basicPayAmt);

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


        total = findViewById(R.id.permonth);
        ded = findViewById(R.id.permonthDeduction);
        net = findViewById(R.id.NetFinalDisplay);

        ctc1.setOnKeyListener(new EditText.OnKeyListener() {
            public boolean onKey(View v, int KeyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (KeyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            setOtherPercentage();
                            if (ctc1.getText().toString().isEmpty()) {
                                ctc1.setError("CTC is Required");

                            } else {
                                ctcSalary = Double.parseDouble(ctc1.getText().toString());
                            }
                            setTaxPercentage(ctcSalary);
                            calculateAmount(ctcSalary);
                            setAllValues();
                            return true;
                        default:
                            break;

                    }
                }
                return false;
            }
        });
    }
    public void setOtherPercentage(){
        sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        bpPer = 30.0;
        editor.putString("bpPer", String.valueOf(bpPer));


         bpPer = 30;
         hrap = 10;
         sap = 20;
         cap = 5;
         sdap = 5;
         epfp = 12;

    }
    public void setTaxPercentage(Double ctcSalary)
    {
        if (ctcSalary >= 0 && ctcSalary <= 250000) {
            taxp = 0;

        } else if (ctcSalary > 250000 && ctcSalary <= 500000) {
            taxp = 5;

        } else if (ctcSalary > 500000 && ctcSalary <= 1000000) {
            taxp = 20;

        } else {
            taxp = 30;
        }

    }
    public void calculateAmount(Double ctcSalary ){

        if ( taxp == 0) {
            taxa = (ctcSalary * taxp / 100) / 12;

        } else if ( taxp == 5) {
            double above2AndHalf = ctcSalary - 250000;
            taxa = (above2AndHalf * taxp / 100) / 12;

        } else if (  taxp == 20) {
            double above5 = ctcSalary - 500000;
            taxa = (12500 + (above5 * taxp / 100)) / 12;

        } else if(taxp ==30) {
            double above10 = ctcSalary - 1000000;
            taxa = (112500 + (above10 * taxp / 100)) / 12;
        }
        bpAmt = (ctcSalary / 12) * bpPer / 100;
        hraA = (ctcSalary / 12) * hrap / 100;
        saa = (ctcSalary / 12) * sap / 100;
        caa = (ctcSalary / 12) * cap / 100;
        sdaa = (ctcSalary / 12) * sdap / 100;
        epfa = (ctcSalary / 12) * epfp / 100;
        neta = (ctcSalary / 12) - (epfa + taxa);


    }
    public void setAllValues() {
        basicPayPer1.setText(String.valueOf(bpPer));
        hraPer1.setText(String.valueOf(hrap));
        saPer1.setText(String.valueOf(sap));
        caPer1.setText(String.valueOf(cap));
        sdaPer1.setText(String.valueOf(sdap));

        basicPayAmt1.setText(df2.format(bpAmt));
        hraAmt1.setText(df2.format(hraA));
        saAmt1.setText(df2.format(saa));
        caAmt1.setText(df2.format(caa));
        sdaAmt1.setText(df2.format(sdaa));
        epfPer1.setText(String.valueOf(epfp));
        epfAmt1.setText(df2.format(epfa));
        taxPer1.setText(String.valueOf(taxp));
        taxAmt1.setText(df2.format(taxa));
        total.setText(df2.format((ctcSalary / 12)));
        ded.setText(df2.format((taxa + epfa)));
        net.setText(df2.format(neta));
    }
/*
    public void calculatorMethod() {

        if (ctc1.getText().toString().isEmpty()) {
            ctc1.setError("CTC is Required");

        } else {

            double ctcSalary = Double.parseDouble(ctc1.getText().toString());
            double bpAmt, hraA, saa, caa, sdaa;


            if (ctcSalary >= 0 && ctcSalary <= 250000) {
                taxp = 0;
                taxa = (ctcSalary * taxp / 100) / 12;

            } else if (ctcSalary > 250000 && ctcSalary <= 500000) {
                taxp = 5;
                double above2AndHalf = ctcSalary - 250000;
                taxa = (above2AndHalf * taxp / 100) / 12;

            } else if (ctcSalary > 500000 && ctcSalary <= 1000000) {
                taxp = 20;
                double above5 = ctcSalary - 500000;
                taxa = (12500 + (above5 * taxp / 100)) / 12;

            } else {
                taxp = 30;
                double above10 = ctcSalary - 1000000;
                taxa = (112500 + (above10 * taxp / 100)) / 12;

            }

            bpAmt = (ctcSalary / 12) * bpPer / 100;
            hraA = (ctcSalary / 12) * hrap / 100;
            saa = (ctcSalary / 12) * sap / 100;
            caa = (ctcSalary / 12) * cap / 100;
            sdaa = (ctcSalary / 12) * sdap / 100;
            epfa = (ctcSalary / 12) * epfp / 100;
            neta = (ctcSalary / 12) - (epfa + taxa);

            basicPayPer1.setText(String.valueOf(bpPer));
            hraPer1.setText(String.valueOf(hrap));
            saPer1.setText(String.valueOf(sap));
            caPer1.setText(String.valueOf(cap));
            sdaPer1.setText(String.valueOf(sdap));

            basicPayAmt1.setText(df2.format(bpAmt));
            hraAmt1.setText(df2.format(hraA));
            saAmt1.setText(df2.format(saa));
            caAmt1.setText(df2.format(caa));
            sdaAmt1.setText(df2.format(sdaa));
            epfPer1.setText(String.valueOf(epfp));
            epfAmt1.setText(df2.format(epfa));
            taxPer1.setText(String.valueOf(taxp));
            taxAmt1.setText(df2.format(taxa));
            total.setText(df2.format((ctcSalary / 12)));
            ded.setText(df2.format((taxa + epfa)));
            net.setText(df2.format(neta));

        }

    }
*/

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
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

    @SuppressLint("SetTextI18n")
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                 bpPer = data.getDoubleExtra("bp1",0);
                 hrap = data.getDoubleExtra("hra1",0);
                 sap = data.getDoubleExtra("sa1",0);
                 cap = data.getDoubleExtra("ca1",0);
                 sdap = data.getDoubleExtra("sda1",0);
                 double t = bpPer + hrap + sap + cap + sdap + epfp + taxp;
                if (t > 100) {
                    AlertDialog.Builder al = new AlertDialog.Builder(this);
                    al.setMessage("Total Percentage is greater than 100");
                    al.setTitle("Error Message");
                    al.setPositiveButton("OK", null);
                    al.setCancelable(true);
                    al.create().show();
                } else {
                    if (ctc1.getText().toString().isEmpty()) {
                        basicPayPer1.setText(String.valueOf(bpPer));
                        hraPer1.setText(String.valueOf(hrap));
                        saPer1.setText(String.valueOf(sap));
                        caPer1.setText(String.valueOf(cap));
                        sdaPer1.setText(String.valueOf(sdap)) ;
                        epfPer1.setText(String.valueOf(epfp));
                        taxPer1.setText(String.valueOf(taxp));

                        basicPayAmt1.setText("00");
                        hraAmt1.setText("00");
                        saAmt1.setText("00");
                        caAmt1.setText("00");
                        sdaAmt1.setText("00");
                        epfAmt1.setText("00");
                        taxAmt1.setText("00");
                        total.setText("00");
                        ded.setText("00");
                        net.setText("00");
                    }else {
                        setTaxPercentage(ctcSalary);
                        calculateAmount(ctcSalary);
                        setAllValues();
                    }
                }
            }
        }
    }

}