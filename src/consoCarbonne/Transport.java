package consoCarbonne;

public class Transport extends ConsoCarbonne{

    //Constructeur :
    public Transport(int kilomAnnee){
        setKilomAnnee(kilomAnnee);
    }

    private int kilomAnnee;

    //Setter :
    public void setKilomAnnee(int kilomAnnee) {
        if (kilomAnnee < 0) {
            System.out.println("Erreur : impossible d'avoir des valeurs négatives pour le nombre de km parcourus en un an. ");
        }
        else {
            this.kilomAnnee = kilomAnnee;
        }
    }

    //Getter :
    public int getKilomAnnee() {
        return kilomAnnee;
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
                "kilomAnnee=" + kilomAnnee + super.toString() +
                '}';
    }
}

