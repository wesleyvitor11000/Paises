package com.example.pases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String paisesText = FileUtil.recuperarPaises(getAssets());

        RecyclerView paises_recycle = findViewById(R.id.country_recycle);
        ImageView about_button = findViewById(R.id.about_button);
        Toolbar topBar = findViewById(R.id.topbar);

        setSupportActionBar(topBar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("");
        }

        ArrayList<Pais> paises = PaisesManager.getPaisesFromString(this, paisesText);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);


        PaisesAdapter paisesAdapter = new PaisesAdapter(paises);
        paises_recycle.setLayoutManager(linearLayoutManager);
        paises_recycle.setAdapter(paisesAdapter);

        about_button.setOnClickListener(view -> showAboutActivity());

    }

    private void showAboutActivity(){

        Intent intent = new Intent(MainActivity.this, sobreActivity.class);
        startActivity(intent);
        finish();

    }
}