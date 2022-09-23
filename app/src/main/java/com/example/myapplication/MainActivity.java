package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
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


        int minuts = 0;
        int hores = 0;
        int segons = 0;
        int segonsFormatInt = 0;
        int minutsFormatInt = 0;

        int modul = 0;

        if(textnumber.getText().toString().isEmpty()){
            Toast.makeText(this, "El camp esta buit", Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(this, "El camp no esta buit", Toast.LENGTH_SHORT).show();

            switch (spinner.getSelectedItem().toString()){
                case "Hores":

                    String horesFormatText = textnumber.getText().toString();

                    minutsFormatInt = Integer.parseInt(horesFormatText);


                    break;
                case "Minuts":
                    Toast.makeText(this, "Estas al camp minuts", Toast.LENGTH_SHORT).show();
                    break;
                case "Segons":

                    String segonsFormatText = textnumber.getText().toString();

                    segonsFormatInt = Integer.parseInt(segonsFormatText);

                    modul = segonsFormatInt % 60;

                    segonsFormatInt = segonsFormatInt / 60;

                    break;
            }

            if(segonsFormatInt<10 && modul<10) {
                textView1.setText("00 : 0" + segonsFormatInt + ": 0" + modul);
            }

        }
        Toast.makeText(this, segonsFormatInt + ":" + modul, Toast.LENGTH_SHORT).show();
    }
}