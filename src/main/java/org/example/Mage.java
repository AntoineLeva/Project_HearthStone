package org.example;

public class Mage extends Champion
{
    public Mage(int id, String nom, int PV, int mana)
    {
        super(id, nom, PV, mana);

        // Implémentation spécifique pour le pretre
    }

    @Override
    public void utiliserSpeciale()
    {
        this.mana = this.mana + 2; // mana en plus
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
