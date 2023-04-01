package com.example.temperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.*;




public class MainActivity extends AppCompatActivity {
    EditText temp;
    TextView resp;
    Button k, f, re, ra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resp = (TextView)findViewById(R.id.resposta);
        temp =  (EditText) findViewById(R.id.editText);
        k = (Button) findViewById(R.id.kelvin);
        f = (Button) findViewById(R.id.fahrenheit);
        re = (Button) findViewById(R.id.reaumur);
        ra = (Button) findViewById(R.id.rankine);

        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double kelvin = Double.parseDouble(temp.getText().toString()) + 273.15;
                resp.setText(String.valueOf(kelvin)+"K");
            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double fahrenheit = Double.parseDouble(temp.getText().toString()) * 1.8 + 32;
                resp.setText(String.valueOf(fahrenheit+"°F"));
            }
        });

        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double reamur = Double.parseDouble(temp.getText().toString()) * 4 / 5;
                resp.setText(String.valueOf(reamur+"°R"));
            }
        });

        ra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double rankine = Double.parseDouble(temp.getText().toString());
                double rankine1 = (rankine + 273.15) * 9 / 5;
                resp.setText(String.format("%.2f°",rankine1));
            }
        });


    }

}
