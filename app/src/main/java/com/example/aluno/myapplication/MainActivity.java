package com.example.aluno.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView text;
    TextView textJuros;
    TextView textJurosRecebido;
    TextView textValorTotal;
    EditText editMeses;
    EditText editValor;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Double taxa = 0.06;
        final Double tempo = 6.0;

        textJuros = findViewById(R.id.textViewTaxa);
        text = findViewById(R.id.textView);
        editValor = findViewById(R.id.editValor);
        seekBar = findViewById(R.id.seekBarTaxa);
        editMeses = findViewById(R.id.editMeses);
        textJurosRecebido = findViewById(R.id.textJurosRecebido);
        textValorTotal = findViewById(R.id.textValorTotal);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int  i, boolean b) {

                Double valorDepositado = Double.valueOf(String.valueOf(editValor.getText()));
                Integer qntMeses = Integer.valueOf(String.valueOf(editMeses.getText()));
                Double taxaDeJuros = i * 0.01;
                Double result;
                textJuros.setText(i + '%');

                //result = qntMeses * (taxaDeJuros * valorDepositado);
                result = valorDepositado;

                for(Integer index = 0; index < qntMeses; index++) {
                    result += qntMeses * (taxaDeJuros * result);
                }
                textValorTotal.setText("R$"+result+valorDepositado);
                textJurosRecebido.setText("R$"+result);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
