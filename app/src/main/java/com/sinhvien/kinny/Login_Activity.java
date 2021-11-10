package com.sinhvien.kinny;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login_Activity extends AppCompatActivity {

    TextView tv_signup;
    Button btn_login;
    EditText et_email, et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);

        tv_signup=findViewById(R.id.tv_signup);

        btn_login=findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= et_email.getText().toString();
                String password= et_password.getText().toString();
                Intent it_profile1= new Intent(Login_Activity.this, Profile1_Activity.class);
                startActivity(it_profile1);
            }
        });

        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_signup= new Intent(Login_Activity.this, Signup_Activity.class);
                startActivityForResult(it_signup,100);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==101){
            et_email.setText(data.getStringExtra("email"));
            et_password.setText(data.getStringExtra("password"));
        }
    }
}