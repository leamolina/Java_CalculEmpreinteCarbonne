package consoCarbonne;
import java.util.*;
import java.io.*;

/**
 * La production d’une petite voiture émet 4.2tCO2eq et celle d’une grosse voiture 19tCO2eq.
 * L'enumeration Taille contient les differentes tailles de voitures: petite voiture="P" et grosse voiture="G".
 * C'est en fonction de cette taille que les emissions necesaires a la fabrication de la voiture sont calculees .
 */
public enum Taille {
    P(4.2),G(19);
    private static Scanner scan = new Scanner(System.in);
    //Constructeur par défaut
    Taille(){}

    /**
     * @param fabrication
     */
    Taille(double fabrication) {
        this.fabrication = fabrication;
    }

    private double fabrication;


    /**
     * @return Les emissions necesaires a la fabrication de la voiture
     */
    // Getters :
    public double getFabrication() {
        return fabrication;
    }

    /**
     * @param fabrication
     */
    //Setters :
    public void setFabrication(double fabrication) {
        this.fabrication = fabrication;
    }

    //Methode qui permet d'interagir avec l'utilisateur et qui renvoie l'enum correspondante à la taille de la voiture
    public Taille StringToTaille(){
        boolean fin = false;
        Taille resultat = Taille.P;
        do{
            System.out.println("Entrer 0 si la voiture est petite, 1 si elle est grande");
            int t = scan.nextInt();
            if (t == 0){
                resultat = Taille.P;
                fin = true;
                break;
            }
            else if (t == 1){
                resultat = Taille.G;
                fin = true;
                break;
            }
            else {
                System.out.println("La taille indiquée n'existe pas ");
            }

        }while(!fin);
        return(resultat);
    }
}

