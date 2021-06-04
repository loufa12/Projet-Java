package com.company;

public class Voiture {
    public String marque;
    public Double prix;


    // creation de setters
    public void setmarque(String m) {
        this.marque = m;
    }

    public void setprix(Double p) {
        this.prix = p;
    }

    // creation de getters
    public String getmarque() {
        return marque;
    }

    public Double getprix() {
        return prix;
    }

    public void affichage() {
        System.out.println("la marque est " + this.marque + " le prix est de " + this.prix);
    }

}
