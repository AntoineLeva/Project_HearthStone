package org.example;

public class MonstresProtecteur extends Monstres {
    public MonstresProtecteur(int id, String nom, int pointsDeVie, int forceAttaque) {
        super(id, nom, pointsDeVie, forceAttaque);
    }

    @Override
    public void jouerTour() {
        // Logique pour le tour de jeu du monstre protecteur
        System.out.println("Monstre protecteur " + getNom() + " protège son champion !");
    }
}
