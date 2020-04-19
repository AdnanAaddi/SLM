package com.example.slm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class bedroom extends AppCompatActivity {

    ImageView bulb1, bulbf1,motion,motionfill,fan1,fan2,temp1,temp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom);
        bulb1=findViewById(R.id.bulb1);
        bulbf1=findViewById(R.id.bulbf1);
        motion=findViewById(R.id.motion);
        motionfill=findViewById(R.id.motionfill);
        fan1=findViewById(R.id.fan1);
        fan2=findViewById(R.id.fan2);
        temp1=findViewById(R.id.temp1);
        temp2=findViewById(R.id.temp2);
    }



    public void clickbulb(View v) {

        bulbf1.setVisibility(View.VISIBLE);
        bulbf1.setImageResource(R.drawable.bulbfill);
        Toast.makeText(bedroom.this,"Bulb ONN!",Toast.LENGTH_SHORT).show();



    }


    public void clickfillbulb(View v){

        bulbf1.setVisibility(View.GONE);
        Toast.makeText(bedroom.this,"Bulb OFF!",Toast.LENGTH_SHORT).show();


    }



    public void clickmotion(View v) {

        motionfill.setVisibility(View.VISIBLE);
        motionfill.setImageResource(R.drawable.motionsensorfill);
        Toast.makeText(bedroom.this,"Motion sensor start!",Toast.LENGTH_SHORT).show();


    }


    public void clickfillmotion(View v){

        motionfill.setVisibility(View.GONE);
        Toast.makeText(bedroom.this,"Motion sensor stop!",Toast.LENGTH_SHORT).show();

    }





    public void fan(View v) {

        fan2.setVisibility(View.VISIBLE);
        fan2.setImageResource(R.drawable.fanfill);
        Toast.makeText(bedroom.this,"Fan ON!",Toast.LENGTH_SHORT).show();



    }


    public void fanfill(View v){

        fan2.setVisibility(View.GONE);
        Toast.makeText(bedroom.this,"Fan OFF!",Toast.LENGTH_SHORT).show();

    }

    public void temp(View v) {

        temp2.setVisibility(View.VISIBLE);
        temp2.setImageResource(R.drawable.tempfill);
        Toast.makeText(bedroom.this,"Temperature sensor start!",Toast.LENGTH_SHORT).show();



    }


    public void tempfill(View v){

        temp2.setVisibility(View.GONE);
        Toast.makeText(bedroom.this,"Temperature sensor stop!",Toast.LENGTH_SHORT).show();

    }
    public void back(View view) {
        Toast.makeText(bedroom.this,"Back to home!",Toast.LENGTH_SHORT).show();

        finish();
    }



}