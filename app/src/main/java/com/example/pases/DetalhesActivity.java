package com.example.pases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        AppBarLayout barLayout = findViewById(R.id.detalhes_appbar);
        ImageButton  imageAboutButton = barLayout.findViewById(R.id.image_about_button);

        ImageView country_image = findViewById(R.id.country_image);
        TextView description_text = findViewById(R.id.description_text);
        TextView continent_text = findViewById(R.id.continent_detail_text);
        TextView capital_text = findViewById(R.id.capital_detail_text);
        TextView language_text = findViewById(R.id.language_detail_text);
        TextView population_text = findViewById(R.id.population_detail_text);
        TextView area_text = findViewById(R.id.area_detail_text);
        TextView currency_text = findViewById(R.id.currency_detail_text);



        //*****TESTE********
        Bundle bundle = getIntent().getExtras();
        Toolbar topbar = findViewById(R.id.country_name_bar);
        Pais pais = (Pais)bundle.getSerializable("PAIS");

        topbar.setTitle(pais.getName());


        Bitmap image = FileUtil.carregarImagem(getAssets(), "img/" + pais.getImageFileName());

        imageAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("CLICOU AQUI!");
            }
        });

        country_image.setImageBitmap(image);
        description_text.setText(pais.getDescription());
        continent_text.setText(pais.getContinent());
        capital_text.setText(pais.getCapital());
        language_text.setText(pais.getLanguage());
        population_text.setText(String.valueOf(pais.getPopulation()));
        area_text.setText(String.valueOf(pais.getArea()));
        currency_text.setText(pais.getCurrency());

    }
}