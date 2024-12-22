package Lesson_14_testng;

import Lesson14.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialCalculatorTestNG {

    @Test
    public void testFactorialOfZero() {
        assertEquals(FactorialCalculator.calculateFactorial(0), 1, "Factorial of 0 should be 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(FactorialCalculator.calculateFactorial(5), 120, "Factorial of 5 should be 120");
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(FactorialCalculator.calculateFactorial(1), 1, "Factorial of 1 should be 1");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Number must be non-negative.")
    public void testNegativeNumberThrowsException() {
        FactorialCalculator.calculateFactorial(-1);
    }
}
