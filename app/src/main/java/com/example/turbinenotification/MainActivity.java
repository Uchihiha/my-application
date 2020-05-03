package com.example.turbinenotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static com.example.turbinenotification.App.CHANNEL_1_ID;

public class MainActivity extends AppCompatActivity {

    public TextView data11, data12, data13, data21, data22, data23, data31, data32, data33;
    public Random r;
    int number,number1,number2,number3,number4,number5,number6,number7,number8;
    private Handler mHandler = new Handler();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ManualActivity.class);
                startActivity(intent);
            }
        });

        Button btn2 = findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);
            }
        });

        r = new Random();

        data11 = findViewById(R.id.data11);
        data12 = findViewById(R.id.data12);
        data13 = findViewById(R.id.data13);
        data21 = findViewById(R.id.data21);
        data22 = findViewById(R.id.data22);
        data23 = findViewById(R.id.data23);
        data31 = findViewById(R.id.data31);
        data32 = findViewById(R.id.data32);
        data33 = findViewById(R.id.data33);
    }

    private Runnable mRunnable = new Runnable(){

        public void run(){
            number=r.nextInt(10)+10;
            String myString = String.valueOf(number);
            data11.setText(myString);

            number1=r.nextInt(6)+22;
            String myString1 = String.valueOf(number1);
            data12.setText(myString1);

            number2=r.nextInt(6)+23;
            String myString2 = String.valueOf(number2);
            data13.setText(myString2);


            number3=r.nextInt(6)+24;
            String myString3 = String.valueOf(number3);
            data21.setText(myString3);

            number4=r.nextInt(6)+25;
            String myString4 = String.valueOf(number4);
            data22.setText(myString4);

            number5=r.nextInt(6)+26;
            String myString5 = String.valueOf(number5);
            data23.setText(myString5);

            number6=r.nextInt(6)+27;
            String myString6 = String.valueOf(number6);
            data31.setText(myString6);

            number7=r.nextInt(6)+8;
            String myString7 = String.valueOf(number7);
            data32.setText(myString7);

            number8=r.nextInt(100)+2;
            String myString8 = String.valueOf(number8);
            data33.setText(myString8);

            mHandler.postDelayed(this, 2000);

        }
    };


    public void startRepeating(View v){
        mRunnable.run();
    }



}
