package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TargetWeight_Activity extends AppCompatActivity {

    Button btn_getStarted;
    EditText txt_tgW;
    EditText txt_tgD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_weight);

        btn_getStarted = findViewById(R.id.btn_getStarted);
        txt_tgW = findViewById(R.id.txt_targetWeight);
        txt_tgD = findViewById(R.id.txt_targetDate);

        btn_getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tgW = txt_tgW.getText().toString();
                String tgD = txt_tgD.getText().toString();
                Intent it_main= new Intent(TargetWeight_Activity.this, MainActivity.class);
//
//                Bundle b= new Bundle();
//                b.putString("tgW", tgW);
//                b.putString("tgD", tgD);
//                it_main.putExtras(b);
                startActivity(it_main);

            }
        });
    }
}