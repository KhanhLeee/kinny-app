package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class BMIResult_Activity extends AppCompatActivity {

    Button btn_setTarget;
    TextView bmi, danhgiaBMI, loikhuyen;
    DBHelper db;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);

        db = new DBHelper(this);
        session = new Session(this);
        bmi = findViewById(R.id.tv_bmiResult);
        danhgiaBMI = findViewById(R.id.tv_bmiTest);
        loikhuyen = findViewById(R.id.tv_advice);

        btn_setTarget = findViewById(R.id.btn_setTarget);
        btn_setTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_setTarget= new Intent(BMIResult_Activity.this, TargetWeight_Activity.class);
                startActivity(it_setTarget);
            }
        });

    }

    @SuppressLint("Range")
    public void layDuLieuNguoiDung () {
        Cursor cursor = db.layTatcaDuLieu(session.laySDT());
        
        if(cursor != null) {
            while(cursor.moveToNext()) {
                NguoiDung nguoiDung = new NguoiDung();
                
                nguoiDung.set_cannangbandau(Double.parseDouble(cursor.getString(cursor.getColumnIndex(db.COT_CANNANGBD))));
                nguoiDung.set_chieucao(Double.parseDouble(cursor.getString(cursor.getColumnIndex(db.COT_CHIEUCAO))));
            }
        }
    }

    public Double tinhBMI() {

    }
}