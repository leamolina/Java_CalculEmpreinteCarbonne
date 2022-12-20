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
     * @param kilomAnnee
     * @param type
     */
    public Bus(int kilomAnnee, TypeB type) throws ErrValNeg {
        super(kilomAnnee);
        this.type = type;
        setCalculImpact();

    }

    //Setters :
    public void setType(TypeB type) {
        this.type = type;
        setCalculImpact();
    }

    /**
     * Calcul de l'impact selon le site : https://impactco2.fr/transport/bus
     * Nous avons séparé les deux cas suivant : bus electrique et bus a moteur
     * Nous avons represente ses deux cas a l'aide d'une enumeration
     */
    public void setCalculImpact (){
        super.setImpact(type.getCoef()*getKilomAnnee());
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
