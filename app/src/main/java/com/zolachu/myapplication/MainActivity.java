package com.zolachu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    Spinner color;
    Button find_beer;
    TextView brands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        color = findViewById(R.id.color);
        find_beer = findViewById(R.id.find_beer);
        brands = findViewById(R.id.brands);

        find_beer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String beerType = String.valueOf(color.getSelectedItem());
                List<String> beers = expert.getBrands(beerType);
                StringBuilder sb = new StringBuilder();
                for (String beer: beers) {
                    sb.append(beer).append("\n");
                }
                brands.setText(sb);
            }
        });
    }
}