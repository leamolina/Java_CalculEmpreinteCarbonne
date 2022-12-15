package Utilisateur;
import consoCarbonne.*;
import java.util.*;

public class Utilisateur {

    public Utilisateur(){}

    //Constructeur :
    public Utilisateur(Alimentation alimentation, BienConso bienConso, Collection<Logement> collection_logement, Collection<Transport> collection_transport, ServicesPublic service) {
        setAlimentation(alimentation);
        setBienConso(bienConso);
        setCollection_logement(collection_logement);
        setCollection_transport(collection_transport);
        setService(service);
    }

    private Alimentation alimentation;
    private BienConso bienConso;

    private Collection<Logement> collection_logement;
    private Collection<Transport> collection_transport;
    private ServicesPublic service;


    //Setters :

    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }

    public void setBienConso(BienConso bienConso) {
        this.bienConso = bienConso;
    }

    /**
     * @param collection_logement
     */
    public void setCollection_logement(Collection<Logement> collection_logement) {
        this.collection_logement = collection_logement;
    }

    /**
     * @param collection_transport
     */
    public void setCollection_transport(Collection<Transport> collection_transport) {
        this.collection_transport = collection_transport;
    }

    public void setService(ServicesPublic service) {
        this.service = service;
    }


    //Getters :
    public Alimentation getAlimentation() { return this.alimentation; }
    public BienConso getBienConso() {return this.bienConso; }

    /**
     * @return le poste de consommation carbone de l'utilisateur.rice concernant son logement
     */
    public Collection<Logement> getCollection_logement() { return this.collection_logement; }

    /**
     * @return le poste de consommation carbone de l'utilisateur.rice concernant ses deplacements
     */
    public Collection<Transport> getCollection_transport() { return this.collection_transport; }

    /**
     * @return le poste de consommation carbone de l'utilisateur.rice concernant son utilisation des services publics
     */
    public ServicesPublic getService() { return this.service; }




    //Methode qui fait la somme de tous les impacts des differents logements de la liste
    public double calculImpactLogement (Collection<Logement> collection_logement){
        double somme = 0.0;
        for (Logement l : collection_logement){
            somme += l.getImpact();
        }
        return (somme);
    }

    public double calculImpactTransport (Collection<Transport> collection_transport){
        double somme = 0.0;
        for (ConsoCarbonne t : collection_transport){
            somme += t.getImpact();
        }
        return (somme);
    }

    /**
     * Cette methode qui renvoie renvoie la somme des impacts de chaque catégorie
     * @return L'empreinte carbonne calculee de l'utilsateur.rice
     */
    
    public double calculerEmpreinte(){
        return(this.alimentation.getImpact() + this.bienConso.getImpact() + calculImpactLogement(this.collection_logement) + calculImpactTransport(this.collection_transport) + this.service.getImpact());
    }

    public void CompareAlimentation() {
        double moyenneAlimentation = 2.353;
        if (this.alimentation.getImpact() < moyenneAlimentation) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'alimentation d'un Francais ");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'alimentation d'un Francais ");
        }
    }
    public void CompareBienConso() {
        double moyenneBienConso = 2.625;
        if (this.bienConso.getImpact() < moyenneBienConso) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Bien conso d'un Francais ");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Bien conso d'un Francais ");
        }
    }
    public void CompareLogement() {
        double moyenneLogement = 2.706;
        if (calculImpactLogement(this.collection_logement)  < moyenneLogement) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Logement d'un Francais ");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Logement d'un Francais ");
        }
    }
    public void CompareTransport() {
        double moyenneTransport = 2.920;
        if (calculImpactTransport(this.collection_transport) < moyenneTransport) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un transport d'un Francais ");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un transport d'un Francais ");
        }
    }

    public void CompareService() {
        double moyenneService = 1.489;
        if (this.service.getImpact() < moyenneService) {
            System.out.println("L'impact des services est plus petit que la moyenne d'un Service d'un Francais ");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Service d'un Francais ");
        }
    }

    //Fonction qui compare l'empreinte de l'utilisateur avec l'empreinte moyenne d'un français
    public void detaillerEmpreinte(){

        System.out.println("Impact de l'alimentation : "+ this.alimentation.getImpact() );
        CompareAlimentation();

        System.out.println("Impact de bienConso : "+ this.bienConso.getImpact() );
        CompareBienConso();

        System.out.println("Impact du logement : "+ calculImpactLogement(this.collection_logement) );
        CompareLogement();

        System.out.println("Impact du transport : "+ calculImpactTransport(this.collection_transport));
        CompareTransport();

        System.out.println("Impact du service publique : "+ this.service.getImpact() );
        CompareService();

    }

    //Methode qui ordonne les consommations carbone de l’utilisateur.rice dans une liste
    //puis présente l’information obtenue à ce.tte dernier.e,
    // puis fait des recommendations pour obtenir un mode de vie plus durable.

    //On fait une methode qui, quand on lui donne un double, retourne le type;
    //S'il est plus eleve que la moyenne, print une recommandation

    /**
     * Cette methode ordonne les consommations carbone de l’utilisateur.rice dans une liste, présente l’information obtenue à ce.tte dernier.e
     * Et fait des recommendations pour obtenir un mode de vie plus durable.
     * Nous avons fait une methode qui, lorsqu'on lui donne un double, retourne le type
     * si celui ci est plus eleve que la moyenne, nous affichons une recommandation
     * @param i
     */
    public void recommandationImpact(double i) {
        //Alimenation :
        if (i == this.alimentation.getImpact()) {
            System.out.println("L'impact de l'alimentation est de :" + i);
            if (i >= 2.353) {
                System.out.println("Il est superieur à la moyenne d'un Français dans cette catégorie");
                System.out.println("Recommandation : privilégier les fruits, légumes et les aliments d'origine végétale par rapport à la viande.");
            }
        } else if (i == this.bienConso.getImpact()) {
            System.out.println("L'impact des biens conso est de :" + i);
            if (i >= 2.625) {
                System.out.println("Il est superieur à la moyenne d'un Français dans cette catégorie");
                System.out.println(" Recommandations : Éviter les achats impulsifs. Emprunter et louer. ");
            }
        } else if (i == calculImpactLogement(this.collection_logement)) {
            System.out.println("L'impact du logement est de :" + i);
            if (i >= 2.706) {
                System.out.println("Il est superieur à la moyenne d'un Français dans cette catégorie");
                System.out.println(" Recommandations : Privilegier un logement de bonne classe energetique ");
            }
        } else if (i == calculImpactTransport(this.collection_transport)) {
            System.out.println("L'impact du transport est de :" + i);
            if (i >= 2.920) {
                System.out.println("Il est superieur à la moyenne d'un Français dans cette catégorie");
                System.out.println(" Recommandations : Eviter les trajets en voiture. Privilegier les transports en communs ");
            }
        } else if (i == this.service.getImpact()) {
            System.out.println("L'impact des services publiques est de :" + i);
            //On décide de ne pas donner de recommandation sur les services publiques, sachant que la valeur est unique, et qu'aucun parametre ne pourra modifier cet impact
            //En d'autres termes, l'utilisateur ne peut rien faire pour diminuer l'impact de cette catégorie
        }
    }
    public void recommandation() {
        double[] impacts = {this.alimentation.getImpact(), this.bienConso.getImpact(), calculImpactLogement(this.collection_logement), calculImpactTransport(this.collection_transport), this.service.getImpact()};
        //Affichage de l'array :
        for (int i = 0; i < 5; i++) {
            recommandationImpact(impacts[i]);
            System.out.println(impacts[i]);
        }
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "alimentation=" + alimentation +
                ", bienConso=" + bienConso +
                ", liste_logement=" + collection_logement +
                ", transport=" + collection_transport +
                ", service=" + service +
                '}';
    }


}

