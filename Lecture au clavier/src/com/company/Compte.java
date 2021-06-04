package com.company;

public class Compte {

     public Double solde ;

// Constructeur
     public Compte(Double s){
         this.solde = s;
     }

     public void deposer(Double d){
         this.solde += d ;
     }

     public void retrait(Double r){
         this.solde -= r ;
     }

     public void afficher(){
         System.out.println( " votre solde est de : " + this.solde + " euros");
     }
}
