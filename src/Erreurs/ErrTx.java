package Erreurs;

/**
 * La classe ErrTx permet de generer une Exception lorsqu’une valeur d’un taux n’est pas comprise entre 0 et 1.
 */
public class ErrTx extends Exception {

    public ErrTx() {}

    /**
     * @param s
     */
    public ErrTx(String s) {
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









