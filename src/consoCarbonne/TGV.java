package consoCarbonne;

/**
 * La classe TGV permet de connaitre l'impact d'un trajet en TGV d'un francais en fonction des kilometres parcourus par an.
 */
public class TGV extends Transport{

    //Constructeur
    public TGV(int kilomAnnee) {
        super(kilomAnnee);
    }

    //Calcul de l'impact selon le site : https://impactco2.fr/transport/tgv
    public void setCalculImpact (){
        super.setImpact(0.000002*getKilomAnnee());
    }

    @Override
    public String toString() {
        return "TGV{" + super.toString() + "}";
    }
}
