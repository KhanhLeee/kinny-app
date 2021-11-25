package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHelper;
import Models.MucTieu;
import Models.NguoiDung;
import Models.Session;

public class MainActivity extends AppCompatActivity {

    TextView tv_main_tgW;
    TextView tv_main_tgD, tv_startW, tv_startD, tv_startBMI, tv_tgBMI;
    Button btn_addW;
    ImageView img_BMICal,img_User;
    Session session;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_main_tgW = findViewById(R.id.tv_main_tgWeight);
        tv_main_tgD = findViewById(R.id.tv_main_tgD);
        tv_startW = findViewById(R.id.tv_main_starWeight);
        tv_startD = findViewById(R.id.tv_main_starD);

        tv_startBMI = findViewById(R.id.tv_main_startBMI);
        tv_tgBMI = findViewById(R.id.tv_main_tgBMI);
        session = new Session(this);
        db = new DBHelper(this);
        hienthiDuLieu();

        btn_addW = findViewById(R.id.btn_main_AddW);
        btn_addW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_addW = new Intent(MainActivity.this, AddWeight_Activity.class);
                startActivity(it_addW);
            }
        });
        img_BMICal = findViewById(R.id.img_main_BMI);
        img_BMICal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_BMICal = new Intent(MainActivity.this, BMI_Caculator_Activity.class);
                startActivity(it_BMICal);
            }
        });
        img_User = findViewById(R.id.img_main_User);
        img_User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_User = new Intent(MainActivity.this, UserDetails_Activity.class);
                startActivity(it_User);
            }
        });

    }

    public void hienthiDuLieu() {
       NguoiDung nguoiDung1 = layDuLieuNguoiDung();
       MucTieu mucTieu1 = layMucTieuNguoiDung();


       if(nguoiDung1 != null){
           tv_startW.setText(String.valueOf(nguoiDung1.get_cannangbandau()));
           tv_startBMI.setText(String.valueOf("BMI: " + String.format("%,.2f",tinhBMIBanDau())));
       }
       if(mucTieu1 != null) {
           tv_main_tgW.setText(String.valueOf(mucTieu1.get_cannangMT()));
           tv_startD.setText(mucTieu1.get_ngayBatDau());
           tv_main_tgD.setText(mucTieu1.get_ngayKetThuc());
//           tv_tgBMI.setText(String.valueOf(tinhBMIMucTieu()));
       }


    }

    @SuppressLint("Range")
    public NguoiDung layDuLieuNguoiDung () {
        Cursor cursor = db.layTatcaDuLieuNguoiDung(session.laySDT());

        if(cursor != null) {
            while(cursor.moveToNext()) {
                NguoiDung nguoiDung = new NguoiDung();

                nguoiDung.set_cannangbandau(Double.parseDouble(cursor.getString(cursor.getColumnIndex(db.COT_CANNANGBD))));
                nguoiDung.set_chieucao(Double.parseDouble(cursor.getString(cursor.getColumnIndex(db.COT_CHIEUCAO))));

                return nguoiDung;
            }
        }
        return null;
    }

    public Double tinhBMIBanDau(){
        NguoiDung nguoiDung1 = layDuLieuNguoiDung();
        if(nguoiDung1 != null){
            double cannang = nguoiDung1.get_cannangbandau();
            double chieucao = nguoiDung1.get_chieucao()/100;
            double bmi = cannang/(chieucao*chieucao);
            return bmi;
        }
        return 0.0;
    }

//    public Double tinhBMIMucTieu(){
//        NguoiDung nguoiDung1 = layDuLieuNguoiDung();
//        MucTieu mucTieu1 = layMucTieuNguoiDung();
//        if(nguoiDung1 != null && mucTieu1 != null) {
//            double cannang = mucTieu1.get_cannangMT();
//            double chieucao = nguoiDung1.get_chieucao()/100;
//            double bmi = cannang/(chieucao*chieucao);
//            return bmi;
//        }
//        return 0.0;
//    }

    @SuppressLint("Range")
    public MucTieu layMucTieuNguoiDung() {
        Cursor cursor = db.layMucTieuNguoidung(session.laySDT());

        if(cursor != null) {
            while (cursor.moveToNext()) {
                MucTieu mucTieu = new MucTieu();
//                mucTieu.set_cannangMT(Double.parseDouble(cursor.getString(cursor.getColumnIndex(db.COT_CANNANGMT))));
                mucTieu.set_ngayBatDau(cursor.getString(cursor.getColumnIndex(db.COT_NGATBATDAU)));
                mucTieu.set_ngayKetThuc(cursor.getString(cursor.getColumnIndex(db.COT_NGAYTKETTHUC)));
                return mucTieu;
            }
        }
        return null;
    }
}