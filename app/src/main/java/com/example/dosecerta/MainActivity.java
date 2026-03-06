package com.example.dosecerta;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public

class MainActivity extends AppCompatActivity implements View

        .OnClickListener {

    Button btAddFoto, btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btAddFoto = findViewById(R.id.addfoto);
        btSalvar = findViewById(R.id.salvar);

        btAddFoto.setOnClickListener(this);
        btSalvar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){

    }
}