package consoCarbonne;
import java.util.*;

/**
 * La production d’une petite voiture emet 4.2tCO2eq et celle d’une grosse voiture 19tCO2eq.
 * L'enumeration Taille contient les differentes tailles de voitures: petite voiture="P" et grosse voiture="G".
 * C'est en fonction de cette taille que les emissions necesaires a la fabrication de la voiture sont calculees .
 */
public enum Taille {
    P(4.2),G(19);
    private final Scanner scan = new Scanner(System.in);
    //Constructeur par défaut
    Taille(){}

    /**
     * @param fabrication represente les emission nécessaires a la fabrication de la voiture
     */
    Taille(double fabrication) {
        this.fabrication = fabrication;
    }

    private double fabrication;

    // Getters :
    /**
     * @return Les emissions necesaires a la fabrication de la voiture
     */
    public double getFabrication() {
        return fabrication;
    }

    //Setters :
    /**
     * @param fabrication represente les emission necessaire à la fabrication de la voiture.
     */
    public void setFabrication(double fabrication) {
        this.fabrication = fabrication;
    }

    /**
     * Methode qui permet d'interagir avec l'utilisateur et qui renvoie la taille correspondante de la voiture.
     * @return la reponse de l'utilisateur concernant la taille de la voiture et convertit cette reponse en type Taille.
     */
    public Taille StringToTailleBis(){
        boolean fin = false;
        Taille resultat = Taille.P;
        do{
            System.out.println("Entrer 0 si la voiture est petite, 1 si elle est grande");
            int t = scan.nextInt();
            if (t == 0){
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

    /**
     * Methode qui convertit un string (argument) en un element de type Taille.
     * @param taille represente la taille du vehicule
     * @return l'argument de la methode convertit en un element de type Taille.
     */
    public static Taille StringToTaille(String taille){
        boolean fin = false;
        Taille resultat = Taille.P;
        do{

            if (taille.equals("P")){
                fin = true;
                break;
            }
            else if (taille.equals("G")){
                resultat = Taille.G;
                fin = true;
                break;
            }
            else {
                System.out.println("La taille indiquée n'existe pas. Par défaut, nous considérons que la voiture est petite. ");
            }

        }while(!fin);
        return(resultat);
    }
}

