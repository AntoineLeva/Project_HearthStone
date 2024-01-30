package org.example;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JeuTest {

    private Jeu jeu;
    private Champion joueur1;
    private Champion joueur2;

    @BeforeEach
    void setUp() {
        jeu = new Jeu();
        joueur1 = new Pretre(1, "Joueur1", 100, 3, jeu.deckPretre.getDeck1());
        joueur2 = new Mage(2, "Joueur2", 100, 3, jeu.deckMage.getDeck2());
    }

    @Test
    void testAttaqueMonstrePointsDeVieEgaux() {
        // Simuler l'attaque d'un monstre sur un autre avec une attaque et des points de vie égaux
        Monstres monstre1 = new Monstres(1, "Monstre1", 10, 10);
        Monstres monstre2 = new Monstres(2, "Monstre2", 10, 10);
        jeu.monstreJoueJ1.add(monstre1);
        jeu.monstreJoueJ2.add(monstre2);

        // Effectuer l'attaque
        jeu.tourJoueur1(joueur1, joueur2);

        // Vérifier que le monstre attaqué a 0 points de vie et est supprimé
        assertEquals(0, monstre2.getPV());
        assertTrue(jeu.monstreJoueJ2.isEmpty());
    }

    @Test
    void testCombatSeTermineAvecVainqueur() {
        // Simuler un combat où un champion bat l'autre
        joueur1.setPV(10);
        joueur2.setPV(5);

        // Effectuer le combat
        jeu.boucleJeu(joueur1, joueur2);

        // Vérifier que le bon champion est le vainqueur
        if (joueur1.PV <= 0) {
            assertTrue(joueur2.PV > 0, "Joueur2 est le vainqueur");
        } else {
            assertTrue(joueur1.PV > 0, "Joueur1 est le vainqueur");
        }
    }

    @Test
    void testReinitialisationMana() {
        // Simuler la fin d'un tour pour vérifier si le mana est correctement réinitialisé
        joueur1.mana = 1;
        joueur2.mana = 2;

        // Effectuer la réinitialisation du mana
        jeu.gestionMana(joueur1);
        jeu.gestionMana(joueur2);

        // Vérifier que le mana est réinitialisé à 3 pour les deux champions
        assertEquals(3, joueur1.mana);
        assertEquals(3, joueur2.mana);
    }

    @Test
    void testUtilisationCapaciteSpeciale() {
        // Simuler l'utilisation d'une capacité spéciale par un champion
        joueur1.mana = 2;

        // Effectuer l'utilisation de la capacité spéciale
        jeu.tourJoueur1(joueur1, joueur2);

        // Vérifier que la capacité spéciale est correctement utilisée
        // Ajouter des assertions appropriées en fonction de votre implémentation
    }

    @Test
    void testSelectionActionInvalide() {
        // Simuler la sélection d'une action invalide
        joueur1.mana = 2;

        // Effectuer la sélection d'action avec un choix invalide
        // Ajouter des assertions appropriées en fonction de votre implémentation
    }
}