package com.example.lab2survey;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.Vector;

public class Page3 extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        // get the intent
        Intent intent = getIntent();
        // extract message from the intent
        String nationality = intent.getStringExtra("nationality");
        String age = intent.getStringExtra("age");
        String reasons = intent.getStringExtra("reasons");
        String rating = intent.getStringExtra("rating");
        //ListView listView = findViewById(R.id.listView);
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, reasons);
        //listView.setAdapter(adapter);
        // display the obtained message
        TextView textView = findViewById(R.id.countryText);
        textView.setText(nationality);
        textView = findViewById(R.id.ageText);
        textView.setText(age);
        textView = findViewById(R.id.reasonsText);
        textView.setText(reasons);
        textView = findViewById(R.id.ratingText);
        textView.setText(rating);
    }

    public void submitBtn(View view) {
        Intent intent = new Intent(this, Page4.class);
        startActivity(intent);
    }
}
