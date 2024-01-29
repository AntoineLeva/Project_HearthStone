package org.example;

public class MonstresMortVivant extends Monstres {
    private boolean estReanime;

    public MonstresMortVivant(int id, String nom, int pointsDeVie, int forceAttaque) {
        super(id, nom, pointsDeVie, forceAttaque);
        this.estReanime = false;
    }


}