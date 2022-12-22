package Erreurs;

/**
 * La classe ErrValNeg permet de générer une Exception lorsqu’une valeur negative est trouvee et qu’elle n’est pas souhaitée.
 */
public class ErrValNeg extends Exception {
    public ErrValNeg() {}

    /**
     * @param s
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



