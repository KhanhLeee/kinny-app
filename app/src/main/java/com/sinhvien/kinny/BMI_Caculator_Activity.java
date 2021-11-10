package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BMI_Caculator_Activity extends AppCompatActivity {

    ImageButton btn_backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_caculator);

        btn_backHome = findViewById(R.id.btn_backHome3);

        btn_backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_main = new Intent(BMI_Caculator_Activity.this, MainActivity.class);
                startActivity(it_main);
            }
        });

    }
}