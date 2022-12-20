package Utilisateur;
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

    public void Article145() throws ErrValNeg {
        double impact_total_avant = this.impactTotal;
        for (Utilisateur u : this.collection_utilisateur){
            Collection<Avion> collection_avion_new = null;
            Collection<TGV> collection_tgv = u.getCollection_tgv();
            //Pour chaque utilisateur, on parcourt la liste de ses transports en avion
            for (Avion a: u.getCollection_avion()){
                //Si le transport est au dessus de 600km, on le laisse dans la collection d'avions
                if (a.getKilomAnnee()>600){
                    collection_avion_new.add(a);
                }
                //Si le transport est en dessous de 600km, on le tranforme en trajet en tgv
                else{
                    TGV tgv = new TGV(a.getKilomAnnee());
                    collection_tgv.add(tgv);
                }
            }
            u.setCollection_tgv(collection_tgv);
            u.setCollection_avion(collection_avion_new);
        }
        double impact_total_apres = this.impactTotal;
        double diff = impact_total_avant - impact_total_apres;
        System.out.println("L'impact total de la population est passé de " + impact_total_avant + " à " + impact_total_apres + ", soit une difference de :" + diff);
    }

    /*
    Autre exemple de mesure : considerer qu'avec l'aide de l'Etat sur l'isolation (pompe a chaleur, etc...), la classe
    energetique (CE) de chaque logement augmente en efficacite (TRES TRES SIMPLIFIE)
    Ou peut etre on peut considérer que ceux qui sont cata augmente et pas les autres ?
     */


    /*
    Autre exemple de mesure : passage de la voiture à moteur à une voiture electrique
    Autre exemple de mesure : passage d'un bus à moteur à un bus electrique
     */


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
