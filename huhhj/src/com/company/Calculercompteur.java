package com.company;

public static void calculerCompeur(String chaine) {
    int cpt = 0;
    int indice = 0;
    for (int i = 0; i< chaine.length(); i++){
        char ind = chaine.charAt(i);
        int cpt2 = cpt;
        if (ind == '(') {
        cpt += 1;
        }
        else if (ind ==')') {
        cpt -= 1;
        }
        else {
        System.out.println("Pb");
        }
        if (cpt < 0) {
        indice = i;
        System.out.println(indice);
        break;
        }
        }
        }
