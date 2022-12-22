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
        setImpactTotal();
    }

    //Attributs :
    private Collection<Utilisateur> collection_utilisateur;
    private double impactTotal;

    //Setters :
    public void setCollection_utilisateur(Collection<Utilisateur> collection_utilisateur) {
        this.collection_utilisateur = collection_utilisateur;
        setImpactTotal();
    }



    /**
     * Methode qui calcule l'empreinte totale d'une population
     */
    public void setImpactTotal(){
        double somme = 0.0;
        for(Utilisateur u : this.collection_utilisateur){
            somme += u.calculerEmpreinte();
        }
        this.impactTotal = somme;
    }

    //Getters :
    /**
     * @return une collection d'utilisateur.
     */
    public Collection<Utilisateur> getCollection_utilisateur() {
        return this.collection_utilisateur;
    }

    /**
     * @return l'empreinte carbone totale pour toute une population.
     */
    public double getImpactTotal(){return this.impactTotal;}

    /**
     * Methode qui renvoie la moyenne de l'empreinte d'un utilisateur appartenent à la collection d'utilisateurs.
     * @return La moyenne de l'empreinte d'un utilisateur appartenent à la population (ie la collection d'utilisateurs).
     */
    public double MoyenneEmpreinte(){
        double n = this.collection_utilisateur.size();
        return (this.impactTotal/n);
    }

    /**
     * Exemple de mesure : Une mesure datant de 2020 interdisant les trajets en avion qui peuvent se faire en moins de 2h30 en TGV.
     * Les trajets en avion qui depassent 600km par trajet sont refuses.
     * On a calcule la distance (de maniere approximative) d'un trajet de 2h30 de TGV :  600 km.
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    public void Article145() throws ErrValNeg {
        //System.out.println("Aciens utilisateurs : " + this.getCollection_utilisateur());
        double impact_avant = this.impactTotal;
        ArrayList <Utilisateur> collection_utilisateur_new = new ArrayList<>();
        for (Utilisateur u : this.collection_utilisateur){
            ArrayList <Avion> avion_new = new ArrayList<>()   ;
            for (Avion a : u.getCollection_avion()) {
                if (a.getKm() < 600){
                    TGV t = new TGV(a.getKm());
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
        this.setImpactTotal();
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
                ", impactTotal=" + impactTotal +
                '}';
    }
}
