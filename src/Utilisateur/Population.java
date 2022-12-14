package Utilisateur;
import consoCarbonne.*;
import java.util.*;

public class Population {

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

    //Methode qui calcule l'empreinte totale d'une population
    public double CalculEmpreinte(){
        double somme = 0.0;
        for(Utilisateur u : this.collection_utilisateur){
            somme += u.calculerEmpreinte();
        }
        return (somme);
    }

    //Methode qui renvoie la moyenne de l'empreinte d'un utilisateur appartenent à la population
    public double MoyenneEmpreinte(){
        double n = this.collection_utilisateur.size();
        return (this.CalculEmpreinte()/n);
    }

    //Methodes à rajouter (si possible) :
    //Methode qui permet de detailler un a un chaque utilisateur
    //Methode qui permet de comparer un a un chaque catégorie (+ une comparaison a la moyenne d un francais)


    @Override
    public String toString() {
        return "Population{" +
                "collection_utilisateur=" + collection_utilisateur +
                '}';
    }
}
