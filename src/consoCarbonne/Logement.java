package consoCarbonne;

public class Logement extends ConsoCarbonne {

    //Constructeur
    public Logement (int superficie, CE ce){
        setSuperficie(superficie);
        setCe(ce);
        setCalculImpact();
    }
    private int superficie = 0;
    private CE ce = CE.A;

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
            super.setImpact(this.ce.getCoefCE() * this.superficie);
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
