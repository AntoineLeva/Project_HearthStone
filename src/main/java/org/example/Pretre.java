package org.example;

public class Pretre extends Champion
{
    public Pretre(int id, String nom, int PV, int mana)
    {
        super(id, nom, PV, mana);

        // Implémentation spécifique pour le pretre
    }

    @Override
    public void utiliserSpeciale()
    {
        this.PV = this.PV + 15; //heal de 10 PV Ok
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
