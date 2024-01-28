package org.example;

public class MonstresMascotte extends Monstres {
    public MonstresMascotte(int id, String nom, int pointsDeVie, int forceAttaque) {
        super(id, nom, pointsDeVie, forceAttaque);
    }

    @Override
    public void jouerTour() {
        // Logique pour le tour de jeu de la mascotte
        System.out.println("Mascotte " + getNom() + " booste une cible alliée ou ennemie !");
    }
}