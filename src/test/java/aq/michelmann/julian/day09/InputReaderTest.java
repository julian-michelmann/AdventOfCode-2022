package aq.michelmann.julian.day09;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputReaderTest {

    InputReader inputReader;

    InputReaderTest() throws FileNotFoundException {
        this.inputReader = new InputReader("09-test");
    }

    @Test
    void instructions() {
        List<String> instructions = inputReader.getInstructions();

        assertEquals("R 4", instructions.get(0));
        assertEquals("D 1", instructions.get(3));
        assertEquals("R 2", instructions.get(7));
    }

    @Test
    void grid() {
        List<List<String>> grid = inputReader.getGrid();

        assertEquals(7, grid.size());

        assertEquals(19, grid.get(0).size());
        assertEquals(19, grid.get(3).size());
        assertEquals(19, grid.get(6).size());

        grid
                .stream()
                .flatMap(Collection::stream)
                .forEach(field -> assertEquals(".", field));
    }

    @Test
    void marks() {
        Map<String, Pair<Integer, Integer>> marks = inputReader.getMarks();

        assertEquals(8, marks.get("s").getValue0());
        assertEquals(4, marks.get("s").getValue1());

        assertEquals(8, marks.get("h").getValue0());
        assertEquals(4, marks.get("h").getValue1());

        assertEquals(8, marks.get("t").getValue0());
        assertEquals(4, marks.get("t").getValue1());
    }
}