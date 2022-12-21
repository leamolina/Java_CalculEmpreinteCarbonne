package consoCarbonne;
import java.util.*;
//import java.io.*;
import Erreurs.*;

/**
 * La classe Voiture est une classe fille de la classe transport dans laquelle nous nous sommes interessees plus particulerement aux voitures en fonction des criteres suivant:
 * Est ce que l'utilisateur.rice possède une voiture ?
 * La taille de celle-ci.
 * La duree de conservation du vehicule.
 * Le nombre de kilomètres parcourus par an.
 */
public class Voiture extends Transport{

    public Voiture(){}

    /**
     * Cette methode permet de creer l'objet voiture
     * @param taille
     * @param possede
     * @param km
     * @param amortissement
     */
    //Constructeur :
    public Voiture(Taille taille, boolean possede, int km, int amortissement) throws ErrValNeg{
        super(km);
        setTaille(taille);
        setPossede(possede);
        super.setKm(km);
        setAmortissement(amortissement);
        setCalculImpact();
    }
    private static Scanner scan = new Scanner(System.in);

    private boolean possede = false;
    private Taille taille = Taille.P;
    private int amortissement = 0;
/*
    //Methode fabrication qui verifie si une voiture est petite ou grande et renvoie l emission de gaz de la fabrication correspondant
    private double fabrication(Taille taille){
        if (taille==Taille.P) return 4.2;
        else return 19;
    }*/

    /**
     * @return la taille du vehicule de l'utilisateur.rice (P si c'est une petite voiture, G si c'est une grande voiture)
     */
    //Getters
    public Taille getTaille() {
        return this.taille;
    }

    /**
     * @return un booleen indiquant si l'utilisateur.rice possede une voiture
     */
    public boolean isPossede() {
        return possede;
    }

    /**
     * @return le nombre de kilometres parcourus par an
     */
    public int getKilomAnnee() {
        return super.getKm();
    }

    /**
     * @return la duree de conservation du vehicule
     */
    public int getAmortissement() {
        return amortissement;
    }

    /**
     * @param taille
     */
    //Setters
    public void setTaille(Taille taille) {
        this.taille = taille;
        setCalculImpact();


    }

    /**
     * @param possede
     */
    public void setPossede(boolean possede) {
        this.possede = possede;
        setCalculImpact();

    }

    /**
     * Si le nombre de kilometres parcourus par an est negativf nous generons une erreur car cela est impossssible puisque c'est une distance
     * @param km
     */
    public void setKm(int km) throws ErrValNeg {
        if (km < 0) {
            throw new ErrValNeg("Erreur : impossible d'avoir des valeurs négatives pour le nombre de km parcourus en un an. ");
        }
        else {
            super.setKm(km);
            setCalculImpact();
        }
    }

    /**
     * Si la valeur d'amortissement est negatives nous generons une erreur car cela est impossssible puisque c'est une duree
     * @param amortissement
     */
    public void setAmortissement(int amortissement) throws ErrValNeg {
        if (amortissement < 0){
            throw new ErrValNeg("Erreur : impossible d'avoir des valeurs négatives pour la durée de conservation d'un véhicule. ");
        }
        else{
            this.amortissement = amortissement;
            setCalculImpact();
        }
    }

    /**
     * Calcul de l'impact:
     * Si possede est false : l'impact est nul
     * Sinon: impact= kilomAnnee x 1.93 x 0.0001 + fabrication/amortissement
     */
    public void setCalculImpact() {
        if (this.possede){
            super.setImpact(super.getKm()*1.93*(0.0001) +taille.getFabrication()/this.amortissement);
        }
        else super.setImpact(0.0);
    }

    public Taille StringToTaille(){
        boolean fin = false;
        Taille resultat = Taille.P;
        do{
            System.out.println("Entrer 0 si la voiture est petite, 1 sinon ");
            int t = scan.nextInt();
            if (t == 0){
                resultat = Taille.P;
                fin = true;
                break;
            }
            else if (t == 1){
                resultat = Taille.G;
                fin = true;
                break;
            }
            else {
                System.out.println("La taille indiquée n'existe pas ");
            }

        }while(!fin);
        return(resultat);
    }


    /**
     * @return une chaîne contenant les informations sur la classe Voiture.
     */
    @Override
    public String toString() {
        return "Voiture{" +
                "possede=" + possede +
                ", taille=" + taille +
                ", amortissement=" + amortissement  + super.toString() +
                '}';
    }
}
