package Utilisateur;
import consoCarbonne.*;
import java.util.*;

public class Population {

    //Constructeur par défaut :
    public Population (){}

    //Constructeur :
    public Population(Collection<Utilisateur> collection_utilisateur) {
        this.collection_utilisateur = collection_utilisateur;
    }

    //Attributs :
    private Collection<Utilisateur> collection_utilisateur;

    //Setters :
    public void setCollection_utilisateur(Collection<Utilisateur> collection_utilisateur) {
        this.collection_utilisateur = collection_utilisateur;
    }

    //Getters :
    public Collection<Utilisateur> getCollection_utilisateur() {
        return this.collection_utilisateur;
    }

    /**
     * Methode qui calcule l'empreinte totale d'une population
     * @return L'empreinte totale d'une population
     */
    public double CalculEmpreinte(){
        double somme = 0.0;
        for(Utilisateur u : this.collection_utilisateur){
            somme += u.calculerEmpreinte();
        }
        return (somme);
    }

    /**
     * Methode qui renvoie la moyenne de l'empreinte d'un utilisateur appartenent à la collection d'utilisateurs.
     * @return La moyenne de l'empreinte d'un utilisateur appartenent à la population (ie la collection d'utilisateurs).
     */
    public double MoyenneEmpreinte(){
        double n = this.collection_utilisateur.size();
        return (this.CalculEmpreinte()/n);
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
    Pour chaque utilisateur, si sa
    Limite de la methode : Si l'utilisateur decide de faire un trajet de 400km, et un autre de 500km, sa distance totale sera de 900km.
    Et la mesure ne sera pas applliquable pour lui (c'est pas ce que je veux)
    */


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
