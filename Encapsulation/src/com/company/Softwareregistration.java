package com.company;

public class Softwareregistration
{

public Softwareregistration(int expiration)
{
 this.ExpirationVar = expiration ;
 System.out.println(" Enrengistrement du produit, valide jusqu'en " + this.ExpirationVar);
}

private int ExpirationVar;
}
