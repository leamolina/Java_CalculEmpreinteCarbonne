import consoCarbonne.*;
import Utilisateur.*;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Tests sur Logement
        Logement l = new Logement(140, CE.A);
        System.out.println(l.toString());
        l.setSuperficie(10);
        System.out.println(l.toString());

        Logement l2 = new Logement(140, CE.B);
        System.out.println(l2.getCe());

        //Tests du polymorphisme
        System.out.println("Test du polymorphisme");
        ConsoCarbonne c = new Alimentation(0.6, 0.1);
        System.out.println(c.toString());

        Alimentation a = new Alimentation(0.5, 0.2);
        BienConso b = new BienConso(1750);
        Transport t = new TGV(16 );
        Transport v = new Voiture(Taille.P, true, 10000,50);

        // b.impact= 1.0 et t.impact=0.26 donc t<b donc retourne -1
        System.out.println("Resultat du compareTo");
        System.out.println(t.compareTo(b));

        //Tests sur Services Public
        ServicesPublic s = ServicesPublic.getInstance();

        //Tests sur Utilisateur :
        //D'abbord on cree la liste des logements et on la remplit
        ArrayList liste_logement = new ArrayList();
        liste_logement.add(l);
        liste_logement.add(l2);

        //Maintenant on cree la liste des transports : une voiture et un TGV
        ArrayList liste_transport = new ArrayList();
        liste_transport.add(v);
        liste_transport.add(t);

        Utilisateur u = new Utilisateur(a, b, liste_logement, liste_transport, s);
        System.out.println("Resultat de l'impact d'Utilisateur ");
        System.out.println(u.calculerEmpreinte());
        u.detaillerEmpreinte();
        u.recommandation();


        //Tests sur Population
        Utilisateur u2 = u;
        ArrayList liste_utilisateurs = new ArrayList();
        liste_utilisateurs.add(u);
        liste_utilisateurs.add(u2);
        Population p = new Population(liste_utilisateurs);
        System.out.println(p.toString());







        /*
        PROJET JALON :

        3/4
        Robustesse : verifier ce que l utilisateur entre (voir ce qu'il fait quand on entre une valeur négative / Pas correcte)

        Structuration du projet et hierarchie des classes 0,5/1
        Polymorphisme 0,5/1

        Robustesse (gestion de l impact)
        Pas de test du polymorphisme
        Enumeration peuvent ztre ameliorées avec des attributs et des methodes
        */


    }


}
