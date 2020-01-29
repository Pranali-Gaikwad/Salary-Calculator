package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    EditText name;
    EditText ctc;
    Button btncal;
    Button btnsetting;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        name=findViewById(R.id.username);
        ctc=findViewById(R.id.ctc);
        btncal=findViewById(R.id.btnCalculate);
        btnsetting=findViewById(R.id.btnSetting);




        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextto();

            }
        });
        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextoSetting();
            }
        });


    }
    public void nextto() {

        Intent intent = new Intent(this, ThirdActivity.class);
        String message2 =ctc.getText().toString();

        intent.putExtra("ctc", message2);

        startActivity(intent);
    }

    public void nextoSetting() {
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }


}