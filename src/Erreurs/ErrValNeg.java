package Erreurs;

/**
 * La classe ErrValNeg permet de générer une Exception lorsqu’une valeur negative est trouvee et qu’elle n’est pas souhaitée.
 */
public class ErrValNeg extends Exception {
    public ErrValNeg() {}

    /**
     * @param s s est le message que l on souhaite afficher en cas d'apparition d une exception de type ErrValNeg
     */
    public ErrValNeg(String s) {
        super(s);
    }

    /**
     * @return le message d'erreur.
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}



