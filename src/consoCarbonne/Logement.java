package consoCarbonne;
import Erreurs.*;
import java.util.Scanner;

/**
 * La classe Logement permet de representer l'empreinte carbonne moyenne du logement d'un francais en fonction de sa classe enrgetique et sa superficie .
 */
public class Logement extends ConsoCarbonne {

    public Logement(){}
    /**
     * Methode permettant de creer un logement.
     * @param superficie
     * @param ce
     */
    //Constructeur
    public Logement (int superficie, CE ce) throws ErrValNeg {
        setSuperficie(superficie);
        setCe(ce);
        setCalculImpact();
    }
    private int superficie = 0;
    private CE ce = CE.A;
    private static Scanner scan = new Scanner(System.in);


    /**
     *Methode permettant de verifier que la superficie du logement est positive et de la fixer.
     * @param s
     */
    //Setters
    public void setSuperficie (int s) throws ErrValNeg {
        if (s >= 0) {
            this.superficie = s;
            setCalculImpact();
        }
        else throw new ErrValNeg("Erreur : Une superficie ne peut pas etre negative.");

    }

    /**
     * @param c
     */
    public void setCe (CE c){
        this.ce = c ;
        setCalculImpact();

    }

    /**
     * Cette methode permet de calculer l'impact de la consocommation carbone dans le Logement
     */
    public void setCalculImpact(){
        if (this.ce == null) super.setImpact(0.0);
        else {
            super.setImpact(this.ce.getCoefCE() * this.superficie);
        }
    }

    /**
     * @return la superficie du logement en metre carre
     */
    //Getters
    public int getSuperficie(){
        return superficie;
    }

    /**
     * @return Le classe energetique du logement associe
     */
    public CE getCe(){
        return ce;
    }

    /**
     * Cette methode detaille l'empreinte carbonne moyenne d un francais dans ce domaine
     */
    public static void EmpreinteLogement(){
        int equipementLogements = 335;
        int constructionEtGrosEntretien = 675 ;
        int energiesEtUtilites = 1696;
        int sum = equipementLogements + constructionEtGrosEntretien + energiesEtUtilites;
        System.out.println("Details de l empreinte carbonne moyenne d un francais (Logement) : ");
        System.out.println("Equipements des Logements : " + equipementLogements);
        System.out.println("Construction et Gros entretiens : " + constructionEtGrosEntretien);
        System.out.println("Energies et Utilites : " + energiesEtUtilites);
        System.out.println("Somme: " + sum + "\n");
    }

    /**
     * @return une chaîne contenant les informations sur la classe Logement en affichant la superficie et la classe energetique associe a un logement
     */
    @Override
    public String toString() {
        return "Logement{" +
                "superficie=" + superficie +
                ", ce=" + ce +
                "  " + super.toString() +
                "}\n";
    }


}
