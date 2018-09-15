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

                Double valorDepositado = Double.parseDouble(editValor.getText().toString());
                Integer qntMeses = Integer.valueOf(editMeses.getText().toString());
                Double taxaDeJuros = i * 0.01;
                Double result;
                textJuros.setText(String.valueOf(i) + '%');

                result = 0.0;

                //for(Integer index = 0; index < qntMeses; index++) {
                //    result += (valorDepositado + result)*taxaDeJuros;
                //}

                result = valorDepositado * Math.pow((1+taxaDeJuros),qntMeses);

                textValorTotal.setText("R$"+String.format("%.2f",result));
                textJurosRecebido.setText("R$"+String.format("%.2f",(result-valorDepositado)));
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
