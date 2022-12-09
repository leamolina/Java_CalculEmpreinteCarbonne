package consoCarbonne;

public class Voiture extends Transport{

    //Constructeur :
    public Voiture(Taille taille, boolean possede, int kilomAnnee, int amortissement){
        super(kilomAnnee);
        setTaille(taille);
        setPossede(possede);
        super.setKilomAnnee(kilomAnnee);
        setAmortissement(amortissement);
        setCalculImpact();
    }
    private boolean possede = false;
    private Taille taille = Taille.P;
    private int amortissement = 0;
/*
    //Methode fabrication qui verifie si une voiture est petite ou grande et renvoie l emission de gaz de la fabrication correspondant
    private double fabrication(Taille taille){
        if (taille==Taille.P) return 4.2;
        else return 19;
    }*/

    //Getters
    public Taille getTaille() {
        return this.taille;
    }
    public boolean isPossede() {
        return possede;
    }
    public int getKilomAnnee() {
        return super.getKilomAnnee();
    }
    public int getAmortissement() {
        return amortissement;
    }

    //Setters
    public void setTaille(Taille taille) {
        this.taille = taille;
        setCalculImpact();


    }
    public void setPossede(boolean possede) {
        this.possede = possede;
        setCalculImpact();

    }
    public void setKilomAnnee(int kilomAnnee) {
        if (kilomAnnee < 0) {
            System.out.println("Erreur : impossible d'avoir des valeurs négatives pour le nombre de km parcourus en un an. ");
        }
        else {
            super.setKilomAnnee(kilomAnnee);
        }
    }
    public void setAmortissement(int amortissement) {
        if (amortissement < 0){
            System.out.println("Erreur : impossible d'avoir des valeurs négatives pour la durée de conservation d'un véhicule. ");
        }
        else{
            this.amortissement = amortissement;
        }
    }
    public void setCalculImpact() {
        if (this.possede){
            super.setImpact(super.getKilomAnnee()*1.93*(0.0001) +taille.getFabrication()/this.amortissement);
        }
        else super.setImpact(0.0);
    }


    @Override
    public String toString() {
        return "Voiture{" +
                "possede=" + possede +
                ", taille=" + taille +
                ", amortissement=" + amortissement  + super.toString() +
                '}';
    }
}
