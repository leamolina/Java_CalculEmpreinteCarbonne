package Test;
import consoCarbonne.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Erreurs.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBienConso {

    private static BienConso bienConsoTest;

    /**
     * A chaque fois que nous initialisons la classe TestBienConso, un nouvel objet de type BienConso est cree.
     */

    @BeforeEach
    public void setUpTest() {
        bienConsoTest = new BienConso();
    }

    @AfterEach
    //A chaque methode
    public void restore(){
        bienConsoTest=null;
    }

    /**
     * Test de la methode setCalculImpact
     * Nous avons decide de mettre le montant= 1750, la valeur attendue (calculee à la main) est 1.0
     */
    @Test
    public void setCalculImpactTest() throws ErrValNeg {
        bienConsoTest.setMontant(1750);
        double impact = bienConsoTest.getImpact();
        double res = 1.0;
        assertEquals(res,impact);

    }


    /**
     * Cette methode nous permet de tester la methode setMontant.
     */
    @Test
    public void setMontantTest() throws ErrValNeg {
        bienConsoTest.setMontant(1750);
        double montant = bienConsoTest.getMontant();
        double res = 1750;
        assertEquals(res, montant);
    }

    /**
     * Cette methode nous permet de tester la methode toString.
     */
    @Test
    public void toStringTest() throws ErrValNeg {
        bienConsoTest.setMontant(1750);
        String toString = bienConsoTest.toString();
        String res = "BienConso{montant=1750.0  ConsoCarbonne{id=1, impact=1.0}}\n";
        assertEquals(res,toString);
    }


}
