package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Champion Dieu = new Pretre(1, "Dieu", 100, 3);
        Champion Sorcier = new Mage(2,"Merlin", 100, 3);

        System.out.println(Dieu);
        Sorcier.attaquer(Dieu);
        System.out.println(Dieu);
        Dieu.utiliserSpeciale();
        System.out.println(Dieu); */

        Champion Dieu = new Pretre(1, "Dieu", 100, 3);
        Champion Sorcier = new Mage(2, "Merlin", 100, 3);

        System.out.println("Antoine Leva, Allan Bekki");
        System.out.print("\n");

        Jeu partie = new Jeu();

        Champion joueur1 = partie.choixChampion("Joueur 1 ");
        Champion joueur2 = partie.choixChampion("Joueur 2 ");

        partie.boucleJeu(joueur1, joueur2);






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
