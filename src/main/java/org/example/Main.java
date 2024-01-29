package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Antoine Leva, Allan Bekki");
        System.out.print("\n");

        Jeu partie = new Jeu();

        Champion joueur1 = partie.choixChampion("Joueur 1 ");
        Champion joueur2 = partie.choixChampion("Joueur 2 ");


        partie.boucleJeu(joueur1, joueur2);



    }
}
