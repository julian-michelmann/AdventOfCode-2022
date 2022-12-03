package aq.michelmann.julian.util;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class InputReaderTest {

    private final InputReader inputReader = new InputReader();

    @Test
    void getInputAsMappedStringPairs() throws FileNotFoundException {
        Pair<String, String> expectedPair1 = new MutablePair<>("A", "Y");
        Pair<String, String> expectedPair2 = new MutablePair<>("B", "X");
        Pair<String, String> expectedPair3 = new MutablePair<>("C", "Z");

        List<Pair<String, String>> result = inputReader.getListOfStringPairs("02-test");

        assertEquals(expectedPair1, result.get(0));
        assertEquals(expectedPair2, result.get(1));
        assertEquals(expectedPair3, result.get(2));

    }
}
