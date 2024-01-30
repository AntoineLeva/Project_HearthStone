package org.example;

import java.util.ArrayList;

public class Mage extends Champion
{

    public Mage(int id, String nom, int PV, int mana, ArrayList<Monstres> cartes, boolean speciale)
    {
        super(id, nom, PV, mana, cartes, speciale);

        // Implémentation spécifique pour le pretre
    }

    @Override
    public void utiliserSpeciale()
    {
        this.mana = this.mana + 2; // mana en plus
        speciale = false;
    }


    @Override
    public String toString() {
        return "Mage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", PV=" + PV +
                ", cartes=" + cartes +
                ", mana=" + mana +
                '}';
    }
}
