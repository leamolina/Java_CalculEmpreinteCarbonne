package consoCarbonne;

/**
 * La classe Bus permet de connaire l'impact d'un trajet en bus d'un francais en fonction des kilometres parcourus par an et du type de bus(electrique ou a moteur.
 * Nous avons considere par défaut que le bus n'etait pas electrique.
 */
public class Bus extends Transport{

    public Bus(){}
    private TypeB type = TypeB.M;

    public Bus(int kilomAnnee, TypeB type) {
        super(kilomAnnee);
        this.type = type;
    }

    //Setters :
    public void setType(TypeB type) {
        this.type = type;
    }

    /**
     * Calcul de l'impact selon le site : https://impactco2.fr/transport/bus
     * Nous avons séparé les deux cas suivant : bus electrique et bus a moteur
     * Nous avons represente ses deux cas a l'aide d'une enumeration
     */
    public void setCalculImpact (){
        super.setImpact(type.getCoef()*getKilomAnnee());
    }

    @Override
    public String toString() {
        return "Bus{" +
                "type=" + type + super.toString() +
                '}';
    }
}
