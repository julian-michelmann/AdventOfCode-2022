package aq.michelmann.julian.util;


import org.apache.commons.lang3.Range;
import org.javatuples.Pair;
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
    void getInputAsMappedStringPairs() throws FileNotFoundException {
        Pair<String, String> expectedPair1 = new Pair<>("A", "Y");
        Pair<String, String> expectedPair2 = new Pair<>("B", "X");
        Pair<String, String> expectedPair3 = new Pair<>("C", "Z");

        List<Pair<String, String>> result = inputReader.getListOfStringPairs("02-test");

        assertEquals(expectedPair1, result.get(0));
        assertEquals(expectedPair2, result.get(1));
        assertEquals(expectedPair3, result.get(2));
    }

    @Test
    void getStringPairs() throws FileNotFoundException {
        List<Pair<String, String>> result = inputReader.getStringPairs("03-test");

        assertEquals(new Pair<>("vJrwpWtwJgWr", "hcsFMMfFFhFp"), result.get(0));
        assertEquals(new Pair<>("jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL"), result.get(1));
        assertEquals(new Pair<>("PmmdzqPrV", "vPwwTWBwg"), result.get(2));
        assertEquals(new Pair<>("wMqvLMZHhHMvwLH", "jbvcjnnSBnvTQFn"), result.get(3));
        assertEquals(new Pair<>("ttgJtRGJ", "QctTZtZT"), result.get(4));
        assertEquals(new Pair<>("CrZsJsPPZsGz", "wwsLwLmpwMDw"), result.get(5));
    }

    @Test
    void getListOfStringPairsInTripels() throws FileNotFoundException {
        List<Triplet<String, String, String>> result = inputReader.getAsTriples("03-test");

        assertEquals("vJrwpWtwJgWrhcsFMMfFFhFp", result.get(0).getValue0());
        assertEquals("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", result.get(0).getValue1());
        assertEquals("PmmdzqPrVvPwwTWBwg", result.get(0).getValue2());
        assertEquals("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", result.get(1).getValue0());
        assertEquals("ttgJtRGJQctTZtZT", result.get(1).getValue1());
        assertEquals("CrZsJsPPZsGzwwsLwLmpwMDw", result.get(1).getValue2());
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