package com.miempresa.diccionario_esp_ing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;
    private EditText pEsp;
    private Button traducir;
    private TextView pIng;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        pEsp= findViewById(R.id.etPalabra);
        traducir= findViewById(R.id.btTraducir);
        pIng= findViewById(R.id.tvPalabraIng);

        mv.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                pIng.setText(s);
            }
        });

        traducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.traducir(pEsp.getText().toString().toLowerCase());
            }
        });

    }
}