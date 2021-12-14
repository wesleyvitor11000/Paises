package com.example.pases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class sobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        Toolbar topbar = findViewById(R.id.topbar);

        setSupportActionBar(topbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        TextView about_text = findViewById(R.id.about_text);
        String text = "Este aplicativo foi desenvolvido para fins didáticos, visando o aprendizado das tecnologias de front-end Android.\n\n" +
                "Todos os dados e textos de informação foram retirados da WikiPédia.\n\n" +
                "Os ícones das bandeiras foram retiradas do endereço https://www.freepik.com/, já as demais imagens encontram-se no endereço https://www.flickr.com.\n\n" +
                "Todas as imagens utilizadas neste projeto foram retiradas da Internet e estão sob a licença Creative Commons, disponível em: https://creativecommons.org/licenses/by/2.0/";

        about_text.setText(text);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}