package org.example;

public abstract class Monstres {
    private int id;
    private String nom;
    private int PV;
    private int forceAttaque;

    // Constructeur
    public Monstres(int id, String nom, int PV, int forceAttaque) {
        this.id = id;
        this.nom = nom;
        this.PV = PV;
        this.forceAttaque = forceAttaque;
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

    public int getForceAttaque() {
        return forceAttaque;
    }

    public void setForceAttaque(int forceAttaque) {
        this.forceAttaque = forceAttaque;
    }



    @Override
    public String toString() {
        return "Monstres{" +
                "nom='" + nom + '\'' +
                ", PV=" + PV +
                ", forceAttaque=" + forceAttaque +
                '}';
    }
}

