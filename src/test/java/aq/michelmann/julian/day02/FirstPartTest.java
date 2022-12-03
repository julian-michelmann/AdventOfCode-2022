package aq.michelmann.julian.day02;

import aq.michelmann.julian.util.InputReader;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FirstPartTest {

    FirstPart firstPart = new FirstPart();

    @Test
    void solve() throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        List<Pair<String, String>> input = inputReader.getListOfStringPairs("02-test");

        Long result = firstPart.solve(input);

        assertEquals(15, result);
    }

    @Test
    void paperVsElfRock() {
        List<Pair<String, String>> match = List.of(new MutablePair<>("B", "X"));

        Long result = firstPart.solve(match);

        assertEquals(1, result);
    }

    @Test
    void scissorVsElfPaper() {
        List<Pair<String, String>> match = List.of(new MutablePair<>("C", "Y"));

        Long result = firstPart.solve(match);

        assertEquals(2, result);
    }

    @Test
    void rockVsElfScissor() {
        List<Pair<String, String>> match = List.of(new MutablePair<>("A", "Z"));

        Long result = firstPart.solve(match);

        assertEquals(3, result);
    }

    @Test
    void rockVsElfRock() {
        List<Pair<String, String>> match = List.of(new MutablePair<>("A", "X"));

        Long result = firstPart.solve(match);

        assertEquals(4, result);
    }

    @Test
    void paperVsElfPaper() {
        List<Pair<String, String>> match = List.of(new MutablePair<>("B", "Y"));

        Long result = firstPart.solve(match);

        assertEquals(5, result);
    }

    @Test
    void scissorVsElfScissor() {
        List<Pair<String, String>> match = List.of(new MutablePair<>("C", "Z"));

        Long result = firstPart.solve(match);

        assertEquals(6, result);
    }

    @Test
    void scissorVsElfRock() {
        List<Pair<String, String>> match = List.of(new MutablePair<>("C", "X"));

        Long result = firstPart.solve(match);

        assertEquals(7, result);
    }

    @Test
    void rockVsElfPaper() {
        List<Pair<String, String>> match = List.of(new MutablePair<>("A", "Y"));

        Long result = firstPart.solve(match);

        assertEquals(8, result);
    }

    @Test
    void paperVsElfScissor() {
        List<Pair<String, String>> match = List.of(new MutablePair<>("B", "Z"));

        Long result = firstPart.solve(match);

        assertEquals(9, result);
    }
}
