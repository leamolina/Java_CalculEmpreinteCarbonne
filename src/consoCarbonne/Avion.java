package consoCarbonne;

/**
 * La classe Avion permet de connaitre l'impact d'un trajet en avion d'un francais en fonction des kilometres parcourus par an.
 */
public class Avion extends Transport{

    //Constructeur

    public Avion(){
    }

    public Avion(int kilomAnnee) {
        super(kilomAnnee);
        setCalculImpact();
    }

    //Calcul de l'impact selon le site : https://impactco2.fr/transport/avion (on inclus les trainees dans notre calcul)
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


    @Override
    public String toString() {
        return "Avion{" + super.toString() + "}";
    }
}

