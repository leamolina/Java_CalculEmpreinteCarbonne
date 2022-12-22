package Erreurs;
/**
 * La classe ErrSommeTx permet de generer une Exception lorsque la somme des valeurs des taux n’est pas égale à 1.
 */
public class ErrSommeTx extends Exception{
    public ErrSommeTx() {}

    /**
     * @param s
     */
    public ErrSommeTx(String s) {
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
