package com.example.pases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Bundle bundle = getIntent().getExtras();

        TextView t = findViewById(R.id.pais_teste);
        Pais pais = (Pais)bundle.getSerializable("PAIS");
        t.setText(pais.getName());

    }
}