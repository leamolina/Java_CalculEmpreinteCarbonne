package consoCarbonne;
import Erreurs.*;
/**
 * La classe TGV permet de connaitre l'impact d'un trajet en TGV d'un francais en fonction des kilometres parcourus par an.
 */
public class TGV extends Transport{

    public TGV(){

    }
    /**
     * @param km
     */
    //Constructeur
    public TGV(int km) throws ErrValNeg {
        super(km);
        setCalculImpact();
    }

    /**
     * Methode permettant de verifier que le nombre de kilomètres parcourus est bien positif et de le fixer.
     * @param km represente les kilomètres parcourus
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
     * Calcul de l'impact selon le site : https://impactco2.fr/transport/tgv
     */
    public void setCalculImpact (){
        super.setImpact(0.000002*getKm());
    }

    /**
     * @return une chaîne contenant les informations relatives a  la classe TGV.
     */
    @Override
    public String toString() {
        return "TGV{" + super.toString() + "}";
    }
}
