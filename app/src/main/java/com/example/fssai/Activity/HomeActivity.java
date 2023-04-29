package com.example.fssai.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fssai.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CardView Scheduling,Survey,Dispatch,Lab_Registration;

        Scheduling = findViewById(R.id.SchedulecardId);
        Survey = findViewById(R.id.SurveycardId);
        Dispatch = findViewById(R.id.DispatchcardId);
        Lab_Registration = findViewById(R.id.DetailcardId);



        Scheduling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomeActivity.this,SampleScheduleActivity.class);
                startActivity(i);
            }
        });

        Survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,SurveyActivity.class);
                startActivity(i);
            }
        });
    }
}