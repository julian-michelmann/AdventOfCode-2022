package aq.michelmann.julian.day02;

import aq.michelmann.julian.util.InputReader;
import org.javatuples.Pair;
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
        List<Pair<String, String>> match = List.of(new Pair<>("B", "X"));

        Long result = firstPart.solve(match);

        assertEquals(1, result);
    }

    @Test
    void scissorVsElfPaper() {
        List<Pair<String, String>> match = List.of(new Pair<>("C", "Y"));

        Long result = firstPart.solve(match);

        assertEquals(2, result);
    }

    @Test
    void rockVsElfScissor() {
        List<Pair<String, String>> match = List.of(new Pair<>("A", "Z"));

        Long result = firstPart.solve(match);

        assertEquals(3, result);
    }

    @Test
    void rockVsElfRock() {
        List<Pair<String, String>> match = List.of(new Pair<>("A", "X"));

        Long result = firstPart.solve(match);

        assertEquals(4, result);
    }

    @Test
    void paperVsElfPaper() {
        List<Pair<String, String>> match = List.of(new Pair<>("B", "Y"));

        Long result = firstPart.solve(match);

        assertEquals(5, result);
    }

    @Test
    void scissorVsElfScissor() {
        List<Pair<String, String>> match = List.of(new Pair<>("C", "Z"));

        Long result = firstPart.solve(match);

        assertEquals(6, result);
    }

    @Test
    void scissorVsElfRock() {
        List<Pair<String, String>> match = List.of(new Pair<>("C", "X"));

        Long result = firstPart.solve(match);

        assertEquals(7, result);
    }

    @Test
    void rockVsElfPaper() {
        List<Pair<String, String>> match = List.of(new Pair<>("A", "Y"));

        Long result = firstPart.solve(match);

        assertEquals(8, result);
    }

    @Test
    void paperVsElfScissor() {
        List<Pair<String, String>> match = List.of(new Pair<>("B", "Z"));

        Long result = firstPart.solve(match);

        assertEquals(9, result);
    }
}
