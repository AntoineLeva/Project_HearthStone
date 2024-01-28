package org.example;

public class MonstresSoigneur extends Monstres {
    public MonstresSoigneur(int id, String nom, int pointsDeVie, int forceAttaque) {
        super(id, nom, pointsDeVie, forceAttaque);
    }

    @Override
    public void jouerTour() {
        // Logique pour le tour de jeu du monstre soigneur
        System.out.println("Monstre soigneur " + getNom() + " soigne une cible alliée ou ennemie !");
    }
}