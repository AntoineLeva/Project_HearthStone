package org.example;

public class MonstresMortVivant extends Monstres {
    private boolean estReanime;

    public MonstresMortVivant(int id, String nom, int pointsDeVie, int forceAttaque) {
        super(id, nom, pointsDeVie, forceAttaque);
        this.estReanime = false;
    }

    @Override
    public void jouerTour() {
        if (!estReanime) {
            // Logique pour le tour de jeu du mort-vivant (peut se réanimer une fois)
            System.out.println("Mort-vivant " + getNom() + " se réanime !");
            estReanime = true;
        } else {
            System.out.println("Mort-vivant " + getNom() + " attaque !");
        }
    }
}