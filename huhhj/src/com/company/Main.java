package com.company;

import java.util.List;

public class main {


    public static void calculerCompteur(String chaine) {

        int result = 0;
        for(char c : chaine.toCharArray) {
            switch(c) {
                case '(':
                    result++;
                    break;
                case ')':
                    result--;
                    break;
            }
        }
        System.out.println(result)
