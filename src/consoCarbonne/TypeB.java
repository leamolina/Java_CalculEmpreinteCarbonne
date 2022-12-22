package consoCarbonne;
import java.util.*;
import java.io.*;
/**
 * L'enumeration TypeB contient les differentes types de bus associee a leurs coefficient energetique.
 * E represente les bus electrique, M les bus a moteur
 */
public enum TypeB {
    E(0.00002), M(0.0001);
    private final Scanner scan = new Scanner(System.in);
    //Constructeur par défaut
    TypeB(){}

    /**
     * @param coef represente le coefficient energetique
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

    //Setter
    /**
     * @param coef represente le coefficient energetique
     */
    public void setCoef(double coef) {
        this.coef = coef;
    }

    /**
     * Methode qui demande à l'utilisateur si le bus est à moteur ou electrique.
     * @return la reponse de l'utilisateur concernant le type de bus en la convertissant en TypeB.
     */
    public TypeB StringToTypeBBis(){
        boolean fin = false;
        TypeB resultat = TypeB.M;
        do{
            System.out.println("Entrer 0 si le bus est à moteur, 1 s'il est electrique. ");
            int t = scan.nextInt();
            if (t == 0){
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

    /**
     * Methode qui convertit un string (argument) en un element de type TypeB.
     * @param type represente le type de bus
     * @return l'argument de la methode convertit en un element de type TypeB.
     */
    public static TypeB StringToTypeB(String type){
        boolean fin = false;
        TypeB resultat = TypeB.M;
        do{
            if (type.equals("M")){
                fin = true;
                break;
            }
            else if (type.equals("E")){
                resultat = TypeB.E;
                fin = true;
                break;
            }
            else {
                System.out.println("Le type indiqué n'existe pas. Par défaut, nous considérons que le bus est à moteur ");
            }

        }while(!fin);
        return(resultat);
    }

}
