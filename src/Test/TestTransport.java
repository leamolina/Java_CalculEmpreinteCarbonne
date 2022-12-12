package Test;
import consoCarbonne.Avion;
import consoCarbonne.Transport;
//import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestTransport {
    private static Avion avionTest;
    //A chaque fois que j initialise la classe ca lance cet objet
    @BeforeAll
    public static void setUpTest() {
       avionTest = new Avion();
    }

    @AfterEach
    //A chaque methode
    public void restore(){
        avionTest=null;
    }


    //Je vais tester mon setCalculImpact
    @Test
    public void setCalculImpactTest(){
        avionTest.setKilomAnnee(5);
        double impact =avionTest.getImpact();
        double res = 0.00115;
        assertEquals(res,impact);

    }





}
