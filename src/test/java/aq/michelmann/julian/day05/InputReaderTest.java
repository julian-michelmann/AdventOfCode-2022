package aq.michelmann.julian.day05;

import org.javatuples.Triplet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputReaderTest {

    private InputReader inputReader;

    @BeforeEach
    void setUp() {
        inputReader = new InputReader();
    }

    @Test
    void getListOfInstructions() throws FileNotFoundException {
        List<Triplet<Integer, Integer, Integer>> result = inputReader.getListOfInstructionTriples("05-test");

        assertEquals(1, result.get(0).getValue0());
        assertEquals(2, result.get(0).getValue1());
        assertEquals(1, result.get(0).getValue2());

        assertEquals(3, result.get(1).getValue0());
        assertEquals(1, result.get(1).getValue1());
        assertEquals(3, result.get(1).getValue2());

        assertEquals(2, result.get(2).getValue0());
        assertEquals(2, result.get(2).getValue1());
        assertEquals(1, result.get(2).getValue2());

        assertEquals(1, result.get(3).getValue0());
        assertEquals(1, result.get(3).getValue1());
        assertEquals(2, result.get(3).getValue2());
    }
    
    @Test
    void getStacksOfItems() throws FileNotFoundException {
        List<List<String>> result = inputReader.getStacksOfItems("05-test");
        
        assertEquals(3, result.size());
        
        List<String> firstStack = result.get(0);
        assertEquals(2, firstStack.size());
        assertEquals("N", firstStack.get(0));
        assertEquals("Z", firstStack.get(1));

        List<String> secondStack = result.get(1);
        assertEquals(3, secondStack.size());
        assertEquals("D", secondStack.get(0));
        assertEquals("C", secondStack.get(1));
        assertEquals("M", secondStack.get(2));
        
        List<String> thirdStack = result.get(2);
        assertEquals(1, thirdStack.size());
        assertEquals("P", thirdStack.get(0));
    }
}