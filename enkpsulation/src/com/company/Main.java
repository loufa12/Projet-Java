package com.company;

public class Main {

    public static void main(String[] args)
    {
	SoftwareRegistration sr = new SoftwareRegistration(2020);
        SoftwareRegistration sr2 = new SoftwareRegistration(2022);
    sr.setExpiratonyear(2050);
    System.out.println(sr.getExpirationyear());

    }
}
