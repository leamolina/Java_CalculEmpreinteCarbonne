package consoCarbonne;

public enum CE {
    A(0.005), B(0.01), C(0.02), D(0.035), E( 0.055), F( 0.08), G(0.1);


    //Constructeur :
    CE(double coefCE) {
        this.coefCE = coefCE;
    }

    private double coefCE = 0.0;

    //Getter :
    public double getCoefCE() {
        return coefCE;
    }


    //Setter :
    public void setCoefCE(double coefCE) {
        this.coefCE = coefCE;
    }


}

