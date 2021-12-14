package com.example.pases;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String paisesText = FileUtil.recuperarPaises(getAssets());

        RecyclerView paises_recycle = findViewById(R.id.country_recycle);
        Toolbar topBar = findViewById(R.id.topbar);

        setSupportActionBar(topBar);


        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("");
        }

        ArrayList<Pais> paises = PaisesManager.getPaisesFromString(this, paisesText);
        sortPaises(paises);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        
        PaisesAdapter paisesAdapter = new PaisesAdapter(paises);
        paises_recycle.setLayoutManager(linearLayoutManager);
        paises_recycle.setAdapter(paisesAdapter);




    }

    private static void sortPaises(ArrayList<Pais> paises){

        Collections.sort(paises, new Comparator<Pais>() {
            @Override
            public int compare(Pais pais, Pais pais2) {
                return pais.getName().compareTo(pais2.getName());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.about_menu){
            showAboutActivity();
        }

        return super.onOptionsItemSelected(item);
    }

    private void showAboutActivity(){

        Intent intent = new Intent(MainActivity.this, sobreActivity.class);
        startActivity(intent);
        //finish();

    }
    
    public static void showImageInfoDialog(@NonNull Pais pais, @NonNull Bitmap img, @NonNull Context c){

        AlertDialog.Builder img_info_dialog = new AlertDialog.Builder(c);

        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View layout_image_info = layoutInflater.inflate(R.layout.image_info_activity, null);

        ImageView image = layout_image_info.findViewById(R.id.image_info);
        image.setImageBitmap(img);

        TextView imageName = layout_image_info.findViewById(R.id.text_test);
        imageName.setText(pais.getImageName());

        TextView imageAutor = layout_image_info.findViewById(R.id.autor_name_info);
        imageAutor.setText(pais.getImageAutor());

        Button openImageButton = layout_image_info.findViewById(R.id.open_image_button);

        openImageButton.setOnClickListener(view -> openUrl(pais.getUrl(), c));

        img_info_dialog.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.cancel());

        img_info_dialog.setView(layout_image_info);
        img_info_dialog.show();

    }

    public static void openUrl(String url, Context c){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        c.startActivity(i);
    }

}