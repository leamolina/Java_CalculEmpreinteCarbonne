import consoCarbonne.*;
import Utilisateur.*;
import java.io.IOException;
import Erreurs.*;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import java.lang.*;


public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException, ErrValNeg, ErrTx {

        Scanner scan = new Scanner(System.in);

        EntreeSortie e = new EntreeSortie();
        System.out.println("Creation du premier utilisateur de la population"  + '\n');
        Utilisateur u1 = e.AffichageUtilisateur();

        System.out.println("Entrez 1 si vous souhaitez voir votre impact, 0 sinon");
        int choice = scan.nextInt();
        switch(choice){
            case(0):
                break;
            case(1):
                System.out.println("L'impact total est de : " + u1.calculerEmpreinte());
                System.out.println("Le détail de l'impact est le suivant : ");
                u1.detaillerEmpreinte();
                break;
            default:
                System.out.println("Choix incorrect. Par défaut, nous considérons que vous avez entré 0.");
        }


        System.out.println("Entrez 1 si vous souhaitez avoir des conseils pour réduire votre consommation carbonne, O sinon");
        choice = scan.nextInt();
        switch(choice){
            case(0):
                break;
            case(1):
                u1.recommandation();
                break;
            default:
                System.out.println("Choix incorrect. Par défaut, nous considérons que vous avez entré 0.");
        }

        System.out.println("Creation du second utilisateur de la population"  + '\n');
        Utilisateur u2 = e.AffichageUtilisateur();

        ArrayList<Utilisateur> liste_utilisateur = new ArrayList();
        liste_utilisateur.add(u1);
        liste_utilisateur.add(u2);
        Population p = new Population(liste_utilisateur);

        System.out.println("L'Article 145 (voté en 2020) est un loi interdisant les trajets en Avion ui peuvent se faire en moins de 2h30 en TGV");
        System.out.println("En appliquant cet Article sur la population (composée des deux utilisateurs initialisés précédement, nous allons transformer tous les trajets d'Avion de plus de 600km en trajets de TGV");
        System.out.println("Entrez 1 si vous souhaitez appliquer l'Article 145 sur la population, O sinon");
        choice = scan.nextInt();
        switch(choice){
            case(0):
                break;
            case(1):
                p.Article145();
                break;
            default:
                System.out.println("Choix incorrect. Par défaut, nous considérons que vous avez entré 0.");
        }

        scan.close();



    }


}
