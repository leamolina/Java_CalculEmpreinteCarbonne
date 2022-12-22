package consoCarbonne;
import Erreurs.*;

/**
 * La classe Transport represente l'empreinte carbonne moyenne d'un francais au niveau des transports.
 * Elle est la classe mere des classes Avion, Bus,TGV et Voiture.
 */
public class Transport extends ConsoCarbonne{

    //Constructeur (par défaut)
    public Transport() throws ErrValNeg {
        super();
    }

    /**
     * @param km represente les kilomètres parcourus
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    public Transport(int km) throws ErrValNeg {
        setKm(km);
    }

    private int km = 0;

    //Setter :


    /**
     * Methode permettant de verifier que le nombre de kilometres est bien positif et de le fixer.
     * @param km km represente les kilomètres parcourus
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    public void setKm(int km) throws ErrValNeg {
        if (km < 0) {
            throw new ErrValNeg ("Erreur : impossible d'avoir des valeurs négatives pour le nombre de km parcourus. ");
        }
        else {
            this.km = km;

        }
    }


    //Getter :
    /**
     * @return le nombre de kilometres parcourus
     */
    public int getKm() {
        return km;
    }

    /**
     * Cette fonction renvoie le detail de l'empreinte carbonne moyenne d'un francais dans la classe Transport
     */
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

    /**
     * @return une chaîne contenant les informations de la classe Transport en affichant le nombre de kilometres parcourus ainsi que les informations relatives de la classe consocarbone.
     */
    @Override
    public String toString() {
        return "Transport{" +
                "km=" + km + super.toString() +
                '}';
    }

}

