package com.example.pases;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {
    private static final String infoFileName = "info.txt";
    private static final String TAG = "FileUtil";

    @NonNull
    public static String recuperarPaises(@NonNull AssetManager assetManager){

        String conteudo = "";

        try {
            InputStream inputStream = assetManager.open(infoFileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader leitor = new BufferedReader(inputStreamReader);

            for(String linha = ""; linha != null; linha = leitor.readLine()){
                conteudo = conteudo.concat(linha + "\n");
            }

        } catch (IOException e) {
            Log.e(TAG, "Falha ao tentar ler o arquivo", e);
        }

        if(conteudo.length() > 0){
            return conteudo.substring(0, conteudo.length() - 1);
        }

        return conteudo;
    }

    @Nullable
    public static Bitmap carregarImagem(@NonNull AssetManager assetManager, @NonNull String imageDir){

        Bitmap image = null;

        try{
            InputStream inputStream = assetManager.open(imageDir);

            image = BitmapFactory.decodeStream(inputStream);

        }catch(IOException e){
            Log.e(TAG, "Falha ao abrir a imagem.", e);
        }

        return image;
    }

}
