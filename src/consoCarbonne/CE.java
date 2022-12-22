package consoCarbonne;
import java.util.*;

/**
 * L'enumeration CE contient les differentes classes energetiques de A a G associees a leurs coefficient energetiques.
 * A represente une excellente classe energetique tandis que G une classe energetique deconseillee.
 */
public enum CE {
    A(0.005), B(0.01), C(0.02), D(0.035), E( 0.055), F( 0.08), G(0.1);
    private final Scanner scan = new Scanner(System.in);


    /**
     * Constructeur par défaut
     */
    CE(){}

    /**
     * @param coefCE coefCE represente le coefficient associe a chaque classe energetique. Il permettra de calculer l'impact d'un logement
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
     * @param coefCE coefCE de la classe energetique
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
    public CE StringToCEBis(){
        boolean fin = false;
        CE resultat = CE.A;
        do{
            System.out.println("Entrez la classe energetique du logement (une lettre comprise entre A et G) :");
            String c = scan.next();
            switch (c) {
                case ("A") -> fin = true;
                case ("B") -> {
                    resultat = CE.B;
                    fin = true;
                }
                case ("C") -> {
                    resultat = CE.C;
                    fin = true;
                }
                case ("D") -> {
                    resultat = CE.D;
                    fin = true;
                }
                case ("E") -> {
                    resultat = CE.E;
                    fin = true;
                }
                case ("F") -> {
                    resultat = CE.F;
                    fin = true;
                }
                case ("G") -> {
                    resultat = CE.G;
                    fin = true;
                }
                default -> System.out.println("La classe énergétique indiquée n'existe pas. Veuillez réésayer.");
            }
        } while(!fin);
    return (resultat);
    }



    public static CE StringToCE(String c){
        boolean fin = false;
        CE resultat = CE.A;
        do{
            switch (c) {
                case ("A") -> fin = true;
                case ("B") -> {
                    resultat = CE.B;
                    fin = true;
                }
                case ("C") -> {
                    resultat = CE.C;
                    fin = true;
                }
                case ("D") -> {
                    resultat = CE.D;
                    fin = true;
                }
                case ("E") -> {
                    resultat = CE.E;
                    fin = true;
                }
                case ("F") -> {
                    resultat = CE.F;
                    fin = true;
                }
                case ("G") -> {
                    resultat = CE.G;
                    fin = true;
                }
                default -> System.out.println("La classe energetique indiquée n'existe pas. Par défaut, nous considérons que la classe énergetique du logement est C ");
            }
        } while(!fin);
        return (resultat);
    }

}

