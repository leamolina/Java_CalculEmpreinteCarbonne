package Erreurs;

//Toutes les fois ou les valeurs sont negatives
public class ErrValNeg extends Exception {
    public ErrValNeg() {}
    public ErrValNeg(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}



