import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAdd() throws Exception {
        assertEquals(10, Calculator.evaluateExpression("1+9"));//
    }

    @Test
    void testmultifunc() throws Exception {
        assertEquals(30, Calculator.evaluateExpression("8+7*2"));
        assertEquals(-7, Calculator.evaluateExpression("8-7*2-9"));
    }

    @Test
    void testDivide() throws Exception {
        assertEquals(2, Calculator.evaluateExpression("4/2"));
        assertEquals(2, Calculator.evaluateExpression("7/3")); // Integer division truncates

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Calculator.evaluateExpression("9/0");
        });
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    void testModulo() throws Exception {
        assertEquals(1, Calculator.evaluateExpression("7%3"));

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Calculator.evaluateExpression("9%0");
        });
        assertEquals("/ by zero", exception.getMessage());
    }


    @Test
    void testminus() throws Exception {
        assertEquals(1, Calculator.evaluateExpression("2-1"));
    }

    @Test
    void testmulti() throws Exception {
        assertEquals(15, Calculator.evaluateExpression("5*3"));
    }

    void errorTest() {
        assertAll(
                () -> {
                    ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
                        Calculator.evaluateExpression("1/0");
                    });
                    assertEquals("Division by zero", exception.getMessage());
                },

                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        Calculator.evaluateExpression("a");
                    });
                    assertEquals("Invalid input: a", exception.getMessage());
                }
        );
    }
}
