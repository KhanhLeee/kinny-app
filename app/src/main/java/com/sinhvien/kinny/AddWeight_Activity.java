package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddWeight_Activity extends AppCompatActivity {

    ListView listView;
    HWAdapter hwAdapter;
    ArrayList<HistoryWeight> arrayList;
    ImageButton btn_backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_weight);

        listView = findViewById(R.id.listView);
        arrayList = HistoryWeight.initHW();
        hwAdapter = new HWAdapter(AddWeight_Activity.this, R.layout.item_listview, arrayList);
        listView.setAdapter(hwAdapter);

        btn_backHome = findViewById(R.id.btn_backHome4);

        btn_backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it_main = new Intent(AddWeight_Activity.this, MainActivity.class);
                startActivity(it_main);
            }
        });
    }
}