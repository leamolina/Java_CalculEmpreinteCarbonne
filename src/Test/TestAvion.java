/**
 * Ce package regroupe les differentes classes permettant d'effectuer des tests Junit sur certaines de nos methodes, et donc de nous assurer qu elles fonctionnent bien
 */
package Test;
import consoCarbonne.Avion;
//import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Erreurs.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * La classe TestAvion nous permet de nous assurer que notre code fonctionne toujours même après d'éventuelles modifications.
 */
public class TestAvion {

    private static Avion avionTest;

    /**
     * A chaque fois que nous initialisons la classe TestAvion, un nouvel objet de type Avion est cree.
     */
    @BeforeEach
    public void setUpTest() throws ErrValNeg {
       avionTest = new Avion();
    }

    /**
     * Cette methode nous permet de reinitialiser la variable avionTest a NULL apres chaque test.
     */
    @AfterEach
    public void restore(){
        avionTest=null;
    }


    /**
     * Cette methode nous permet de tester la methode setCalculImpact.
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    @Test
    public void setCalculImpactTest() throws ErrValNeg {
        avionTest.setKm(5);
        double impact =avionTest.getImpact();
        double res = 0.00115;
        assertEquals(res,impact);

    }

    /**
     * Cette methode nous permet de tester notre methode toString.
     */
    @Test
    public void toStringTest() throws ErrValNeg {
        avionTest.setKm(5);
        String toString = avionTest.toString();
        String res = "Avion{Transport{km=5ConsoCarbonne{id=1, impact=0.00115}}}";
        assertEquals(res,toString);
    }





}
