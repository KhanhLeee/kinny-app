package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_main_tgW;
    TextView tv_main_tgD;
    Button btn_addW;
    ImageView img_Home;
    ImageView img_BMICal;
    ImageView img_User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_main_tgW = findViewById(R.id.tv_main_tgWeight);
        tv_main_tgD = findViewById(R.id.tv_main_tgD);
        btn_addW = findViewById(R.id.btn_main_AddW);
        img_Home = findViewById(R.id.img_main_Home);
        img_BMICal = findViewById(R.id.img_main_BMI);
        img_User = findViewById(R.id.img_main_User);

//        Bundle b = getIntent().getExtras();
//        String main_tgW = b.getString("tgW");
//        String main_tgD = b.getString("tgD");
//        tv_main_tgW.setText(main_tgW + "kg");
//        tv_main_tgD.setText(main_tgD);

        btn_addW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_addW = new Intent(MainActivity.this, AddWeight_Activity.class);
                startActivity(it_addW);
            }
        });
        img_BMICal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_BMICal = new Intent(MainActivity.this, BMI_Caculator_Activity.class);
                startActivity(it_BMICal);
            }
        });

        img_User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_User = new Intent(MainActivity.this, UserDetails_Activity.class);
                startActivity(it_User);
            }
        });

    }
}