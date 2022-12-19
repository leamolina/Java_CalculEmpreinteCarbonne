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
    public void setUpTest() {
       avionTest = new Avion();
    }

    @AfterEach
    //A chaque methode
    public void restore(){
        avionTest=null;
    }


    //Je vais tester mon setCalculImpact
    @Test
    public void setCalculImpactTest() throws ErrValNeg {
        avionTest.setKilomAnnee(5);
        double impact =avionTest.getImpact();
        double res = 0.00115;
        assertEquals(res,impact);

    }

    /**
     * Cette methode nous permet de tester notre methode toString.
     */
    @Test
    public void toStringTest() throws ErrValNeg {
        avionTest.setKilomAnnee(5);
        String toString = avionTest.toString();
        String res = "Avion{Transport{kilomAnnee=5ConsoCarbonne{id=1, impact=0.00115}}}";
        assertEquals(res,toString);
    }





}
