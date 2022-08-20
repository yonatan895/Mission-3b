package com.example.mission_3b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        layout = findViewById(R.id.second);
        TextView tv = new TextView(getApplicationContext());
        tv.setText("The salaries are:\n");
        TextView tv2 = new TextView(getApplicationContext());
        tv2.setText("The average is:\n ");
        layout.addView(tv);
        layout.addView(tv2);

        Intent intent = getIntent();
        ArrayList<String> list = intent.getStringArrayListExtra("LIST");
        String avg = intent.getStringExtra("avg");
        for(int j = 0; j < list.size(); j++) {
            tv.append(list.get(j) + " , ");
        }
        tv2.append(avg);







    }
}