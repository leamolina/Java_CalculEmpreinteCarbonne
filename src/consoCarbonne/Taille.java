package consoCarbonne;

public enum Taille {
    P(4.2),G(19);

    Taille(double fabrication) {
        this.fabrication = fabrication;
    }

    private double fabrication;


    // Getters :
    public double getFabrication() {
        return fabrication;
    }

    //Setters :
    public void setFabrication(double fabrication) {
        this.fabrication = fabrication;
    }
}

