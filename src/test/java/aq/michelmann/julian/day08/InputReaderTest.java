package aq.michelmann.julian.day08;

import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {
    
    InputReader inputReader;
    
    @BeforeEach
    void setup() {
        inputReader = new InputReader();
    }

    @Test
    void getSecond() throws FileNotFoundException {
        List<List<Pair<Integer, Integer>>> result = inputReader.getIntegerGrid("08-test");

        result.forEach(trees -> {
            trees.forEach(tree -> assertEquals(0, tree.getValue1()));
        });

        assertEquals(3, result.get(0).get(0).getValue0());
        assertEquals(3, result.get(0).get(2).getValue0());
        assertEquals(3, result.get(0).get(4).getValue0());

        assertEquals(6, result.get(2).get(0).getValue0());
        assertEquals(3, result.get(2).get(2).getValue0());
        assertEquals(2, result.get(2).get(4).getValue0());

        assertEquals(3, result.get(4).get(0).getValue0());
        assertEquals(3, result.get(4).get(2).getValue0());
        assertEquals(0, result.get(4).get(4).getValue0());
    }
}
