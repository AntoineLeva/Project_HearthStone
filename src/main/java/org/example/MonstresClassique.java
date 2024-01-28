package org.example;

public class MonstresClassique extends Monstres {
    public MonstresClassique(int id, String nom, int pointsDeVie, int forceAttaque) {
        super(id, nom, pointsDeVie, forceAttaque);
    }

    @Override
    public void jouerTour() {
        // Logique pour le tour de jeu du monstre classique
        System.out.println("Monstre classique " + getNom() + " attaque !");
    }
}
