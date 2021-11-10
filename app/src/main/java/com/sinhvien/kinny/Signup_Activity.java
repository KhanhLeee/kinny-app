package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup_Activity extends AppCompatActivity {

    EditText et_email, et_password, et_confirmpass;
    Button btn_signup;
    TextView tv_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_email=findViewById(R.id.et_email_signup);
        et_password=findViewById(R.id.et_password_signup);
        et_confirmpass=findViewById(R.id.et_confirmpass);

        tv_login=findViewById(R.id.tv_login);

        btn_signup=findViewById(R.id.btn_signup);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= et_email.getText().toString();
                String pass= et_password.getText().toString();
                String confirm=et_confirmpass.getText().toString();

                if(pass.compareToIgnoreCase(confirm)==0){
                    Intent it_signup= new Intent(Signup_Activity.this, Login_Activity.class);
                    it_signup.putExtra("email", email);
                    it_signup.putExtra("password", pass);
                    setResult(101,it_signup);
                    finish();
                    Toast.makeText(Signup_Activity.this,"Signup!!!" , Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Signup_Activity.this,"Wrong Password!!!" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_login= new Intent(Signup_Activity.this, Login_Activity.class);
                startActivity(it_login);
            }
        });
    }
}