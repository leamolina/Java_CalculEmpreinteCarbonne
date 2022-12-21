package Utilisateur;
import Erreurs.ErrTx;
import Erreurs.ErrValNeg;
import consoCarbonne.*;
import java.util.*;

public class Population {

    //Constructeur par défaut :
    public Population (){}

    //Constructeur :
    public Population(Collection<Utilisateur> collection_utilisateur) {
        this.collection_utilisateur = collection_utilisateur;
        CalculEmpreinte();
    }

    //Attributs :
    private Collection<Utilisateur> collection_utilisateur;
    private double impactTotal;

    //Setters :
    public void setCollection_utilisateur(Collection<Utilisateur> collection_utilisateur) {
        this.collection_utilisateur = collection_utilisateur;
        CalculEmpreinte();
    }

    //Getters :
    public Collection<Utilisateur> getCollection_utilisateur() {
        return this.collection_utilisateur;
    }
    public double getImpactTotal(){return this.impactTotal;}

    /**
     * Methode qui calcule l'empreinte totale d'une population
     * @return L'empreinte totale d'une population
     */
    public void CalculEmpreinte(){
        double somme = 0.0;
        for(Utilisateur u : this.collection_utilisateur){
            somme += u.calculerEmpreinte();
        }
        this.impactTotal = somme;
    }

    /**
     * Methode qui renvoie la moyenne de l'empreinte d'un utilisateur appartenent à la collection d'utilisateurs.
     * @return La moyenne de l'empreinte d'un utilisateur appartenent à la population (ie la collection d'utilisateurs).
     */
    public double MoyenneEmpreinte(){
        double n = this.collection_utilisateur.size();
        return (this.impactTotal/n);
    }

    //Methodes à rajouter (si possible) :
    //Methode qui permet de detailler un a un chaque utilisateur
    //Methode qui permet de comparer un a un chaque catégorie avec la moyenne de notre population (+ une comparaison a la moyenne d un francais)

    //Comment utiliser la classe Population :
    // * Creer une methode qui porte le nom d'une mesure politique
    //   Exemple de mesure : reduire 10 min le temps d'eclairage de lumiere d'


    /*
    Exemple de mesure : Une mesure datant de 2020 interdisant les trajets en avion qui peuvent se faire en moins de 2h30 en TGV
    #Les trajets en avion qui depassent 600km par trajet sont refuse
    On a calcule la distance (de maniere approximative) d'un trajet de 2h30 de TGV :  600 km
    */

//    public void Article145() throws ErrValNeg, ErrTx {
//        double impact_total_avant = this.impactTotal;
//        //System.out.println("impact avant " + impact_total_avant);
//        Collection <Utilisateur> collection_utilisateur_new = new ArrayList();
//
//        for (Utilisateur u : this.collection_utilisateur){
//
//            //On ajoute a ce nouvel utilisateur les données qui ne vont pas changer :
//            Utilisateur u_new = new Utilisateur();
//            u_new.setAlimentation(u.getAlimentation());
//            u_new.setCollection_bus(u.getCollection_bus());
//            u_new.setService(u.getService());
//            u_new.setCollection_logement(u.getCollection_logement());
//            u_new.setBienConso(u.getBienConso());
//            u_new.setCollection_voiture(u.getCollection_voiture());
//
//            Collection<Avion> collection_avion_new = new ArrayList<>();
//            Collection<TGV> collection_tgv = u.getCollection_tgv();
//            //Pour chaque utilisateur, on parcourt la liste de ses transports en avion
//            for (Avion a: u.getCollection_avion()){
//                //System.out.println(a.getKilomAnnee());
//                //Si le transport est au dessus de 600km, on le laisse dans la collection d'avions
//                if (a.getKilomAnnee()>600){
//                    collection_avion_new.add(a);
//                }
//                //Si le transport est en dessous de 600km, on le transforme en trajet en tgv
//                else{
//                    TGV tgv = new TGV(a.getKilomAnnee());
//                    collection_tgv.add(tgv);
//
//                }
//            }
//            u_new.setCollection_tgv(collection_tgv);
//            u_new.setCollection_avion(collection_avion_new);
//            System.out.println("Colletion avion new" + u_new.getCollection_avion());
//            System.out.println("Colletion tgv new" + u_new.getCollection_tgv());
//
//            collection_utilisateur_new.add(u_new);
//        }
//        this.setCollection_utilisateur(collection_utilisateur_new);
//        double impact_total_apres = this.impactTotal;
//        //System.out.println("impact avant " + impact_total_avant);
//        //System.out.println("impact apres "  + impact_total_apres);
//        double diff = impact_total_avant - impact_total_apres;
//        System.out.println("L'impact total de la population est passé de " + impact_total_avant + " à " + impact_total_apres + ", soit une difference de :" + diff);
//    }
//
//

    public void Article145() throws ErrValNeg {
        //System.out.println("Aciens utilisateurs : " + this.getCollection_utilisateur());
        double impact_avant = this.impactTotal;
        Collection <Utilisateur> collection_utilisateur_new = new ArrayList();
        for (Utilisateur u : this.collection_utilisateur){
            Collection avion_new = new ArrayList()   ;
            for (Avion a : u.getCollection_avion()) {
                if (a.getKilomAnnee() < 600){
                    TGV t = new TGV(a.getKilomAnnee());
                    t.setCalculImpact();
                    Collection <TGV> liste_tgv_actuelle = u.getCollection_tgv();
                    liste_tgv_actuelle.add(t);
                    u.setCollection_tgv(liste_tgv_actuelle);
                }
                else{
                    a.setCalculImpact();
                    avion_new.add(a);

                }
            }
            u.setCollection_avion(avion_new);
            collection_utilisateur_new.add(u);

        }
        this.setCollection_utilisateur(collection_utilisateur_new);
        //System.out.println("Nouveaux utilisateurs : " + this.getCollection_utilisateur());
        this.CalculEmpreinte();
        double impact_apres = this.impactTotal;
        double difference = impact_avant - impact_apres;
        System.out.println("L'impact total de la population est passé de " + impact_avant + " à " + impact_apres + " soit une différence de " + difference + " .");
    }

    /**
     * @return une chaîne contenant les informations relatives a la classe Population.
     */
    @Override
    public String toString() {
        return "Population{" +
                "collection_utilisateur=" + collection_utilisateur +
                '}';
    }
}
