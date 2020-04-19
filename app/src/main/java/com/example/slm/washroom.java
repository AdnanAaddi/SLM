package com.example.slm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class washroom extends AppCompatActivity {

    ImageView bulb1, bulbf1,motion,motionfill,temp1,temp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washroom);
        bulb1=findViewById(R.id.bulb1);
        bulbf1=findViewById(R.id.bulbf1);
        motion=findViewById(R.id.motion);
        motionfill=findViewById(R.id.motionfill);
        temp1=findViewById(R.id.temp1);
        temp2=findViewById(R.id.temp2);
    }



    public void clickbulb(View v) {

        bulbf1.setVisibility(View.VISIBLE);
        bulbf1.setImageResource(R.drawable.bulbfill);
        Toast.makeText(washroom.this,"Bulb ONN!",Toast.LENGTH_SHORT).show();



    }


    public void clickfillbulb(View v){

        bulbf1.setVisibility(View.GONE);
        Toast.makeText(washroom.this,"Bulb OFF!",Toast.LENGTH_SHORT).show();


    }



    public void clickmotion(View v) {

        motionfill.setVisibility(View.VISIBLE);
        motionfill.setImageResource(R.drawable.motionsensorfill);
        Toast.makeText(washroom.this,"Motion sensor start!",Toast.LENGTH_SHORT).show();


    }


    public void clickfillmotion(View v){

        motionfill.setVisibility(View.GONE);
        Toast.makeText(washroom.this,"Motion sensor stop!",Toast.LENGTH_SHORT).show();

    }






    public void temp(View v) {

        temp2.setVisibility(View.VISIBLE);
        temp2.setImageResource(R.drawable.tempfill);
        Toast.makeText(washroom.this,"Temperature sensor start!",Toast.LENGTH_SHORT).show();



    }


    public void tempfill(View v){

        temp2.setVisibility(View.GONE);
        Toast.makeText(washroom.this,"Temperature sensor stop!",Toast.LENGTH_SHORT).show();

    }
    public void back(View view) {
        Toast.makeText(washroom.this,"Back to home!",Toast.LENGTH_SHORT).show();

        finish();
    }



}