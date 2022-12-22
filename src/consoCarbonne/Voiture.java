package consoCarbonne;
import Erreurs.*;

/**
 * La classe Voiture est une classe fille de la classe transport dans laquelle nous nous sommes interessees plus particulerement aux voitures en fonction des criteres suivant:
 * Est ce que l'utilisateur possède une voiture ?
 * La taille de celle-ci.
 * La duree de conservation du vehicule.
 * Le nombre de kilomètres parcourus par an.
 */
public class Voiture extends Transport{

    public Voiture() throws ErrValNeg {
        super();
    }

    /**
     * Cette methode permet de creer l'objet voiture.
     * @param taille represente la taille de la voiture
     * @param possede indique si l'utilisateur possède une voiture
     * @param km represente le nombre de kilomètres parcourus par an
     * @param amortissement represente la duree de conservation du vehicule
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
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

    private boolean possede = false;
    private Taille taille = Taille.P;
    private int amortissement = 0;

    //Getters
    /**
     * @return la taille du vehicule de l'utilisateur (P si c'est une petite voiture, G si c'est une grande voiture).
     */
    public Taille getTaille() {
        return this.taille;
    }

    /**
     * @return un booleen indiquant si l'utilisateur possede une voiture.
     */
    public boolean isPossede() {
        return possede;
    }

    /**
     * @return le nombre de kilometres parcourus par an.
     */
    public int getKilomAnnee() {
        return super.getKm();
    }

    /**
     * @return la duree de conservation du vehicule.
     */
    public int getAmortissement() {
        return amortissement;
    }

    //Setters
    /**
     * Methode permettant de fixer la taille de la voiture.
     * @param taille represente la taille de la voiture
     */
    public void setTaille(Taille taille) {
        this.taille = taille;
        setCalculImpact();
    }

    /**
     * @param possede indique si l'utilisateur possede une voiture
     */
    public void setPossede(boolean possede) {
        this.possede = possede;
        setCalculImpact();

    }

    /**
     * Si le nombre de kilometres parcourus par an est negatif nous generons une exception car cela est impossssible (c'est une distance)
     * @param km represente le nombre de kilometres parcourus par an
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    @Override
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
     * Si la valeur d'amortissement est negative nous generons une erreur car cela est impossssible (c'est une duree)
     * @param amortissement represente la duree de conservation du vehicule
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
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
