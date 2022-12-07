package consoCarbonne;

public class Transport extends ConsoCarbonne{

    //Constructeur :
    public Transport(Taille taille, boolean possede, int kilomAnnee, int amortissement){
        setTaille(taille);
        setPossede(possede);
        setKilomAnnee(kilomAnnee);
        setAmortissement(amortissement);
        setCalculImpact();
    }
    private boolean possede;
    private Taille taille;
    private int kilomAnnee;
    private int amortissement;

    //Methode fabrication qui verifie si une voiture est petite ou grande et renvoie l emission de gaz de la fabrication correspondant
    private double fabrication(Taille taille){
        if (taille==Taille.P) return 4.2;
        else return 19;
    }

    //Getters
    public Taille getTaille() {
        return taille;
    }
    public boolean isPossede() {
        return possede;
    }
    public int getKilomAnnee() {
        return kilomAnnee;
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
            this.kilomAnnee = kilomAnnee;
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
           super.setImpact(this.kilomAnnee*1.93*(0.0001) +fabrication(this.taille)/this.amortissement);
        }
        else super.setImpact(0.0);
    }


    public static void EmpreinteTransport(){
        int trainBus = 85;
        int fretMessagerie = 383 ;
        int avion = 480;
        int voiture = 1972;
        int sum = trainBus + fretMessagerie + avion + voiture;
        System.out.println("Details de l empreinte carbonne moyenne d un francais (Transport) : ");
        System.out.println("Train et bus : " + trainBus);
        System.out.println("Fret et messagerie : " + fretMessagerie);
        System.out.println("Avion : " + avion);
        System.out.println("Voiture : " + voiture);
        System.out.println("Somme: " + sum + "\n");

    }

    @Override
    public String toString() {
        return "Transport{" +
                "possede=" + possede +
                ", taille=" + taille +
                ", kilomAnnee=" + kilomAnnee +
                ", amortissement=" + amortissement +
                "  " + super.toString() +
                "}\n";
    }
}

