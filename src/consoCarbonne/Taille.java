package consoCarbonne;

/**
 * La production d’une petite voiture émet 4.2tCO2eq et celle d’une grosse voiture 19tCO2eq.
 * L'enumeration Taille contient les differentes tailles de voitures: petite voiture="P" et grosse voiture="G".
 * C'est en fonction de cette taille que les emissions necesaires a la fabrication de la voiture sont calculees .
 */
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

