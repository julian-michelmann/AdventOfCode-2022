package aq.michelmann.julian.day03;

import aq.michelmann.julian.base.InputReaderBase;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest extends InputReaderBase {

    private InputReader inputReader;

    @BeforeEach
    void setUp() {
        inputReader = new InputReader();
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

}