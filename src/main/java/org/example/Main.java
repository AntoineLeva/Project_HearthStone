package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Antoine Leva, Allan Bekki");
        System.out.print("\n");

        Monstres monstreClassique = new MonstresClassique(1, "MonstreClassique", 10, 5);
        Monstres monstreProtecteur = new MonstresProtecteur(2, "MonstreProtecteur", 15, 3);
        Monstres monstreSoigneur = new MonstresSoigneur(3, "MonstreSoigneur", 8, 2);
        Monstres monstreMascotte = new MonstresMascotte(4, "MonstreMascotte", 12, 4);
        Monstres monstreMortVivant = new MonstresMortVivant(5, "MortVivant", 8, 6);

        monstreClassique.jouerTour();
        monstreProtecteur.jouerTour();
        monstreSoigneur.jouerTour();
        monstreMascotte.jouerTour();
        monstreMortVivant.jouerTour();
        monstreMortVivant.jouerTour(); // Le mort-vivant se réanime une seule fois
    }
}