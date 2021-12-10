package com.example.pases;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Pais implements Serializable {

    private int     area;
    private String  capital;
    private String  continent;
    private String  currency;
    private String  description;

    transient private Bitmap  icon;

    private String imageFileName;
    private String imageAutor;
    private String imageName;

    private String  language;
    private String  name;
    private int     population;
    private String  url;


    public Pais(int area, String capital, String continent, String currency, String description, Bitmap icon, String imageFileName, String imageAutor, String imageName, String language, String name, int population, String url) {

        this.area = area;
        this.capital = capital;
        this.continent = continent;
        this.currency = currency;
        this.description = description;
        this.icon = icon;
        this.imageFileName = imageFileName;
        this.imageAutor = imageAutor;
        this.imageName = imageName;
        this.language = language;
        this.name = name;
        this.population = population;
        this.url = url;

    }

    public int getArea() { return area; }
    public void setArea(int area) { this.area = area; }

    public String getCapital() { return capital; }
    public void setCapital(String capital) { this.capital = capital; }

    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Bitmap getIcon(){ return icon; }
    public void setIcon(Bitmap icon){ this.icon = icon; }

    public String getImageFileName(){ return imageFileName; }
    public void setImageFileName(String imageFileName){ this.imageFileName = imageFileName; }

    public String getImageAutor(){ return imageAutor; }
    public void setImageAutor(String imageAutor){ this.imageAutor = imageAutor; }

    public String getImageName(){ return imageName; }
    public void setImageName(String imageName){ this.imageName = imageName; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }

    public String getUrl(){ return url; }
    public void setUrl(String url){ this.url = url; }

}
