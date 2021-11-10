
package com.sinhvien.kinny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Profile1_Activity extends AppCompatActivity {

    EditText et_name, et_age, et_gender;
    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);

        et_name= findViewById(R.id.et_name);
        et_age=findViewById(R.id.et_age);
        et_gender=findViewById(R.id.et_gender);

        btn_next=findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et_name.getText().toString();
                Intent it_profile1= new Intent(Profile1_Activity.this, Profile2_Activity.class);

                String name_user= String.valueOf(et_name.getText().toString());
                Bundle bundle= new Bundle();
                bundle.putString("name", name);
                it_profile1.putExtra("name_user",bundle);
                startActivity(it_profile1);
            }
        });

    }
}