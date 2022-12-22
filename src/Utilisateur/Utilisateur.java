/*
  Ce package regroupe les differentes classes permettant de calculer l'empreinte carbonne d'un utilisateur selon les differents postes de consommation decrits dans le package consoCarbonne
 */
package Utilisateur;

import Erreurs.ErrSommeTx;
import Erreurs.ErrTx;
import Erreurs.ErrValNeg;
import consoCarbonne.*;

import java.util.*;

public class Utilisateur {

    public Utilisateur() throws ErrValNeg {}

    /**
     * @param alimentation correspond au poste de consommation Alimentation de l'utilisateur
     * @param bienConso correspond au poste de consommation BienConso de l'utilisateur
     * @param collection_logement correspond au poste de consommation Logement de l'utilisateur
     * @param collection_voiture correspond au poste de consommation Voiture de l'utilisateur
     * @param collection_avion correspond au poste de consommation Avion de l'utilisateur
     * @param bus correspond au poste de consommation Bus de l'utilisateur
     * @param collection_tgv correspond au poste de consommation TGV de l'utilisateur
     * @param service correspond au poste de consommation service de l'utilisateur
     */

    //Constructeur :
    public Utilisateur(Alimentation alimentation, BienConso bienConso, Collection<Logement> collection_logement, Collection<Voiture> collection_voiture,Collection<Avion> collection_avion, Bus bus, Collection<TGV> collection_tgv, ServicesPublic service) throws ErrTx, ErrValNeg {
        setAlimentation(alimentation);
        setBienConso(bienConso);
        setCollection_logement(collection_logement);
        setCollection_voiture(collection_voiture);
        setCollection_avion(collection_avion);
        setBus(bus);
        setCollection_tgv(collection_tgv);
        setService(service);
    }

    /**
     * Deuxieme constructeur qui permet cette fois de créer un Utilisateur à l'aide de la classe Entree Sortie.
     * @param nom_fichier correspond au nom du fichier
     */
    public Utilisateur(String nom_fichier) throws ErrSommeTx, ErrTx, ErrValNeg {
        EntreeSortie e = new EntreeSortie();
        Utilisateur u = e.initialisation_fichier(nom_fichier);
        setAlimentation(u.alimentation);
        setBienConso(u.bienConso);
        setCollection_logement(u.collection_logement);
        setCollection_voiture(u.collection_voiture);
        setCollection_avion(u.collection_avion);
        setBus(u.bus);
        setCollection_tgv(u.collection_tgv);
        setService(u.service);

    }

