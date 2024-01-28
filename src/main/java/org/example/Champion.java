package org.example;
import java.util.ArrayList;

public abstract class Champion implements ActionsChampion
{
    protected int id;
    protected String nom;
    protected int PV;
    protected ArrayList<Carte> cartes;

    protected int mana;

    public Champion(int id, String nom, int PV, int mana)
    {
        this.id = id;
        this.nom = nom;
        this.PV = PV;
        this.mana = mana;
        this.cartes = new ArrayList<>();
    }

    @Override
    public void attaquer(Champion cible)
    {
        cible.PV = cible.PV - 30 ;
    }

    @Override
    public void poserCarte(Carte carte)
    {
        // Implémentation du fait de poser une carte sur le plateau
    }

    @Override
    public void utiliserSpeciale()
    {
        // Implémentation de l'utilisation de la capacité spéciale générale
    }

}
