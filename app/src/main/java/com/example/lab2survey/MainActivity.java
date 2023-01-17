package com.example.lab2survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startbtn(View view) {
        EditText et = (EditText) findViewById(R.id.inputCode);
        String input = et.getText().toString();
        String code = "COMP7855";
        if(input.equals(code)) {
            // create an Intent with the current and target Activities specified (explicit intent)
            Intent intent = new Intent(this, Page1.class);
            // start the intent
            startActivity(intent);
        } else {
            Context context = getApplicationContext();
            String text = "WRONG CODE";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}