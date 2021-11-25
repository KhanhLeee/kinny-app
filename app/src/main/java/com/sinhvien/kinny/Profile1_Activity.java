
package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Profile1_Activity extends AppCompatActivity {

    EditText et_name, et_age, et_weight, et_height, et_gender;
    Button btn_next;
    Session session;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);

        et_name= findViewById(R.id.et_name);
        et_age=findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        et_gender=findViewById(R.id.et_gender);

        session = new Session(this);
        db = new DBHelper(this);

        btn_next=findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten=et_name.getText().toString();
                String tuoi = et_age.getText().toString();
                String chieucao = et_height.getText().toString();
                String cannang = et_weight.getText().toString();
                String gioitinh = et_gender.getText().toString();

                //Kiem tra nhap thong tin
                if(ten.equals("") || tuoi.equals("") || chieucao.equals("") || cannang.equals("") || gioitinh.equals("")){
                    Toast.makeText(Profile1_Activity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean luuThongTinNguoiDung = db.luuThongTinNguoiDung(ten, Integer.parseInt(tuoi), gioitinh,
                            Double.parseDouble(chieucao), Double.parseDouble(cannang), session.laySDT());

                    if(luuThongTinNguoiDung == true){
                        Toast.makeText(Profile1_Activity.this, "Profile saved", Toast.LENGTH_SHORT).show();
                        Intent it_profile1= new Intent(Profile1_Activity.this, BMIResult_Activity.class);
                        startActivity(it_profile1);
                    }
                    else{
                        Toast.makeText(Profile1_Activity.this, "Saving failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}