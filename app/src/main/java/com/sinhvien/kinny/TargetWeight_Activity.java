package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TargetWeight_Activity extends AppCompatActivity {

    Button btn_getStarted;
    EditText txt_tgW;
    EditText txt_tgD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_weight);

        btn_getStarted = findViewById(R.id.btn_getStarted);
        txt_tgW = findViewById(R.id.txt_targetWeight);
        txt_tgD = findViewById(R.id.txt_targetDate);

        txt_tgD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonTargetDate();
            }
        });

        btn_getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tgW = txt_tgW.getText().toString();
                String tgD = txt_tgD.getText().toString();
                Intent it_main= new Intent(TargetWeight_Activity.this, MainActivity.class);
                startActivity(it_main);
            }
        });
    }

    private void ChonTargetDate(){
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                //i: nam, i1: thang, i2: ngay
                calendar.set(i, i1, i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                txt_tgD.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }

}