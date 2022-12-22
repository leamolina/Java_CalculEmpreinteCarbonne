/**
 * Ce package regroupe les différentes classes permettant de generer les differentes exceptions de notre programme.
 */

package Erreurs;
/**
 * La classe ErrSommeTx permet de generer une Exception lorsque la somme des valeurs des taux n’est pas égale à 1.
 */
public class ErrSommeTx extends Exception{
    public ErrSommeTx() {}

    /**
     * @param s s est le message que l on souhaite afficher en cas d'apparition d une exception de type ErrSommeTx
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
