package consoCarbonne;

/**
 * La classe Avion permet de connaitre l'impact d'un trajet en avion d'un francais en fonction des kilometres parcourus par an.
 */
public class Avion extends Transport{

    //Constructeurs
    public Avion(){
    }

    /**
     * @param kilomAnnee
     */
    public Avion(int kilomAnnee) {
        super(kilomAnnee);
        setCalculImpact();
    }

    /**
     * Calcul de l'impact selon le site : https://impactco2.fr/transport/avion
     * NB: Nous avons inclus les trainees dans le calcul des differents impacts
     */
    public void setCalculImpact (){
       if (super.getKilomAnnee() < 1000){
           super.setImpact(0.00023*getKilomAnnee());
       }
       else if (super.getKilomAnnee() >= 1000 && super.getKilomAnnee() <= 3500) {
           super.setImpact(0.0001784*getKilomAnnee());
       }
       else {
           super.setImpact(0.00015166*getKilomAnnee());
       }

    }


    /**
     * @return Une chaîne contenant les informations sur la classe Avion.
     */
    @Override
    public String toString() {
        return "Avion{" + super.toString() + "}";
    }
}

