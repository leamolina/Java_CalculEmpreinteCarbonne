package consoCarbonne;
import Erreurs.*;

/**
 * La classe Avion permet de connaitre l'impact d'un trajet en avion d'un Francais en fonction des kilometres parcourus par trajet.
 */
public class Avion extends Transport{


    //Constructeurs (par défaut)
    public Avion() throws ErrValNeg {
        super();
    }

    /**
     * @param km represente les kilometres parcourus par trajet
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    public Avion(int km) throws ErrValNeg {
        super(km);
        setCalculImpact();
    }


    /**
     * Methode permettant de verifier que le nombre de kilomètres parcourus par trajet est bien positif et de le fixer.
     * @param km represente les kilomètres parcourus
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    //Setters
    @Override
    public void setKm(int km) throws ErrValNeg {
        if (km < 0) {
            throw new ErrValNeg("Erreur : impossible d'avoir des valeurs négatives pour le nombre de km parcourus par trajet. Fin du programme. ");
        }
        else {
            super.setKm(km);
            setCalculImpact();
        }
    }

    /**
     * Calcul de l'impact selon le site : https://impactco2.fr/transport/avion
     * NB: Nous avons inclus les trainees dans le calcul des differents impacts
     */
    public void setCalculImpact (){
       if (super.getKm() < 1000){
           super.setImpact(0.00023*getKm());
       }
       else if (super.getKm() >= 1000 && super.getKm() <= 3500) {
           super.setImpact(0.0001784*getKm());
       }
       else {
           super.setImpact(0.00015166*getKm());
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

