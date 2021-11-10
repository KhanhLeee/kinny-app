package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TgWeight_Activity extends AppCompatActivity {

    ImageButton btn_us_usDeTails;
    ImageButton btn_backHome;
    Button btn_logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tg_weight);

        btn_us_usDeTails = findViewById(R.id.btn_user_usDetails2);
        btn_backHome = findViewById(R.id.btn_backHome2);
        btn_logOut = findViewById(R.id.btn_LogOut2);

        btn_us_usDeTails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_us_usDT= new Intent(TgWeight_Activity.this, UserDetails_Activity.class);
                startActivity(it_us_usDT);
            }
        });

        btn_backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_main = new Intent(TgWeight_Activity.this, MainActivity.class);
                startActivity(it_main);
            }
        });

        btn_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_logIn = new Intent(TgWeight_Activity.this, Login_Activity.class);
                startActivity(it_logIn);
            }
        });
    }
}