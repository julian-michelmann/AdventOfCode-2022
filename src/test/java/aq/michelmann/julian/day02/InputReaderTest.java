package aq.michelmann.julian.day02;

import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    private InputReader inputReader;

    @BeforeEach
    void setUp() {
        inputReader = new InputReader();
    }

    @Test
    void getInputAsMappedStringPairs() throws FileNotFoundException {
        Pair<String, String> expectedPair1 = new Pair<>("A", "Y");
        Pair<String, String> expectedPair2 = new Pair<>("B", "X");
        Pair<String, String> expectedPair3 = new Pair<>("C", "Z");

        List<Pair<String, String>> result = inputReader.getListOfStringPairs("02-test");

        assertEquals(expectedPair1, result.get(0));
        assertEquals(expectedPair2, result.get(1));
        assertEquals(expectedPair3, result.get(2));
    }
    
}