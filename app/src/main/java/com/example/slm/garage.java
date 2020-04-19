package com.example.slm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class garage extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    final DatabaseReference ledstatus1 = myRef.child("led1");

    final DatabaseReference ledstatus2 = myRef.child("door");

    ImageView bulb1, bulbf1,doorlock,doorlockfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);
        bulb1=findViewById(R.id.bulb1);
        bulbf1=findViewById(R.id.bulbf1);

        doorlock=findViewById(R.id.doorlock);
        doorlockfil=findViewById(R.id.doorlockfill);
        ledstatus1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d("file", "Value is: " + value);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("file", "Failed to read value.",databaseError.toException());

            }
        });

    }



    public void clickbulb(View v) {

        bulbf1.setVisibility(View.VISIBLE);
        bulbf1.setImageResource(R.drawable.bulbfill);
        Toast.makeText(garage.this,"Bulb ONN!",Toast.LENGTH_SHORT).show();
        ledstatus1.setValue("ON");



    }


    public void clickfillbulb(View v){

        bulbf1.setVisibility(View.GONE);
        Toast.makeText(garage.this,"Bulb OFF!",Toast.LENGTH_SHORT).show();
        ledstatus1.setValue("OFF");


    }



    public void doorlock(View v) {

        doorlockfil.setVisibility(View.VISIBLE);
        doorlockfil.setImageResource(R.drawable.lockfill);
        Toast.makeText(garage.this,"Door Open!",Toast.LENGTH_SHORT).show();
        ledstatus2.setValue("Open");


    }


    public void doorlockfill(View v){

        doorlockfil.setVisibility(View.GONE);
        Toast.makeText(garage.this,"Door locked!",Toast.LENGTH_SHORT).show();
        ledstatus2.setValue("lock");

    }








    public void back(View view) {
        Toast.makeText(garage.this,"Back to home!",Toast.LENGTH_SHORT).show();
        finish();
    }

}