package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BMIResult_Activity extends AppCompatActivity {

    Button btn_keepW;
    Button btn_wGain;
    Button btn_wLoss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);

        btn_keepW = findViewById(R.id.btn_wKeep);
        btn_wGain = findViewById(R.id.btn_wGain);
        btn_wLoss = findViewById(R.id.btn_weightLoss);

        btn_keepW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_setTarget= new Intent(BMIResult_Activity.this, TargetWeight_Activity.class);
                startActivity(it_setTarget);
            }
        });

        btn_wLoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_setTarget= new Intent(BMIResult_Activity.this, TargetWeight_Activity.class);
                startActivity(it_setTarget);
            }
        });

        btn_wGain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_setTarget= new Intent(BMIResult_Activity.this, TargetWeight_Activity.class);
                startActivity(it_setTarget);
            }
        });

    }
}