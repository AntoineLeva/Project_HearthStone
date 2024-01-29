package org.example;
import java.util.ArrayList;
import java.util.Random;


public abstract class Champion implements ActionsChampion
{
    protected int id;
    protected String nom;
    protected int PV;
    protected ArrayList<Monstres> cartes;

    public ArrayList<Integer> monstreJoue = new ArrayList<>();

    protected int mana;

    public Champion(int id, String nom, int PV, int mana, ArrayList<Monstres> cartes)
    {
        this.id = id;
        this.nom = nom;
        this.PV = PV;
        this.mana = mana;
        this.cartes = cartes;
    }

    @Override
    public void attaquer(Champion cible)
    {
        cible.PV = cible.PV - 30 ;
    }

    @Override
    public void poserCarte(ArrayList<Monstres> cartes)       //définir un test pour empecher de dépasser 5 pose de carte
    {
        int idCarte = tirageEntre1Et5();

        while(monstreJoue.contains(idCarte))  // permet de garantir que le numero generer sera unique;
        {
            idCarte = tirageEntre1Et5();
        }
        monstreJoue.add(idCarte);
        System.out.println(cartes.get(idCarte));




        //System.out.println(idCarte);

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
        int max = 6;

        int nombreAleatoire = random.nextInt(max - min) + min;

        return nombreAleatoire;
    }
}
