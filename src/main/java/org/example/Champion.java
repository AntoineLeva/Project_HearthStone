package org.example;
import java.util.ArrayList;
import java.util.Random;


public abstract class Champion implements ActionsChampion
{
    protected int id;
    protected String nom;
    protected int PV;
    protected ArrayList<Monstres> cartes;

    protected boolean speciale;

    public ArrayList<Integer> monstreJoue = new ArrayList<>();

    protected int mana;

    public Champion(int id, String nom, int PV, int mana, ArrayList<Monstres> cartes, boolean speciale)
    {
        this.id = id;
        this.nom = nom;
        this.PV = PV;
        this.mana = mana;
        this.cartes = cartes;
        this.speciale = speciale;
    }

    @Override
    public void attaquer(Champion cible, int degats)
    {
        cible.PV = cible.PV - degats ;
    }

    @Override
    public int tirageCarte(ArrayList<Monstres> cartes)       //définir un test pour empecher de dépasser 5 pose de carte
    {
        if (monstreJoue.size() == 5)
        {
            // La limite de 5 cartes jouées est atteinte, réinitialiser monstreJoue
            monstreJoue.clear();
        }

        int idCarte = tirageEntre1Et5();

        while(monstreJoue.contains(idCarte))  // permet de garantir que le numero generer sera unique;
        {
            idCarte = tirageEntre1Et5();
        }
        monstreJoue.add(idCarte);


        return idCarte;


    }

    @Override
    public void utiliserSpeciale()
    {
        // Implémentation de l'utilisation de la capacité spéciale générale
    }



    //Fonction pour tirer un nombre aléatoire entre 1 et 5 inclus.
    private static int tirageEntre1Et5()
    {
        Random random = new Random();
        int min = 1;
        int max = 5;

        int nombreAleatoire = random.nextInt(max - min) + 1;

        return nombreAleatoire;
    }
}
