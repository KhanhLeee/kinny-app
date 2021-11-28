package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import Database.DBHelper;
import Models.MucTieu;
import Models.NguoiDung;
import Models.Session;

public class UserDetails_Activity extends AppCompatActivity {

    ImageButton btn_us_tgW;
    Button btn_logOut, btn_save;
    ImageButton btn_backHome;
    AlertConFirmLogOut alertConFirmLogOut;
    EditText txt_ten, txt_tuoi, txt_,txt_gioitinh, txt_chieucao;
    Session session;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        txt_ten = findViewById(R.id.txt_user_Name);
        txt_tuoi = findViewById(R.id.txt_user_Age);
        txt_gioitinh = findViewById(R.id.txt_user_Gender);
        txt_chieucao = findViewById(R.id.txt_user_Height);
        session = new Session(this);
        db = new DBHelper(this);
        hienthiChiTietNguoiDung();

        btn_us_tgW = findViewById(R.id.btn_tgWeight);
        btn_logOut = findViewById(R.id.btn_LogOut);
        btn_backHome = findViewById(R.id.btn_backHome1);
        btn_save = findViewById(R.id.btn_SaveUserdt);

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

    public void hienthiChiTietNguoiDung() {
        NguoiDung nguoiDung1 = layDuLieuNguoiDung();

        if(nguoiDung1 != null){
            txt_ten.setText(nguoiDung1.get_ten());
            txt_tuoi.setText(String.valueOf(nguoiDung1.get_tuoi()));
            txt_gioitinh.setText(nguoiDung1.get_gioitinh());
            txt_chieucao.setText(String.valueOf(nguoiDung1.get_chieucao()));
        }

    }

    @SuppressLint("Range")
    public NguoiDung layDuLieuNguoiDung () {
        Cursor cursor = db.layTatcaDuLieuNguoiDung(session.laySDT());

        if(cursor != null) {
            while(cursor.moveToNext()) {
                NguoiDung nguoiDung = new NguoiDung();

                nguoiDung.set_ten(cursor.getString(cursor.getColumnIndex(db.COT_TEN)));
                nguoiDung.set_tuoi(Integer.parseInt(cursor.getString(cursor.getColumnIndex(db.COT_TUOI))));
                nguoiDung.set_gioitinh(cursor.getString(cursor.getColumnIndex(db.COT_GIOITINH)));
                nguoiDung.set_cannangbandau(Double.parseDouble(cursor.getString(cursor.getColumnIndex(db.COT_CANNANGBD))));
                nguoiDung.set_chieucao(Double.parseDouble(cursor.getString(cursor.getColumnIndex(db.COT_CHIEUCAO))));

                return nguoiDung;
            }
        }
        return null;
    }

}