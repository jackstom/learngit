import org.junit.Test;

import static org.junit.Assert.*;

public class MathTest {

    @Test
    public void testFactorial() throws Exception {
        assertEquals(120, new Math().factorial(5));
    }

    @Test
    public void testFibonacci() throws Exception{
        assertEquals(21, new Math().fibonacci(9));
    }
}