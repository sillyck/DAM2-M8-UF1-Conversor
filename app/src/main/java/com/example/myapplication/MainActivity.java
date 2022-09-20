package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private Button boto;
    private TextView textView1, textnumber;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boto = findViewById(R.id.boto);
        textView1 = findViewById(R.id.textView1);
        spinner = findViewById(R.id.llistat);
        textnumber = findViewById(R.id.textNumber1);

        String [] opcions = {"Hores", "Minuts", "Segons"};
        ArrayAdapter <String> opcionsAdaptades = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, opcions);

        spinner.setAdapter(opcionsAdaptades);
    }

    public void calcular(View V){
        if(!TextUtils.isEmpty(textnumber.getText().toString()) && !TextUtils.isEmpty(spinner.getTooltipText().toString())){
            Toast.makeText(this, "No estan buits", Toast.LENGTH_LONG);
        }else{
            Toast.makeText(this, "Hi ha algo buit", Toast.LENGTH_LONG);
        }
    }
}