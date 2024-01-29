package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck
{
    public ArrayList<Monstres> deck1;
    public ArrayList<Monstres> deck2;



    //création du deck 1
    public ArrayList<Monstres> getDeck1() {
        deck1.addAll(List.of(soigneurPretre, orcPretre, taurenPretre, mascottePretre, mortPretre));
        return deck1;
    }

    public void setDeck1(ArrayList<Monstres> deck1) {
        this.deck1 = deck1;
    }

    //Création du deck 2
    public ArrayList<Monstres> getDeck2() {
        deck2.addAll(List.of(soigneurMage, orcMage, taurenMage, mascotteMage, mortMage));
        return deck2;
    }

    public void setDeck2(ArrayList<Monstres> deck2) {
        this.deck2 = deck2;
    }

    //Constructeur
    public Deck()
    {
        this.deck1 = new ArrayList<>();
        this.deck2 = new ArrayList<>();


    }





    //Creation des monstres pour les decks
    MonstresSoigneur soigneurPretre = new MonstresSoigneur(1, "PretreCorrompu", 20, 5);
    MonstresClassique orcPretre = new MonstresClassique(2, "Orc", 30, 30);
    MonstresProtecteur taurenPretre = new MonstresProtecteur(3, "TaurenPaladin", 50, 5);
    MonstresMascotte mascottePretre = new MonstresMascotte(4, "mascottePretre", 10, 5);

    MonstresMortVivant mortPretre = new MonstresMortVivant(5, "PretreMort", 20, 20);




    MonstresSoigneur soigneurMage = new MonstresSoigneur(1, "MageCorrompu", 20, 5);
    MonstresClassique orcMage = new MonstresClassique(2, "OrcSpectrale", 30, 30);
    MonstresProtecteur taurenMage = new MonstresProtecteur(3, "TaurenDemonique", 50, 5);
    MonstresMascotte mascotteMage = new MonstresMascotte(4, "mascotteMage", 10, 5);

    MonstresMortVivant mortMage = new MonstresMortVivant(5, "MageMort", 20, 20);




}
