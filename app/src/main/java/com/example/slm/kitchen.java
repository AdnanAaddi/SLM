package com.example.slm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class kitchen extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    final DatabaseReference ledstatus1 = myRef.child("led1");

    final DatabaseReference ledstatus2 = myRef.child("motion");

    final DatabaseReference ledstatus3 = myRef.child("fan");
    final DatabaseReference ledstatus4 = myRef.child("temp");


    ImageView bulb1, bulbf1,motion,motionfill,fan1,fan2,temp1,temp2;
    TextView on,off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        bulb1=findViewById(R.id.bulb1);
        bulbf1=findViewById(R.id.bulbf1);
        motion=findViewById(R.id.motion);
        motionfill=findViewById(R.id.motionfill);
        fan1=findViewById(R.id.fan1);
        fan2=findViewById(R.id.fan2);
        temp1=findViewById(R.id.temp1);
        temp2=findViewById(R.id.temp2);

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
        Toast.makeText(kitchen.this,"Bulb ONN!",Toast.LENGTH_SHORT).show();
        ledstatus1.setValue("ON");


    }


    public void clickfillbulb(View v){

        bulbf1.setVisibility(View.GONE);
        Toast.makeText(kitchen.this,"Bulb OFF!",Toast.LENGTH_SHORT).show();
        ledstatus1.setValue("OFF");

    }



    public void clickmotion(View v) {

        motionfill.setVisibility(View.VISIBLE);
        motionfill.setImageResource(R.drawable.motionsensorfill);
        Toast.makeText(kitchen.this,"Motion sensor start!",Toast.LENGTH_SHORT).show();
        ledstatus2.setValue("ON");


    }


    public void clickfillmotion(View v){

        motionfill.setVisibility(View.GONE);
        Toast.makeText(kitchen.this,"Motion sensor stop!",Toast.LENGTH_SHORT).show();
        ledstatus2.setValue("OFF");
}





    public void fan(View v) {

        fan2.setVisibility(View.VISIBLE);
        fan2.setImageResource(R.drawable.fanfill);
        Toast.makeText(kitchen.this,"Fan ON!",Toast.LENGTH_SHORT).show();
        ledstatus3.setValue("OFF");



    }


    public void fanfill(View v){

        fan2.setVisibility(View.GONE);
        Toast.makeText(kitchen.this,"Fan OFF!",Toast.LENGTH_SHORT).show();
        ledstatus3.setValue("ON");

    }

    public void temp(View v) {

        temp2.setVisibility(View.VISIBLE);
        temp2.setImageResource(R.drawable.tempfill);
        Toast.makeText(kitchen.this,"Temperature sensor start!",Toast.LENGTH_SHORT).show();
        ledstatus4.setValue("ON");



    }


    public void tempfill(View v){

        temp2.setVisibility(View.GONE);
        Toast.makeText(kitchen.this,"Temperature sensor stop!",Toast.LENGTH_SHORT).show();
        ledstatus4.setValue("OFF");

    }
    public void back(View view) {
        Toast.makeText(kitchen.this,"Back to home!",Toast.LENGTH_SHORT).show();

        finish();
    }



}