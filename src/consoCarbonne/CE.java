package consoCarbonne;
import java.util.*;
import java.io.*;

/**
 * L'enumeration CE contient les differentes classes energetiques de A a G associees a leurs coefficient energetique.
 * A represente une excellente classe energetique tandis que G une classe energetique deconseillee.
 */
public enum CE {
    A(0.005), B(0.01), C(0.02), D(0.035), E( 0.055), F( 0.08), G(0.1);
    private static Scanner scan = new Scanner(System.in);

    /**
     * Constructeur par défaut
     */
    CE(){}

    /**
     * @param coefCE
     */
    //Constructeur :

    CE(double coefCE) {
        this.coefCE = coefCE;
    }

    private double coefCE = 0.0;


    /**
     * @return Le coefficient associe a la classe energetique du logement associe
     */
    //Getter :
    public double getCoefCE() {
        return coefCE;
    }


    /**
     * Methode permettant de fixer le coefficient energetique.
     * @param coefCE
     */

    //Setter :
    public void setCoefCE(double coefCE) {
        this.coefCE = coefCE;
    }


    /**
     * Methode qui permet de communiquer avec l'utilisateur.
     * L'utilisateur rentrera A, B, C, D, E ou F sur la console.
     * @return  Le coefficient associe a la classe energetique entree par l'utilisateur.
     */
    public CE StringToCE(){
        boolean fin = false;
        CE resultat = CE.A;
        do{
            System.out.println("Entrez la classe energetique de l'utilisatieur :");
            String c = scan.next();
            switch(c) {
                case ("A"):
                    resultat = CE.A;
                    fin = true;
                    break;
                case ("B"):
                    resultat = CE.B;
                    fin = true;
                    break;
                case ("C"):
                    resultat = CE.C;
                    fin = true;
                    break;
                case ("D"):
                    resultat = CE.D;
                    fin = true;
                    break;
                case ("E"):
                    resultat = CE.E;
                    fin = true;
                    break;
                case ("F"):
                    resultat = CE.F;
                    fin = true;
                    break;
                case ("G"):
                    resultat = CE.G;
                    fin = true;
                    break;
                default:
                    System.out.println("La classe energetique indiquée n'existe pas. ");
            }
        } while(fin==false);
    scan.close();
    return (resultat);
    }


    //Methoe qui passe d'un string a un type (pour de vrai ce

}

