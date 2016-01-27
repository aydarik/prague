package ru.gumerbaev.aydar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for application.
 */
public class AppTest extends Assert {

    private List<String> inputArray;

    @Before
    public void setUp() throws Exception {
        inputArray = InputReader.read("src\\test\\resources\\input.txt");
    }

    @Test
    public void testInputRead() throws Exception {
        assertEquals(5, inputArray.size());
    }

    @Test
    public void testInstruction() throws Exception {
        Instruction instruction = new Instruction("add 1.5");
        assertEquals(2, instruction.apply((float)0.5), 0.01);

        instruction = new Instruction("multiply 3");
        assertEquals(6, instruction.apply(2), 0.01);

        instruction = new Instruction("subtract 3");
        assertEquals(1, instruction.apply(4), 0.01);

        instruction = new Instruction("divide 3");
        assertEquals(0.33, instruction.apply(1), 0.01);
    }

    @Test
    public void testCalc() {
        Calculator calc = new Calculator(inputArray);
        assertEquals(4.5, calc.calc(), 0.01);
    }
}
