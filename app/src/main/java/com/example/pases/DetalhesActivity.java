package com.example.pases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);


        //*****TESTE********
        Bundle bundle = getIntent().getExtras();
        Toolbar topbar = findViewById(R.id.country_name_bar);
        Pais pais = (Pais)bundle.getSerializable("PAIS");
        topbar.setTitle(pais.getName());

        ImageView country_image = findViewById(R.id.country_image);
        Bitmap image = FileUtil.carregarImagem(getAssets(), "img/" + pais.getImageFileName());

        country_image.setImageBitmap(image);

    }
}