package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private ImageButton boto;
    private TextView textSetmanes, textDies, textHores, textMinuts, textSegons, textnumber;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        boto = findViewById(R.id.ib2);
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
        }else {

            String tempsFormatText = textnumber.getText().toString();
            double tempsFormatInt = Integer.parseInt(tempsFormatText);

            switch (spinner.getSelectedItem().toString()) {
                case "Setmanes":
                    setmanes = tempsFormatInt;
                    dies = tempsFormatInt * 7;
                    hores = dies * 24;
                    minuts = hores * 60;
                    segons = minuts * 60;
                    break;
                case "Dies":
                    dies = tempsFormatInt;
                    setmanes = tempsFormatInt / 7;
                    hores = tempsFormatInt * 24;
                    minuts = hores * 60;
                    segons = minuts * 60;
                    break;
                case "Hores":
                    hores = tempsFormatInt;
                    dies = tempsFormatInt / 24;
                    setmanes = dies / 7;
                    minuts = tempsFormatInt * 60;
                    segons = minuts * 60;
                    break;
                case "Minuts":
                    minuts = tempsFormatInt;
                    segons = minuts * 60;
                    hores = tempsFormatInt / 60;
                    dies = hores / 24;
                    setmanes = dies / 7;
                    break;
                case "Segons":
                    segons = tempsFormatInt;
                    minuts = tempsFormatInt / 60;
                    hores = minuts / 60;
                    dies = hores / 24;
                    setmanes = dies / 7;
                    break;
            }
            String string = getString(R.string.setmanesText);
            DecimalFormat decimals = new DecimalFormat("0.00");
            decimals.setMaximumFractionDigits(2);
            textSetmanes.setText(getString(R.string.setmanesText) + decimals.format(setmanes));
            textDies.setText("Dies: " + decimals.format(dies));
            textHores.setText("Hores: " + decimals.format(hores));
            textMinuts.setText("Minuts: " + decimals.format(minuts));
            textSegons.setText("Segons: " + decimals.format(segons));

        }
    }
}