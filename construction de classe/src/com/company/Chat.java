package com.company;

public class Chat
{
    public Chat( String name, int age) // objet chat est construit
    {
        this.name = name ;
        this.age = age ;

        System.out.println("Je suis un chat : " + this ); // le mot clé this indique l'instnace en cours
        System.out.println(this.name + "---" + this.age);
    }

    private String name ;
    private int age ;

}
