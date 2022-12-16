package consoCarbonne;
import java.util.*;
import java.io.*;
/**
 * L'enumeration TypeB contient les differentes types de bus associee a leurs coefficient energetique.
 * E represente les bus electrique, M les bus a moteur
 */
public enum TypeB {
    E(0.00002), M(0.0001);
    private static Scanner scan = new Scanner(System.in);

    /**
     * @param coef
     */
    //Constructeur :
    TypeB(double coef) {
        this.coef = coef;
    }

    private double coef = 0.0;


    /**
     * @return le coefficient energitique en fonction de si l'objet est un bus electrique ou a moteur
     */
    //Getter :
    public double getCoef() {
        return coef;
    }

    /**
     * @param coef
     */
    //Setter
    public void setCoef(double coef) {
        this.coef = coef;
    }

    //Methode qui demande à l'utilisateur si le bus qu'il veut détailler est à moteur ou electrique
    public TypeB StringToTypeB(){
        boolean fin = false;
        TypeB resultat = TypeB.M;
        do{
            System.out.println("Entrer 0 si le bus est à moteur, 1 s'il est electrique. ");
            int t = scan.nextInt();
            if (t == 0){
                resultat = TypeB.M;
                fin = true;
                break;
            }
            else if (t == 1){
                resultat = TypeB.E;
                fin = true;
                break;
            }
            else {
                System.out.println("Le type indiqué n'existe pas ");
            }

        }while(fin == false);
        return(resultat);
    }



}
