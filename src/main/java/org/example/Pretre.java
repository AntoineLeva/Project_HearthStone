package org.example;

import java.util.ArrayList;

public class Pretre extends Champion
{


    public Pretre(int id, String nom, int PV, int mana, ArrayList<Monstres> cartes, boolean speciale)
    {
        super(id, nom, PV, mana, cartes, speciale);

        // Implémentation spécifique pour le pretre
    }

    @Override
    public void utiliserSpeciale()
    {
        this.PV = this.PV + 15; //heal de 10 PV Ok
        speciale = false;
    }

    @Override
    public String toString() {
        return "Pretre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", PV=" + PV +
                ", cartes=" + cartes +
                ", mana=" + mana +
                '}';
    }
}
