package consoCarbonne;

public enum TypeB {
    //E pour Electrique, M pour motteur
    E(0.00002), M(0.0001);

    //Constructeur :
    TypeB(double coef) {
        this.coef = coef;
    }

    private double coef = 0.0;


    //Getter :
    public double getCoef() {
        return coef;
    }

    //Setter
    public void setCoef(double coef) {
        this.coef = coef;
    }



}
