package com.example.lab2survey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Page2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
    }

    public void SecondNextBtn(View view) {

        String reasons = "";

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        intent = new Intent(this, Page3.class);
        intent.putExtras(extras);

        CheckBox checkbox1 = (CheckBox)findViewById(R.id.checkBox1);
        if(checkbox1.isChecked()){
            reasons += "Business\n";
        }
        CheckBox checkbox2 = (CheckBox)findViewById(R.id.checkBox2);
        if(checkbox2.isChecked()){
            reasons += "Relaxation\n";
        }
        CheckBox checkbox3 = (CheckBox)findViewById(R.id.checkBox3);
        if(checkbox3.isChecked()){
            reasons += "Medical Reasons\n";
        }
        CheckBox checkbox4 = (CheckBox)findViewById(R.id.checkBox4);
        if(checkbox4.isChecked()){
            reasons += "Family Reunion\n";
        }
        CheckBox checkbox5 = (CheckBox)findViewById(R.id.checkBox5);
        if(checkbox5.isChecked()){
            reasons += "Other\n";
        }

        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        intent.putExtra("reasons", reasons);
        intent.putExtra("rating", String.valueOf(ratingBar.getRating()));
        startActivity(intent);
    }
}
