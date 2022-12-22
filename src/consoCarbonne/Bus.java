package consoCarbonne;
import Erreurs.*;

/**
 * La classe Bus permet de connaire l'impact d'un trajet en bus d'un francais en fonction des kilometres parcourus et du type de bus (electrique ou a moteur).
 * Nous avons considere par defaut que le bus n'etait pas electrique.
 */
public class Bus extends Transport{

    public Bus(){}
    private TypeB type = TypeB.M;

    /**
     * @param km  represente les kilometres parcourus en bus chaque annee
     * @param type  represente le type du bus : electrique ou a moteur
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    public Bus(int km, TypeB type) throws ErrValNeg {
        super(km);
        this.type = type;
        setCalculImpact();

    }

    /**
     * Methode permettant de fixer le type de bus utilise.
     * @param type represente le type du bus : electrique ou a moteur
     */
    //Setters :
    public void setType(TypeB type) {
        this.type = type;
        setCalculImpact();
    }

    /**
     * Methode permettant de verifier que le nombre de kilometres parcourus chaque annee est bien positif et de le fixer.
     * @param km represente les kilomètres parcourus chaque annee
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    @Override
    public void setKm(int km) throws ErrValNeg {
        if (km < 0) {
            throw new ErrValNeg("Erreur : impossible d'avoir des valeurs négatives pour le nombre de km parcourus en un an. ");
        }
        else {
            super.setKm(km);
            if(this.type != null) setCalculImpact();
        }
    }

    /**
     * Calcul de l'impact selon le site : https://impactco2.fr/transport/bus
     * Nous avons separe les deux cas suivant : bus electrique et bus a moteur.
     * Nous avons represente ces deux cas a l'aide d'une enumeration.
     */
    public void setCalculImpact (){
        super.setImpact(type.getCoef()*getKm());
    }



    /**
     * @return Une chaîne contenant les informations sur la classe Bus et affiche son type ainsi,  que tout les informations relatives sur ce moyen de transport,
     */
    @Override
    public String toString() {
        return "Bus{" +
                "type=" + type + super.toString() +
                '}';
    }
}
