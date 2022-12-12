package Test;
import consoCarbonne.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBienConso {

    private static BienConso bienConsoTest;

    @BeforeAll
    public static void setUpTest() {
        bienConsoTest = new BienConso();
    }

    @AfterEach
    //A chaque methode
    public void restore(){
        bienConsoTest=null;
    }

    //Je vais tester la methode setCalculImpact
    //On decide de mettre le montant à 1750
    @Test
    public void setCalculImpactTest(){
        bienConsoTest.setMontant(1750);
        double impact = bienConsoTest.getImpact();
        double res = 1.0;
        assertEquals(res,impact);

    }


}
