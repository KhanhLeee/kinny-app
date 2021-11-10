package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class UserDetails_Activity extends AppCompatActivity {

    ImageButton btn_us_tgW;
    Button btn_logOut;
    ImageButton btn_backHome;
    AlertConFirmLogOut alertConFirmLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);


        btn_us_tgW = findViewById(R.id.btn_tgWeight);
        btn_logOut = findViewById(R.id.btn_LogOut);
        btn_backHome = findViewById(R.id.btn_backHome1);

        btn_us_tgW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_us_tgW= new Intent(UserDetails_Activity.this, TgWeight_Activity.class);
                startActivity(it_us_tgW);
            }
        });
        btn_backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_main = new Intent(UserDetails_Activity.this, MainActivity.class);
                startActivity(it_main);
            }
        });

        btn_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_logIn = new Intent(UserDetails_Activity.this, Login_Activity.class);
                startActivity(it_logIn);
            }
        });
    }
}