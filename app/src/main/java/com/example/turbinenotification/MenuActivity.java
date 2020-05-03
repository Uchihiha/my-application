package com.example.turbinenotification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Update Turbine 1
        Button btn = findViewById(R.id.turb1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AutomaticActivity.class);
                startActivity(intent);
            }
        });

        // Update Turbine 2
        Button btn2 = findViewById(R.id.turb2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Turbine2Activity.class);
                startActivity(intent);
            }
        });

        // Update Turbine 3
        Button btn3 = findViewById(R.id.turb3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Turbine3Activity.class);
                startActivity(intent);
            }
        });

        // Go back to home
        Button btn4 = findViewById(R.id.btn11);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
