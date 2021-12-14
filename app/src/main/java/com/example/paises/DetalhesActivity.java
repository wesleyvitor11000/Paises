package com.example.paises;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;

import java.text.NumberFormat;
import java.util.Locale;

public class DetalhesActivity extends AppCompatActivity {

    private Pais pais;
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        AppBarLayout barLayout = findViewById(R.id.detalhes_appbar);

        //ImageButton  imageAboutButton = barLayout.findViewById(R.id.image_about_button);
        Toolbar topbar = findViewById(R.id.country_name_bar);

//        imageAboutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("CLICOU AQUI!");
//            }
//        });

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

        pais = (Pais)bundle.getSerializable("PAIS");

        topbar.setTitle(pais.getName());

        setSupportActionBar(topbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        image = FileUtil.carregarImagem(getAssets(), "img/" + pais.getImageFileName());

        String population = NumberFormat.getInstance(Locale.FRANCE).format(pais.getPopulation());

        String area = NumberFormat.getInstance(Locale.ITALY).format(pais.getArea());
        area = area.concat(" km²");

        country_image.setImageBitmap(image);
        description_text.setText(pais.getDescription());
        continent_text.setText(pais.getContinent());
        capital_text.setText(pais.getCapital());
        language_text.setText(pais.getLanguage());
        population_text.setText(population);
        area_text.setText(area);
        currency_text.setText(pais.getCurrency());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.about_menu){
            MainActivity.showImageInfoDialog(pais, image, DetalhesActivity.this);
        }

        return super.onOptionsItemSelected(item);
    }
}