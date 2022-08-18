package com.example.mission_3b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    int sum = 0;
    double avg = 0;
    List<EditText> editList = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            layout = findViewById(R.id.main);
            for(int i = 1; i <=6; i++) {
                EditText edit = new EditText(getApplicationContext());
                edit.setWidth(200);
                edit.setHeight(200);
                edit.setId(i);
                edit.setInputType(InputType.TYPE_CLASS_NUMBER);
                layout.addView(edit);
                editList.add(edit);
            }
            Button b = new Button(getApplicationContext());
            b.setText("Submit");
            layout.addView(b);
            try {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for(int i = 0; i < 6; i++) {
                            String text = String.valueOf(editList.get(i).getText());
                            list.add(text);
                            int num = Integer.parseInt(text);
                            sum += num;
                        }
                        avg = sum/6;
                        Intent intent = new Intent(String.valueOf(getBaseContext()));
                        intent.putStringArrayListExtra("LIST", list);

                    }

                });
            } catch(NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Please enter 6 numbers", Toast.LENGTH_LONG).show();
            }


    }
}