package com.example.lab2survey;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;

public class Page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Vector<String> str=new Vector<String>();

        InputStream inputStream = getBaseContext().getResources().openRawResource(R.raw.countries);
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        try {
            line = bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
        // make use of the line read
            try {
                line = bufferedReader.readLine();
                str.add(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        str.remove(str.size()-1);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, str);
        spinner.setAdapter(adapter);
    }

    public void nextBtn(View view) {
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        String nationality_input = spin.getSelectedItem().toString();

        RadioGroup radioButtonGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButton = radioButtonGroup.findViewById(radioButtonID);
        int idx = radioButtonGroup.indexOfChild(radioButton);
        RadioButton r = (RadioButton) radioButtonGroup.getChildAt(idx);
        String age_input = r.getText().toString();

        Intent intent = new Intent(this, Page2.class);
        // put the user input data in the intent
        intent.putExtra("nationality", nationality_input);
        intent.putExtra("age", age_input);
        // start the intent
        startActivity(intent);
    }
}
