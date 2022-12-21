package consoCarbonne;
import Erreurs.*;

/**
 * La classe Bus permet de connaire l'impact d'un trajet en bus d'un francais en fonction des kilometres parcourus par an et du type de bus(electrique ou a moteur.
 * Nous avons considere par défaut que le bus n'etait pas electrique.
 */
public class Bus extends Transport{

    public Bus(){}
    private TypeB type = TypeB.M;

    /**
     * @param km km represente les kilometres parcourus en bus chaque annee
     * @param type type represente le type du bus : electrique ou a moteur
     */
    public Bus(int km, TypeB type) throws ErrValNeg {
        super(km);
        this.type = type;
        setCalculImpact();

    }

    //Setters :
    public void setType(TypeB type) {
        this.type = type;
        setCalculImpact();
    }


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
     * Calcul de l'impact selon le site : https://impactco2.fr/transport/bus
     * Nous avons séparé les deux cas suivant : bus electrique et bus a moteur
     * Nous avons represente ses deux cas a l'aide d'une enumeration
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
