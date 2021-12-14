package com.example.paises;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;

public class PaisesManager {

    public static ArrayList<Pais> getPaisesFromString(Context c, String paisesText){

        ArrayList<Pais> paises = new ArrayList<>();

        if(paisesText == null || paisesText.isEmpty()){
            return paises;
        }

        String paisAtual = "";
        int end = 1;
        int start;

        while(true){
            start = paisesText.indexOf("#", end-1) + 1;

            if(start != -1) {
                end = paisesText.indexOf("#", start);

                if(end == -1){
                    paisAtual = paisesText.substring(start);
                }else{
                    paisAtual = paisesText.substring(start, end);
                }

                int    area = Integer.parseInt(getFieldValueFromText(paisAtual, "area:"));
                String capital = getFieldValueFromText(paisAtual, "capital:");
                String continent = getFieldValueFromText(paisAtual, "continent:");
                String currency = getFieldValueFromText(paisAtual, "currency:");
                String description = getFieldValueFromText(paisAtual, "description:");
                String language = getFieldValueFromText(paisAtual, "language:");
                String name = getFieldValueFromText(paisAtual, "\nname:");
                int    population = Integer.parseInt(getFieldValueFromText(paisAtual, "population:"));
                String imageFileName = getFieldValueFromText(paisAtual, "\nimage:");;
                String imageAutor = getFieldValueFromText(paisAtual, "image-author:");
                String imageName = getFieldValueFromText(paisAtual, "image-name:");
                String url = getFieldValueFromText(paisAtual, "url:");

                String iconName = getFieldValueFromText(paisAtual, "icon:");
                Bitmap icon = FileUtil.carregarImagem(c.getAssets(),"icon/" + iconName);

                Pais pais = new Pais(area, capital, continent, currency, description, icon, imageFileName, imageAutor, imageName, language, name, population, url);
                paises.add(pais);

                if(end == -1) break;

            }else{
                break;
            }
        }

        return paises;
    }

    private static String getFieldValueFromText(String text, String field){

        int start = text.indexOf(field);
        start = text.indexOf(":", start) + 2;
        int end   = text.indexOf("\n", start);

        if(start < 0 || end < 0){
            return "";
        }

        String fieldValue = text.substring(start, end);
        return fieldValue;
    }
}
