package consoCarbonne;
import Erreurs.*;

/**
 * La classe Logement permet de representer l'empreinte carbonne moyenne du logement d'un Francais en fonction de sa classe energetique et sa superficie .
 */
public class Logement extends ConsoCarbonne {

    public Logement() throws ErrValNeg {
        super();
    }
    /**
     * Methode permettant de creer un logement.
     * @param superficie correspond a la superficie du logement de l'utilisateur en metres carre
     * @param ce est la classe énergétique du logement
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    //Constructeur
    public Logement (int superficie, CE ce) throws ErrValNeg {
        setSuperficie(superficie);
        setCe(ce);
        setCalculImpact();
    }
    private int superficie = 0;
    private CE ce = CE.C;


    /**
     *Methode permettant de verifier que la superficie du logement est positive et de la fixer.
     * @param s correspond a la superficie du logement de l'utilisateur en metres carre
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
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
     * @param c est la classe energetique du logement
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

    //Getters
    /**
     * @return la superficie du logement en metre carre
     */
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
