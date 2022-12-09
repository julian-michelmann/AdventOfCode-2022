package aq.michelmann.julian.day03;

import org.javatuples.Triplet;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondPartTest {

    SecondPart secondPart = new SecondPart();

    @Test
    void solve() throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        List<Triplet<String, String, String>> input = inputReader.getAsTriples("03-test");

        Long result = secondPart.solve(input);

        assertEquals(70L, result);
    }
}