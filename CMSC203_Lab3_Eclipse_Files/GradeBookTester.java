import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTester {

    private GradeBook g1, g2;

    @Before
    public void setUp() throws Exception {
        g1 = new GradeBook(5);
        g2 = new GradeBook(5);

        g1.addScore(50.0);
        g1.addScore(75.0);

        g2.addScore(100.0);
        g2.addScore(90.0);
        g2.addScore(80.0);
    }

    @After
    public void tearDown() throws Exception {
        g1 = null;
        g2 = null;
    }

    @Test
    public void testAddScore() {
        assertTrue(g1.toString().equals("50.0 75.0 "));
        assertEquals(2, g1.getScoreSize());

        assertTrue(g2.toString().equals("100.0 90.0 80.0 "));
        assertEquals(3, g2.getScoreSize());
    }

    @Test
    public void testSum() {
        assertEquals(125.0, g1.sum(), 0.0001);
        assertEquals(270.0, g2.sum(), 0.0001);
    }

    @Test
    public void testMinimum() {
        assertEquals(50.0, g1.minimum(), 0.001);
        assertEquals(80.0, g2.minimum(), 0.001);
    }

    @Test
    public void testFinalScore() {
        assertEquals(75.0, g1.finalScore(), 0.0001);
        assertEquals(190.0, g2.finalScore(), 0.0001);
    }
}