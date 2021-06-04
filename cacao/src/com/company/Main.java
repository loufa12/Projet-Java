package com.company;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int[] tableau;
    public static final int SIZE = Integer.MAX_VALUE / 10000;

    public static void main(String[] args) {
        System.out.println("Les tableaux sont de taille " + SIZE);
        tableau = new int[SIZE];
        initialiserTableau();

        int[] tableauTriNatif = new int[SIZE];
        System.arraycopy(tableau, 0, tableauTriNatif, 0, SIZE);
        Instant start = Instant.now();

        long dureeMoyenne = 0;
        for (int i = 0; i < 100; i++) {
            initialiserTableau();
            //int[] tableauTriNatif = new int[SIZE];
            System.arraycopy(tableau, 0, tableauTriNatif, 0, SIZE);
            //Instant start = Instant.now();
            Arrays.sort(tableauTriNatif);
            Instant end = Instant.now();
            dureeMoyenne += Duration.between(start, end).toMillis();

        }
        System.out.println("Le tri natif a pris en moyenne " + dureeMoyenne + " ms.");

    }

    public static void initialiserTableau() {
        Instant start = Instant.now();
        System.out.println("Debut d'initialisation...");
        Random random = new Random();
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = random.nextInt(SIZE);
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L'initialisation a pris " + duration + " ms");
    }

    public static void triSelection(int[] copieTableau) {
        Instant start = Instant.now();
        // faire le tri
        for (int i = 0; i < copieTableau.length - 1; i++) {
            int indiceMin = i;
            for (int j = 1; j < copieTableau.length; j++) {
                if (copieTableau[j] < copieTableau[indiceMin]) {
                    indiceMin = j;
                }
            }
            int swap = copieTableau[i];
            copieTableau[i] = copieTableau[indiceMin];
            copieTableau[indiceMin] = swap;
        }
        Instant end = Instant.now();
        long duration = Duration.between(start,end).toMillis();
        System.out.println("Le tri par sélection a pris " + duration + " ms");
    }
}
