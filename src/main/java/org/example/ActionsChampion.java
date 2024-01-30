package org.example;

import java.util.ArrayList;

public interface ActionsChampion
{
    void attaquer(Champion cible, int degats);
    int tirageCarte(ArrayList<Monstres> cartes);
    void utiliserSpeciale();
}
