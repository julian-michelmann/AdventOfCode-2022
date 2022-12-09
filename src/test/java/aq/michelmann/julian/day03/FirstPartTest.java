package aq.michelmann.julian.day03;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstPartTest {

    FirstPart firstPart = new FirstPart();

    @Test
    void solve() throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        List<Pair<String, String>> rucksacks = inputReader.getStringPairs("03-test");

        Long result = firstPart.solve(rucksacks);

        assertEquals(157, result);
    }

}