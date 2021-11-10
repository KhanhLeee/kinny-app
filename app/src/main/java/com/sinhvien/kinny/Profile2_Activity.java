package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Profile2_Activity extends AppCompatActivity {

    EditText et_height, et_weight;
    TextView tv_name_hi_user;
    Button btn_calculate_bmi;
    String name_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        et_height= findViewById(R.id.et_height);
        et_weight=findViewById(R.id.et_weight);

        tv_name_hi_user=findViewById(R.id.tv_name_hi_user);

        Intent it_name_user= getIntent();
        Bundle bundle= it_name_user.getBundleExtra("name_user");
        name_user=bundle.getString("name");
        tv_name_hi_user.setText("Hi, "+name_user);

        btn_calculate_bmi=findViewById(R.id.btn_calculate_bmi);

        btn_calculate_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_bmi_result = new Intent(Profile2_Activity.this, BMIResult_Activity.class);
                startActivity(it_bmi_result);
            }
        });
    }
}