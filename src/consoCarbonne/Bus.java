package consoCarbonne;

public class Bus extends Transport{

    //On considere par défaut que le bus n'est pas electrique (bus à moteur)
    private TypeB type = TypeB.M;

    public Bus(int kilomAnnee, TypeB type) {
        super(kilomAnnee);
        this.type = type;
    }

    //Calcul de l'impact selon le site : https://impactco2.fr/transport/bus
    //On a séparé les deux cas : bus electrique et bus à moteur --> on a créé une enum pour ca
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
