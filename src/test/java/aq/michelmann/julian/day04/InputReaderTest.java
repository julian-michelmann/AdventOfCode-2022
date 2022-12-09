package aq.michelmann.julian.day04;

import org.apache.commons.lang3.Range;
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
    void getAsListOfRangePairs() throws FileNotFoundException {
        List<Pair<Range<Integer>, Range<Integer>>> result = inputReader.getAsListOfRangePairs("04-test");

        assertEquals(new Pair<>(Range.between(2, 4), Range.between(6, 8)), result.get(0));
        assertEquals(new Pair<>(Range.between(2, 3), Range.between(4, 5)), result.get(1));
        assertEquals(new Pair<>(Range.between(5, 7), Range.between(7, 9)), result.get(2));
        assertEquals(new Pair<>(Range.between(2, 8), Range.between(3, 7)), result.get(3));
        assertEquals(new Pair<>(Range.between(6, 6), Range.between(4, 6)), result.get(4));
        assertEquals(new Pair<>(Range.between(2, 6), Range.between(4, 8)), result.get(5));
    }
}