package Lesson_14_junit_5;

import Lesson14.*;
import org.junit.Test;
import static org.junit.Assert.assertThrows;
import static org.testng.Assert.assertEquals;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0), "Факториал 0, должен быть 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5), "Факториал 5 должен быть 120");
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculateFactorial(1), "Факториал 1 должен быть 1");
    }

    @Test
    public void testNegativeNumberThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-1);
        });
        assertEquals("Число должно быть неотрицательным.", exception.getMessage());
    }
}

