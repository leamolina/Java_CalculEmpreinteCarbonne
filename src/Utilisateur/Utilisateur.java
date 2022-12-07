package Utilisateur;

import consoCarbonne.*;

public class Utilisateur {

    //Constructeur :
    public Utilisateur(Alimentation alimentation, BienConso bienConso, Logement logement, Transport transport, ServicesPublic service) {
        setAlimentation(alimentation);
        setBienConso(bienConso);
        setLogement(logement);
        setTransport(transport);
        setService(service);
    }

    Alimentation alimentation;
    BienConso bienConso;
    Logement logement;
    Transport transport;
    ServicesPublic service;


    //Setters :

    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }

    public void setBienConso(BienConso bienConso) {
        this.bienConso = bienConso;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void setService(ServicesPublic service) {
        this.service = service;
    }


    //Getters :
    public Alimentation getAlimentation() { return this.alimentation; }
    public BienConso getBienConso() {return this.bienConso; }
    public Logement getLogement() { return this.logement; }
    public Transport getTransport() { return this.transport; }
    public ServicesPublic getService() { return this.service; }

    //Methode qui renvoie renvoie la somme des impacts de chaque catégorie
    public double calculerEmpreinte(){
        return(this.alimentation.getImpact() + this.bienConso.getImpact() + this.logement.getImpact() + this.transport.getImpact() + this.service.getImpact());
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
        if (this.logement.getImpact()  < moyenneLogement) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Logement d'un Francais ");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Logement d'un Francais ");
        }
    }
    public void CompareTransport() {
        double moyenneTransport = 2.920;
        if (this.transport.getImpact() < moyenneTransport) {
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

        System.out.println("Impact du logement : "+ this.logement.getImpact() );
        CompareLogement();

        System.out.println("Impact du transport : "+ this.transport.getImpact() );
        CompareTransport();

        System.out.println("Impact du service publique : "+ this.service.getImpact() );
        CompareService();

    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "alimentation=" + alimentation +
                ", bienConso=" + bienConso +
                ", logement=" + logement +
                ", transport=" + transport +
                ", service=" + service +
                '}';
    }
}
