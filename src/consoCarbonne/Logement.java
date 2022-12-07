package consoCarbonne;

public class Logement extends ConsoCarbonne {

    //Constructeur
    public Logement (int superficie, CE ce){
        setSuperficie(superficie);
        setCe(ce);
        setCalculImpact();
    }
    private int superficie;
    private CE ce;
/*
    //Methode qui renvoie le coefficient multiplicatif
    private double coefCE (CE ce){
        double coef;
        switch (ce){
            case A :
                coef = 0.005;
                break;
            case B:
                coef = 0.01;
                break;
            case C :
                coef = 0.02;
                break;
            case D :
                coef = 0.035;
                break;
            case E:
                coef = 0.055;
                break;
            case F :
                coef = 0.08;
                break;
            case G:
                coef = 0.1;
                break;
            default :
                coef = 0.0;
        }
        return coef;

    }

 */
    //Setters
    public void setSuperficie (int s) {
        if (s >= 0) {
            this.superficie = s;
            setCalculImpact();
        }
        else System.out.println("Erreur : Une superficie ne peut pas etre negative.");

    }
    public void setCe (CE c){
        this.ce = c ;
        setCalculImpact();

    }
    public void setCalculImpact(){
        if (this.ce == null) super.setImpact(0.0);
        else {
            super.setImpact(CE.coefCE(this.ce) * this.superficie);
        }
    }

    //Getters
    public int getSuperficie(){
        return superficie;
    }

    public CE getCe(){
        return ce;
    }

    //Methode detaillant l empreinte carbonne moyenne d un francais dans ce domaine
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

    @Override
    public String toString() {
        return "Logement{" +
                "superficie=" + superficie +
                ", ce=" + ce +
                "  " + super.toString() +
                "}\n";
    }


}
