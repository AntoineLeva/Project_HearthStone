package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Jeu
{
    int choixJ1;
    int choixJ2;

    Deck deckPretre = new Deck();
    Deck deckMage = new Deck();

    ArrayList<Monstres> monstreJoueJ1 = new ArrayList<>();
    ArrayList<Monstres> monstreJoueJ2 = new ArrayList<>();





    boolean finTourJ1 = false;
    boolean finTourJ2 = false;

    private Scanner scanner = new Scanner(System.in);
    public Jeu()
    {

    }

    //Choix du champion
    public Champion choixChampion(String joueur) {
        System.out.println(joueur + "choisissez un Champion : 1. Pretre    2. Mage");

        int choix = scanner.nextInt();
        scanner.nextLine();  // Consomme le caractère de retour à la ligne et empeche le défilement sans la prise en compte du nom

        System.out.println("Donnez lui un nom :");
        String champJ1 = scanner.nextLine();

        switch (choix) {
            case 1:
                Champion Dieu = new Pretre(1, champJ1, 100, 3, deckPretre.getDeck1());
                return Dieu;
            case 2:
                Champion Sorcier = new Mage(2, champJ1, 100,3, deckMage.getDeck2());
                return Sorcier;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
                return null;
        }
    }




    //Boucle principale de jeu, tout le jeu est dans cette fonction
    public void boucleJeu(Champion champA, Champion champB)
    {
        // Scanner pour lire l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);


        // Boucle de jeu
        while (true) {


//-------------------------tour joueur 1
            do
            {
                tourJoueur1(champA,champB);
            }while(champA.mana > 0 && champB.PV > 0 && !finTourJ1 );
                gestionMana(champA);

//--------------------------verif fin de partie à chaque tour si les PV du d'un des champions sont égale ou inféreur à 0

            if (champA.PV <= 0 || champB.PV <= 0 )
            {
                System.out.println(champA);
                System.out.println(champB);
                System.out.println("Le champion a perdu. Fin du jeu.");

                scanner.close();

                break;
            }


//-------------------------tour joueur 2

            do
            {
                tourJoueur2(champA,champB);
            }while(champB.mana > 0 && champA.PV > 0 && !finTourJ2);
                gestionMana(champB);


//--------------------------verif fin de partie à chaque tour si les PV du d'un des champions sont égale ou inféreur à 0

            if (champA.PV <= 0 || champB.PV <= 0 )
            {
                if(champA.PV <=0)
                    System.out.println("Le champion " + champA.nom +" a perdu. Fin du jeu.");
                System.out.println("Le champion " + champB.nom +" a perdu. Fin du jeu.");

                // Fermer le scanner
                scanner.close();

                break;
            }

        }
    }



    public void tourJoueur1(Champion champA, Champion champB)
    {
        finTourJ1 = false; //variable a remettre en false pour que le le tour ce lance
        afficherMenuJ1(champA, champB);
        choixJ1 = scanner.nextInt();

        switch (choixJ1) {
            case 1:
                int idMonstre = champA.poserCarte(champA.cartes);
                monstreJoueJ1.add(champA.cartes.get(idMonstre)); //ajout de la carte dans le deck

                break;
            case 2:
                int forceTotale = 0;
                for(Monstres m :monstreJoueJ1)
                {
                   forceTotale = forceTotale + m.getForceAttaque();
                }
                if(monstreJoueJ2.isEmpty())
                {
                    champA.attaquer(champB, forceTotale);
                    System.out.println("Les montres ont ingligés : " + forceTotale + " point de dégats au champion ennemi \n");

                }
                else
                {
                    int tailleMonstreJoue = monstreJoueJ2.size();

                    //selection du monstre aleatoire qui va etre attaqué
                    Random random = new Random();
                    int min = 1;
                    int max = tailleMonstreJoue -1;

                    int monstreAttaquer = 0;// = random.nextInt(max - min) + min;
                    if (max > min) {
                        monstreAttaquer = random.nextInt(max - min + 1) + min;
                    }

                    monstreJoueJ2.get(monstreAttaquer).setPV(monstreJoueJ2.get(monstreAttaquer).getPV() - forceTotale);
                    if (monstreJoueJ2.get(monstreAttaquer).getPV() <= 0)
                        monstreJoueJ2.remove(monstreAttaquer);
                }





                System.out.println("Les montres ont ingligés : " + forceTotale + " point de dégats \n");

                break;
            case 3:
                champA.utiliserSpeciale();
                break;
            case 4:
                System.out.println("Fin du tour.");
                finTourJ1 = true; //pour écourter le tour
                champA.mana = champA.mana +1; // chaque action consomme 1 de mana, donc +1 car c'est pas vraiment une action
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }

        champA.mana = champA.mana -1; //on enleve 1 de mana pour chaque action
    }

    public void tourJoueur2(Champion champA, Champion champB)
    {
        finTourJ2 = false; //variable a remettre en false pour que le le tour ce lance
        afficherMenuJ2(champB, champA);
        choixJ2 = scanner.nextInt();

        switch (choixJ2)
        {
            case 1:
                int idMonstre = champB.poserCarte(champB.cartes);
                monstreJoueJ2.add(champB.cartes.get(idMonstre)); //ajout de la carte dans le deck
                break;
            case 2:
                int forceTotale = 0;
                for(Monstres m :monstreJoueJ2)
                {
                    forceTotale = forceTotale + m.getForceAttaque();
                }

                if(monstreJoueJ1.isEmpty())
                {
                    champB.attaquer(champA, forceTotale);
                    System.out.println("Les montres ont ingligés : " + forceTotale + " point de dégats au champion ennemi \n");
                }

                else
                {
                    int tailleMonstreJoue = monstreJoueJ1.size();

                    //selection du monstre aleatoire qui va etre attaqué
                    Random random = new Random();
                    int min = 1;
                    int max = tailleMonstreJoue -1;

                    int monstreAttaquer = 0;// = random.nextInt(max - min) + min;
                    if (max > min) {
                        monstreAttaquer = random.nextInt(max - min + 1) + min;
                    }

                    monstreJoueJ1.get(monstreAttaquer).setPV(monstreJoueJ1.get(monstreAttaquer).getPV() - forceTotale);
                    if (monstreJoueJ1.get(monstreAttaquer).getPV() <= 0)
                        monstreJoueJ1.remove(monstreAttaquer);
                }
                System.out.println("Les montres ont ingligés : " + forceTotale + " point de dégats \n");

            case 3:
                champB.utiliserSpeciale();
                break;
            case 4:
                System.out.println("Fin du tour.");
                finTourJ2 = true; //pour écourter le tour
                champB.mana = champB.mana +1; // chaque action consomme 1 de mana, donc +1 car c'est pas vraiment une action
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
        champB.mana = champB.mana -1; //on enleve 1 de mana pour chaque action
    }





    // Méthode pour afficher le menu
    public void afficherMenuJ1(Champion champA, Champion champB)
    {

        System.out.println("\n Tour Joueur 1:");
        System.out.println("1. Poser une carte    3. Utiliser la capacité spéciale                           ");
        System.out.println("2. Attaquer           4. Fin du tour");
        System.out.println("Etat Champion : ");

        System.out.println(champA); //etat des champions
        System.out.println(champB);
        System.out.println("\n Monstre en jeu : "+ monstreJoueJ1); //etat des monstres posé

        System.out.print("Choisissez une action : ");
    }

    // Méthode pour afficher le menu
    public void afficherMenuJ2(Champion champA, Champion champB)
    {
        System.out.println("\n Tour Joueur 2:");
        System.out.println("1. Poser une carte    3. Utiliser la capacité spéciale                           ");
        System.out.println("2. Attaquer           4. Fin du tour");
        System.out.println("Etat Champion : ");

        System.out.println(champA); //etats des champions
        System.out.println(champB);
        System.out.println("\n Monstres en jeu : "+ monstreJoueJ2);

        System.out.print("Choisissez une action : ");
    }


    public void gestionMana(Champion champ) //permet de reset le mana si <3 retourne à 3 à chaque nouveau tour
    {
        if(champ.mana == 1)
            champ.mana = champ.mana +1;
        if(champ.mana == 0)
            champ.mana = champ.mana +2;
        champ.mana = champ.mana +1;
    }




}
