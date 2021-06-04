package com.company;

public class SoftwareRegistration
{

public SoftwareRegistration(int expiration)
{

    if ( Numberofregistrations > 0 )
    {
        this.Expirationyear = expiration;
        Numberofregistrations--;

        System.out.println("logiciel valide ( expiration :  " + this.Expirationyear + ")");
        System.out.println( " Enrengistrements restant : "+ this.Numberofregistrations) ;
    }

    else
    {
        System.out.println("Maximum de validations effectués");
    }
}
// getter , retourne l'attribut
public int getExpirationyear()
{ return this.Expirationyear; }

// Setter , prend une information pour modifier un attribut
public void setExpiratonyear( int expiration)
{this.Expirationyear = expiration ; }

private int Expirationyear ;
private static int Numberofregistrations = 5 ; // variable de classe commune à tt les instances
}
