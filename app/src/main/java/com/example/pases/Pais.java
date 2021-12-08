package com.example.pases;

public class Pais {

    private int     area;
    private String  capital;
    private String  continent;
    private String  currency;
    private String  description;

    //************icon, image, image-author, image-name.***********

    private String  language;
    private String  name;
    private int     population;

    //*************url****************


    public Pais(int area, String capital, String continent, String currency, String description, String language, String name, int population) {

        this.area = area;
        this.capital = capital;
        this.continent = continent;
        this.currency = currency;
        this.description = description;

        //************icon, image, image-author, image-name.***********

        this.language = language;
        this.name = name;
        this.population = population;

        //***********url************

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

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }

}
