import consoCarbonne.*;
import Utilisateur.*;

public class Main {
    public static void main(String[] args) {

        //Tests sur Logement
        Logement l = new Logement(140, CE.A);
        System.out.println(l.toString());
        l.setSuperficie(10);
        System.out.println(l.toString());

        Logement l2 = new Logement(140, CE.B);
        System.out.println(l2.getCe());


        //Tests sur Alimentation
        Alimentation a = new Alimentation(0.5, 0.2);
        System.out.println(a.toString());

        //Tests sur bienConso
        BienConso b = new BienConso(1750);
        System.out.println(b.toString());

        //Tests sur Transport:
        Transport t = new Transport(Taille.P, true, 5, 16 );
        System.out.println(t.toString());

        // b.impact= 1.0 et t.impact=0.26 donc t<b donc retourne -1
        System.out.println("Resultat du compareTo");
        System.out.println(t.compareTo(b));

        //Tests sur Services Public
        ServicesPublic s = ServicesPublic.getInstance();
        System.out.println("Resultat de l'impact du ServicesPublic ");
        System.out.println (s.getImpact());

        //Tests sur Utilisateur :
        Utilisateur u = new Utilisateur(a, b, l, t, s);
        System.out.println("Resultat de l'impact d'Utilisateur ");
        System.out.println(u.calculerEmpreinte());
        u.detaillerEmpreinte();
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
