package Erreurs;

public class ErrSommeTx extends Exception{
    public ErrSommeTx() {}
    public ErrSommeTx(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
