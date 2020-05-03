package com.example.turbinenotification;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Turbine3Activity extends AppCompatActivity {

    EditText editText;
    Button btn;
    int id = 0;

    FirebaseDatabase database;
    DatabaseReference reference;

    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatic);

        member = new Member();
        btn = findViewById(R.id.btn_update);
        editText = findViewById(R.id.editText);

        reference = database.getInstance().getReference().child("Data");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    id = (int)dataSnapshot.getChildrenCount();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String name = editText.getText().toString();

                if (name.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Fill", Toast.LENGTH_SHORT).show();
                }else{
                    notification();
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();

                if(name.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter Data.", Toast.LENGTH_SHORT).show();
                }else{
                    member.setName(editText.getText().toString());

                    reference.child(String.valueOf(id+1)).setValue(member);
                }
            }
        });


        Button btn1 = findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void notification(){
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            NotificationChannel channell = new NotificationChannel("k","k", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channell);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"k")
                .setContentTitle("Turbine Notification")
                .setSmallIcon(R.drawable.ic_notifications_none_black_24dp)
                .setAutoCancel(true)
                .setContentText("Turbine 3 Data Updated");

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(999, builder.build());
    }
}