    /**
     * Troisieme constructeur qui permet cette fois de créer un Utilisateur à partir d'interactions.
     * Le int entré en argument ne sera jamais utilisé, il permet juste de distinguer les trois constructeurs diférents.
     * Le premier est par défaut
     * Le deuxieme utilise un fichier
     * Le dernier (celui-ci) utilise les entrées/sorties
     * @param ignoredB  int qui n'est jamais utilise et qui permet de differencier les constructeurs
     * @throws ErrTx Exception en cas de taux non compris entre 0 et 1.
     * @throws ErrValNeg ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    public Utilisateur(int ignoredB) throws ErrTx, ErrValNeg, ErrSommeTx {
        EntreeSortie e = new EntreeSortie();
        Utilisateur u = e.initialisation_manuelle();
        setAlimentation(u.alimentation);
        setBienConso(u.bienConso);
        setCollection_logement(u.collection_logement);
        setCollection_voiture(u.collection_voiture);
        setCollection_avion(u.collection_avion);
        setBus(u.bus);
        setCollection_tgv(u.collection_tgv);
        setService(u.service);
    }


    //Attributs de la classe (avec des valeurs par défaut)
    private Alimentation alimentation = new Alimentation();
    private BienConso bienConso = new BienConso();
    private Collection<Logement> collection_logement = new ArrayList<>();
    private Collection<Voiture> collection_voiture = new ArrayList<>();
    private Collection<Avion> collection_avion = new ArrayList<>();
    private Bus bus = new Bus();
    private Collection<TGV> collection_tgv = new ArrayList<>();
    private ServicesPublic service = ServicesPublic.getInstance();


    //Setters :

    /**
     * Cette methode permet de fixer l'attribut alimentation.
     * @param alimentation correspond au poste de consommation Alimentation de l'utilisateur
     */
    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }

    /**
     * Cette methode permet de fixer l'attribut bienConso.
     * @param bienConso  correspond au poste de consommation BienConso de l'utilisateur
     */
    public void setBienConso(BienConso bienConso) {
        this.bienConso = bienConso;
    }

    /**
     * Cette methode permet de fixer l'attribut collection_logement.
     * @param collection_logement correspond au poste de consommation Logement de l'utilisateur
     */
    public void setCollection_logement(Collection<Logement> collection_logement) {
        this.collection_logement = collection_logement;
    }

    /**
     * Cette methode permet de fixer l'attribut collection_voiture.
     * @param collection_voiture correspond au poste de consommation Voiture de l'utilisateur
     */
    public void setCollection_voiture(Collection<Voiture> collection_voiture) {
        this.collection_voiture = collection_voiture;
    }

    /**
     * Cette methode permet de fixer l'attribut collection_avion.
     * @param collection_avion correspond au poste de consommation Avion de l'utilisateur
     */
    public void setCollection_avion(Collection<Avion> collection_avion) {
        this.collection_avion = collection_avion;

    }

    /**
     * Cette methode permet de fixer l'attribut bus.
     * @param bus correspond au poste de consommation Bus de l'utilisateur
     */
    public void setBus(Bus bus) {
        this.bus = bus;
    }

    /**
     * Cette methode permet de fixer l'attribut collection_tgv.
     * @param collection_tgv correspond au poste de consommation TGV de l'utilisateur
     */
    public void setCollection_tgv(Collection<TGV> collection_tgv) {
        this.collection_tgv = collection_tgv;
    }

    /**
     * Cette methode permet de fixer l'attribut service.
     * @param service correspond au poste de consommation service de l'utilisateur
     */
    public void setService(ServicesPublic service) {
        this.service = service;
    }

    //Getters :

    /**
     * @return Le poste de consommation carbone de l'utilisateur concernant son alimentation.
     */
    public Alimentation getAlimentation() { return this.alimentation; }

    /**
     * @return Le poste de consommation carbone de l'utilisateur concernant ses depenses en biens de consommation.
     */
    public BienConso getBienConso() {return this.bienConso; }

    /**
     * @return Le poste de consommation carbone de l'utilisateur concernant son logement.
     */
    public Collection<Logement> getCollection_logement() { return this.collection_logement; }

    /**
     * @return Le poste de consommation carbone de l'utilisateur concernant ses deplacements en voiture.
     */
    public Collection<Voiture> getCollection_voiture() { return this.collection_voiture; }

    /**
     * @return Le poste de consommation carbone de l'utilisateur concernant ses trajets en avion.
     */
    public Collection<Avion> getCollection_avion() { return this.collection_avion; }

    /**
     * @return Le poste de consommation carbone de l'utilisateur concernant ses deplacements en bus.
     */
    public Bus getBus() { return this.bus; }

    /**
     * @return Le poste de consommation carbone de l'utilisateur concernant ses trajets en TGV.
     */
    public Collection<TGV> getCollection_tgv() { return this.collection_tgv; }

    /**
     * @return Le poste de consommation carbone de l'utilisateur concernant son utilisation des services publics.
     */
    public ServicesPublic getService() { return this.service; }



    /**
     * Methode qui calcule la somme de tous les impacts des differentes logements  de la liste de logements.
     * @param collection_logement correspond au poste de consommation Logement de l'utilisateur
     * @return La somme de tous les impacts des differentes logements  de la liste de logements.
     */

    public double calculImpactLogement (Collection<Logement> collection_logement){
        if( collection_logement == null) return 0.0;
        else {
            double somme = 0.0;
            for (Logement l : collection_logement) {
                somme += l.getImpact();
            }
            return (somme);
        }
    }

    /**
     * Methode qui calcule la somme de tous les impacts des differentes voitures  de la liste de voitures.
     * @param collection_voiture correspond au poste de consommation Voiture de l'utilisateur
     * @return La somme de tous les impacts des differentes voitures  de la liste de voitures.
     */
    public double calculImpactVoiture (Collection<Voiture> collection_voiture){
        if (collection_voiture == null) return 0.0;
        else {
            double somme = 0.0;
            for (Voiture v : collection_voiture) {
                somme += v.getImpact();
            }
            return (somme);
        }
    }

    /**
     * Methode qui calcule la somme de tous les impacts des differentes avions  de la liste d'avions.
     * @param collection_avion correspond au poste de consommation Avion de l'utilisateur
     * @return La somme de tous les impacts des differentes avions  de la liste d'avions.
     */
    public double calculImpactAvion (Collection<Avion> collection_avion){
        if(collection_avion == null) return 0.0;
        else {
            double somme = 0.0;
            for (Avion a : collection_avion) {
                somme += a.getImpact();
            }
            return (somme);
        }
    }

    /**
     * Methode qui calcule la somme de tous les impacts des differentes TGV de la liste de TGV.
     * @param collection_tgv correspond au poste de consommation TGV de l'utilisateur
     * @return la somme de tous les impacts des differentes TGV de la liste de TGV.
     */
    //Pour une liste de TGV :
    public double calculImpactTgv (Collection<TGV> collection_tgv){
        if(collection_tgv == null) return 0.0;
        else {
            double somme = 0.0;
            for (TGV t : collection_tgv) {
                somme += t.getImpact();
            }
            return (somme);
        }
    }


    /**
     * Cette methode renvoie renvoie la somme des impacts de chaque catégorie.
     * @return L'empreinte carbonne calculee de l'utilsateur.rice.
     */
    
    public double calculerEmpreinte(){
        return(this.alimentation.getImpact() + this.bienConso.getImpact() + calculImpactLogement(this.collection_logement) + calculImpactVoiture(this.collection_voiture) + this.bus.getImpact() + calculImpactTgv(this.collection_tgv) + this.service.getImpact() + calculImpactAvion(this.collection_avion));

    }

    /**
     * Methode qui compare l'empreinte carbonne moyenne de l'alimentation d'un utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareAlimentation() {
        double moyenneAlimentation = 2.353;
        if (this.alimentation.getImpact() < moyenneAlimentation) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'alimentation d'un Francais ; pas de recommandation à faire.\n");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'alimentation d'un Francais. ");
            System.out.println("Recommandation : privilégier les fruits, légumes et les aliments d'origine végétale par rapport à la viande. \n");

        }
    }


    /**
     * Methode qui compare l'empreinte carbonne moyenne des depenses de l'utilisateur-rice.seur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareBienConso() {
        double moyenneBienConso = 2.625;
        if (this.bienConso.getImpact() < moyenneBienConso) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Bien conso d'un Francais ; pas de recommandation à faire.\n");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Bien conso d'un Francais. ");
            System.out.println("Recommandations : Éviter les achats impulsifs. Emprunter et louer. \n");

        }
    }

    /**
     * Methode qui compare l'empreinte carbonne moyenne du logement de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareLogement() {
        double moyenneLogement = 2.706;
        if (calculImpactLogement(this.collection_logement)  < moyenneLogement) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Logement d'un Francais ; pas de recommandation à faire.\n");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Logement d'un Francais. ");
            System.out.println("Recommandations : Privilegier un logement de bonne classe energetique. \n");

        }
    }

    /**
     * Methode qui compare l'empreinte carbonne moyenne de la voiture de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareVoiture() {
        double moyenneVoiture = 1.972;
        if (calculImpactVoiture(this.collection_voiture) < moyenneVoiture) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'une voiture d'un Francais ; pas de recommandation à faire.\n");


        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'une voiture d'un Francais. ");
            System.out.println("Recommandations : Eviter les trajets en voiture. Privilegier les transports en communs, ou le co-voiturage. \n");
        }
    }

    /**
     * Methode qui compare l'empreinte carbonne moyenne d'un trajet en avion de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareAvion() {
        double moyenneAvion = 0.48;
        if (calculImpactAvion(this.collection_avion) < moyenneAvion) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Francais en ce qui concerne les trajets en Avion ; pas de recommandation à faire.\n");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Francais en ce qui concerne les trajets en Avion.");
            System.out.println("Recommandations : Eviter les trajets courts en Avion. Privilégier le TGV. \n ");
        }
    }

    /**
     * Methode qui compare l'empreinte carbonne moyenne d'un trajet en bus de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareBus() {
        double moyenneBus = 0.083;
        if (this.bus.getImpact() < moyenneBus) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Francais en ce qui concerne les trajets en Bus ; pas de recommandation à faire. \n");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Francais en ce qui concerne les trajets en Bus. ");
            System.out.println("Recommandations : Eviter les trajets courts en Bus. Privilegier la marche à pieds si possible, ou les Bus éléctriques.\n ");
        }
    }

    /**
     * Methode qui compare l'empreinte carbonne moyenne d'un trajet en TGV de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareTgv() {
        double moyenneTgv = 0.001666;
        if (calculImpactTgv(this.collection_tgv) < moyenneTgv) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Francais en ce qui concerne les trajets en TGV ; pas de recommandation à faire. \n");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Francais en ce qui concerne les trajets en TGV. ");
            System.out.println("Recommandations : Eviter  les trajets inutiles. \n");

        }
    }


    /**
     * Methode qui compare l'empreinte carbonne moyenne induit par les services publics de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareService() {
        double moyenneService = 1.489;
        if (this.service.getImpact() < moyenneService) {
            System.out.println("L'impact des services est plus petit que la moyenne d'un Service d'un Francais; pas de recommandation à faire. \n");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Service d'un Francais. \n ");
        }
    }

    /**
     * Cette methode qui affiche sur la console une description detaillee de l'empreinte carbonne de l'utilisateur.
     * Nous avons compare l'empreinte de l'utilisateur avec l'empreinte moyenne d'un français.
     */
    public void detaillerEmpreinte(){
        System.out.println("Impact de l'alimentation : "+ this.alimentation.getImpact() + " tonne(s) de CO2 émise(s) par an." );
        System.out.println("Impact de bienConso : "+ this.bienConso.getImpact() + " tonne(s) de CO2 émise(s) par an.");
        System.out.println("Impact du logement : "+ calculImpactLogement(this.collection_logement) + " tonne(s) de CO2 émise(s) par an.");
        System.out.println("Impact de la voiture : "+ calculImpactVoiture(this.collection_voiture)+ " tonne(s) de CO2 émise(s) par an.");
        System.out.println("Impact de l'avion : "+ calculImpactAvion(this.collection_avion)+ " tonne(s) de CO2 émise(s) par an.");
        System.out.println("Impact du bus : "+ this.bus.getImpact()+ " tonne(s) de CO2 émise(s) par an.");
        System.out.println("Impact du tgv : "+ calculImpactTgv(this.collection_tgv)+ " tonne(s) de CO2 émise(s) par an.");
        System.out.println("Impact du service publique : "+ this.service.getImpact() + " tonne(s) de CO2 émise(s) par an.");

    }


    /**
     * Cette methode determine, en fonction d'un double, le poste de consommation concerne.
     * Si l'impact de celui-ci est plus eleve que la moyenne d'un francais, nous affichons une recommandation pour permettre a l utilisateur d adopter un mode de vie plus durable.
     * Nous avons dcide de ne pas donner de recommandation concernant les services publiques, etant donne que la valeur est unique. Aucun parametre ne pourra modifier cet impact.
     * En d'autres termes, l'utilisateur ne peut rien faire pour diminuer l'impact de cette categorie.
     * @param i un double qui represente l impact d un poste de consommation carbonne (a detemriner grace a la methode)
     */
    public void recommandationImpact(double i) {
        //Alimentation :
        if (i == this.alimentation.getImpact()) {
            System.out.println("L'impact de l'alimentation est de : " + i + " tonne(s) de CO2 émise(s) par an."  );
            CompareAlimentation();

        //BienConso :
        } else if (i == this.bienConso.getImpact()) {
            System.out.println("L'impact des biens conso est de : " + i + " tonne(s) de CO2 émise(s) par an." );
            CompareBienConso();

        //Logement :
        } else if (i == calculImpactLogement(this.collection_logement)) {
            System.out.println("L'impact du logement est de : " + i + " tonne(s) de CO2 émise(s) par an." );
            CompareLogement();

        //Voiture
        } else if (i == calculImpactVoiture(this.collection_voiture)) {
            System.out.println("L'impact de la voiture est de : " + i + " tonne(s) de CO2 émise(s) par an." );
            CompareVoiture();

        //Avion  :
        } else if(i == calculImpactAvion(this.collection_avion)){
            System.out.println("L'impact de l'avion est de : " + i + " tonne(s) de CO2 émise(s) par an." );
            CompareAvion();

        //Bus :
        } else if (i == this.bus.getImpact()){
            System.out.println("L'impact du bus est de : " + i + " tonne(s) de CO2 émise(s) par an." );
            CompareBus();

        //TGV :
        } else if (i == calculImpactTgv(this.collection_tgv)){
            System.out.println("L'impact du TGV est de : " + i + " tonne(s) de CO2 émise(s) par an." );
            CompareTgv();

        //Services Publiques
        } else if (i == this.service.getImpact()) {
            System.out.println("L'impact des services publiques est de : " + i + " tonne(s) de CO2 émise(s) par an." );
            CompareService();
        }
    }

    /**
     * Methode qui ordonne les consommations carbonne de l'utilisateur dans une liste, et appelle la fonction recommandationImpact pour faire des recommendations a l'utilisateur.
     */
    public void recommandation() {
        double[] impacts = {this.alimentation.getImpact(), this.bienConso.getImpact(), calculImpactLogement(this.collection_logement), calculImpactVoiture(this.collection_voiture), calculImpactAvion(this.collection_avion), this.bus.getImpact(), calculImpactTgv(this.collection_tgv), this.service.getImpact()};
        for (int i = 0; i < 8; i++) {
            recommandationImpact(impacts[i]);
        }
    }

    /**
     * @return une chaine contenant les informations relatives a la classe Utilisateur.
     */
    @Override
    public String toString() {
        return "Utilisateur{" +
                "alimentation=" + alimentation +
                ", bienConso=" + bienConso +
                ", collection_logement=" + collection_logement +
                ", collection_voiture=" + collection_voiture +
                ", collection_avion=" + collection_avion +
                ", bus=" + bus +
                ", collection_tgv=" + collection_tgv +
                ", service=" + service +
                '}';
    }
}

