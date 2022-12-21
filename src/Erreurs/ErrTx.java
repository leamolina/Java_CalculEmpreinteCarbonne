package Erreurs;

//Exceptions qui permettent de s'assurer que la somme des taux est bien égale à 1
public class ErrTx extends Exception {

    public ErrTx() {}
    public ErrTx(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}









