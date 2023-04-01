package com.example.dividirconta;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int ProgressStatus = 10;

    private EditText valor1;
    private EditText valor2;
    private EditText valor3;
    private EditText valor4;
    private EditText valorgarcom;

    private SeekBar seekBar;
    private TextView txtSeekBar;

    private EditText bebida;
    private EditText sembebida;
    private EditText textView14;

    private Button c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INICIALIZAR COMPONENTES VISUAIS
        Inicializar();
        // DEFINE ACAO PARA SEEKBAR
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar,
                                          int progress, boolean fromUser) {
                ProgressStatus = progress;
                txtSeekBar.setText(String.valueOf(ProgressStatus) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    private void Inicializar() {
        seekBar = findViewById(R.id.seekBarId);
        valor1 = (EditText) findViewById(R.id.valorId);
        valor2 = (EditText) findViewById(R.id.valor2Id);
        valor3 = (EditText) findViewById(R.id.valor3Id);
        valor4 = (EditText) findViewById(R.id.valor4Id);
        valorgarcom = (EditText) findViewById(R.id.ValorGarcomId);
        txtSeekBar = (TextView) findViewById(R.id.txtSeekBar);
        c = (Button) findViewById(R.id.button2);
        bebida= (EditText) findViewById(R.id.bebida);
        sembebida= (EditText) findViewById(R.id.sembebida);
        textView14= (EditText) findViewById(R.id.textView14);
    }


    public void Calcular(View view) {
        int pessoasBebe = Integer.parseInt(valor4.getText().toString());
        double valor = Double.parseDouble(valor1.getText().toString());
        double pessoas = Double.parseDouble(valor2.getText().toString());
        double valorBebidas = Double.parseDouble(valor3.getText().toString());
        double valorGarcom = (valor / 100) * ProgressStatus;
        double valorTotal = (valor + valorGarcom);
        double noBebidas = valorBebidas / pessoasBebe;
        double valorIndividual = (valorTotal - valorBebidas) / pessoas;
        double valorBebidasTotal = valorIndividual + noBebidas;

        valorgarcom.setText("R$ " + String.format("%02.2f", valorGarcom));
        textView14.setText("R$ " + String.format("%02.2f", valorTotal));
        bebida.setText("R$ " + String.format("%02.2f", valorBebidasTotal));
        sembebida.setText("R$ " + String.format("%02.2f", valorIndividual));
    }
}