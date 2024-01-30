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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public ArrayList<Monstres> getCartes() {
        return cartes;
    }

    public void setCartes(ArrayList<Monstres> cartes) {
        this.cartes = cartes;
    }

    public ArrayList<Integer> getMonstreJoue() {
        return monstreJoue;
    }

    public void setMonstreJoue(ArrayList<Integer> monstreJoue) {
        this.monstreJoue = monstreJoue;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void attaquer(Champion cible, int degats)
    {
        cible.PV = cible.PV - degats ;
    }

    @Override
    public int poserCarte(ArrayList<Monstres> cartes)       //définir un test pour empecher de dépasser 5 pose de carte
    {
        int idCarte = tirageEntre1Et5();

        while(monstreJoue.contains(idCarte))  // permet de garantir que le numero generer sera unique;
        {
            idCarte = tirageEntre1Et5();
        }
        monstreJoue.add(idCarte);


        return idCarte;





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
        int max = 5;

        int nombreAleatoire = random.nextInt(max - min) + 1;

        return nombreAleatoire;
    }
}
