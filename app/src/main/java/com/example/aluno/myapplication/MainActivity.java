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

    Button btn;
    TextView text;
    EditText edit;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Double taxa = 0.06;
        final Double tempo = 6.0;

        btn = findViewById(R.id.button);
        text = findViewById(R.id.textView);
        edit = findViewById(R.id.editText);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Double  valor = Double.valueOf(String.valueOf(edit.getText()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edit.getText().toString();


                ImageView img = new ImageView(getApplicationContext());
                img.setImageResource(R.drawable.meme1);

                Toast toast = new Toast(getApplicationContext());
                toast.setView(img);



            }
        });


    }
}
