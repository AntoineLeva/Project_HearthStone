package org.example;

import java.util.Scanner;

public class Jeu
{
    int choixJ1;
    int choixJ2;

    boolean fintourJ1 = false;
    boolean fintourJ2 = false;

    private Scanner scanner = new Scanner(System.in);
    public Jeu()
    {

    }

    public Champion choixChampion(String joueur) {
        System.out.println(joueur + "choisissez un Champion : 1. Pretre    2. Mage");

        int choix = scanner.nextInt();
        scanner.nextLine();  // Consomme le caractère de retour à la ligne et empeche le défilement sans la prise en compte du nom

        System.out.println("Donnez lui un nom :");
        String champJ1 = scanner.nextLine();

        switch (choix) {
            case 1:
                Champion Dieu = new Pretre(1, champJ1, 100, 3);
                return Dieu;
            case 2:
                Champion Sorcier = new Mage(2, champJ1, 100,3);
                return Sorcier;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
                return null;
        }
    }




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
            }while(champA.mana > 0 && champB.PV > 0 && !fintourJ1 );
            champA.mana = champA.mana +1;

//--------------------------verif fin de partie

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
            }while(champB.mana > 0 && champA.PV > 0 && !fintourJ2);
            champB.mana = champB.mana +1;


//--------------------------verif fin de partie

            if (champA.PV <= 0 || champB.PV <= 0 )
            {
                System.out.println("Le champion a perdu. Fin du jeu.");
                // Fermer le scanner
                scanner.close();

                break;
            }





        }
    }



    public void tourJoueur1(Champion champA, Champion champB)
    {
        fintourJ1 = false;
        afficherMenuJ1(champA, champB);
        choixJ1 = scanner.nextInt();

        switch (choixJ1) {
            case 1:
                champA.poserCarte(new Carte());
                break;
            case 2:
                champA.attaquer(champB);
                break;
            case 3:
                champA.utiliserSpeciale();
                break;
            case 4:
                System.out.println("Fin du tour.");
                fintourJ1 = true;
                champA.mana = champA.mana +1; //car c'est pas vrmt une action
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }

        champA.mana = champA.mana -1;
    }

    public void tourJoueur2(Champion champA, Champion champB)
    {
        fintourJ2 = false;
        afficherMenuJ2(champB, champA);
        choixJ2 = scanner.nextInt();

        switch (choixJ2)
        {
            case 1:
                champB.poserCarte(new Carte());
                break;
            case 2:
                champB.attaquer(champA);
                break;
            case 3:
                champB.utiliserSpeciale();
                break;
            case 4:
                System.out.println("Fin du tour.");
                fintourJ2 = true;
                champB.mana = champB.mana +1; //car c'est pas vrmt une action
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
        champB.mana = champB.mana -1;
    }





    // Méthode pour afficher le menu
    public void afficherMenuJ1(Champion champA, Champion champB)
    {
        System.out.println("Tour Joueur 1:");
        System.out.println("1. Poser une carte    3. Utiliser la capacité spéciale                           ");
        System.out.println("2. Attaquer           4. Fin du tour");
        System.out.println("Etat Champion : ");

        System.out.println(champA);
        System.out.println(champB);

        System.out.print("Choisissez une action : ");
    }

    // Méthode pour afficher le menu
    public void afficherMenuJ2(Champion champA, Champion champB)
    {
        System.out.println("Tour Joueur 2:");
        System.out.println("1. Poser une carte    3. Utiliser la capacité spéciale                           ");
        System.out.println("2. Attaquer           4. Fin du tour");
        System.out.println("Etat Champion : ");

        System.out.println(champA);
        System.out.println(champB);

        System.out.print("Choisissez une action : ");
    }
}
