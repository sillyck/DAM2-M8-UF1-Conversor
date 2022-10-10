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
import java.util.Locale;

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

        String llenguatge = Locale.getDefault().getLanguage();
        String[] opcions = {"", "", "", "", ""};

        switch (llenguatge){
            case "es":
                opcions = new String[]{"Semanas", "Dias", "Horas", "Minutos", "Segundos"};
                break;
            case "en":
                opcions = new String[]{"Weeks", "Days", "Hours", "Minutes", "Seconds"};
                break;
            default:
                opcions = new String[]{"Setmanes", "Dies", "Hores", "Minuts", "Segons"};
                break;
        }
        ArrayAdapter <String> opcionsAdaptades = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, opcions);

        spinner.setAdapter(opcionsAdaptades);
    }

    public void calcular(View V){

        double setmanesV = 0, dies = 0, hores = 0, minuts = 0, segons = 0;

        if(textnumber.getText().toString().isEmpty()){
            Toast.makeText(this, "El camp esta buit", Toast.LENGTH_SHORT).show();
        }else {

            String tempsFormatText = textnumber.getText().toString();
            double tempsFormatInt = Integer.parseInt(tempsFormatText);

            switch (spinner.getSelectedItemPosition()) {
                case 0:
                    setmanesV = tempsFormatInt;
                    dies = tempsFormatInt * 7;
                    hores = dies * 24;
                    minuts = hores * 60;
                    segons = minuts * 60;
                    break;
                case 1:
                    dies = tempsFormatInt;
                    setmanesV = tempsFormatInt / 7;
                    hores = tempsFormatInt * 24;
                    minuts = hores * 60;
                    segons = minuts * 60;
                    break;
                case 2:
                    hores = tempsFormatInt;
                    dies = tempsFormatInt / 24;
                    setmanesV = dies / 7;
                    minuts = tempsFormatInt * 60;
                    segons = minuts * 60;
                    break;
                case 3:
                    minuts = tempsFormatInt;
                    segons = minuts * 60;
                    hores = tempsFormatInt / 60;
                    dies = hores / 24;
                    setmanesV = dies / 7;
                    break;
                case 4:
                    segons = tempsFormatInt;
                    minuts = tempsFormatInt / 60;
                    hores = minuts / 60;
                    dies = hores / 24;
                    setmanesV = dies / 7;
                    break;
            }
            DecimalFormat decimals = new DecimalFormat("0.00");
            decimals.setMaximumFractionDigits(2);
            textSetmanes.setText(decimals.format(setmanesV));
            textDies.setText(decimals.format(dies));
            textHores.setText(decimals.format(hores));
            textMinuts.setText(decimals.format(minuts));
            textSegons.setText(decimals.format(segons));

        }
    }
}