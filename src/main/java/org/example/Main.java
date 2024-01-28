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



        Jeu partie = new Jeu();

        Champion joueur1 = partie.choixChampion("Joueur 1 ");
        Champion joueur2 = partie.choixChampion("Joueur 2 ");

        partie.boucleJeu(joueur1, joueur2);



    }
}
