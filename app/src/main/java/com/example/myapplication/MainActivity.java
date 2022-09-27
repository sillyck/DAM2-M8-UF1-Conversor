package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button boto;
    private TextView textSetmanes, textDies, textHores, textMinuts, textSegons, textnumber;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boto = findViewById(R.id.boto);
        textSetmanes = findViewById(R.id.setmanes);
        textDies = findViewById(R.id.dies);
        textHores = findViewById(R.id.hores);
        textMinuts = findViewById(R.id.minuts);
        textSegons = findViewById(R.id.segons);
        spinner = findViewById(R.id.llistat);
        textnumber = findViewById(R.id.textNumber1);

        String [] opcions = {"Setmanes", "Dies", "Hores", "Minuts", "Segons"};
        ArrayAdapter <String> opcionsAdaptades = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, opcions);

        spinner.setAdapter(opcionsAdaptades);
    }

    public void calcular(View V){

        double setmanes = 0, dies = 0, hores = 0, minuts = 0, segons = 0,
                setmanesFormatInt = 0, diesFormatInt = 0, horesFormatInt = 0,
                minutsFormatInt = 0, segonsFormatInt = 0;

        if(textnumber.getText().toString().isEmpty()){
            Toast.makeText(this, "El camp esta buit", Toast.LENGTH_SHORT).show();
        }else{

            switch (spinner.getSelectedItem().toString()){
                case "Hores":
                    String horesFormatText = textnumber.getText().toString();
                    horesFormatInt = Integer.parseInt(horesFormatText);
                    dies = hores / 24;
                    setmanes = dies / 7;
                    hores = horesFormatInt;
                    minuts = horesFormatInt * 60;
                    segons = minuts * 60;
                    break;
                case "Minuts":
                    Toast.makeText(this, "Estas al camp minuts", Toast.LENGTH_SHORT).show();
                    break;
                case "Segons":
                    String segonsFormatText = textnumber.getText().toString();
                    segonsFormatInt = Integer.parseInt(segonsFormatText);
                    segonsFormatInt = segonsFormatInt / 60;
                    break;
            }

            textSetmanes.setText("Setmanes: " + setmanes);
            textDies.setText("Dies: " + dies);
            textHores.setText("Hores: " + hores);
            textMinuts.setText("Minuts: " + minuts);
            textSegons.setText("Segons: " + segons);

        }
        //Toast.makeText(this, dies + "" + hores + "" + segonsFormatInt + "" + modul, Toast.LENGTH_SHORT).show();
    }
}