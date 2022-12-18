package aq.michelmann.julian.day07;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputReaderTest {

    @Test
    void test() throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        Map<String, Pair<Long, List<Pair<Long, String>>>> result = inputReader.getFilesystem("07-test");

        assertTrue(result.containsKey("/a"));
        assertEquals(94853L, result.get("/a").getValue0());
        assertEquals(3, result.get("/a").getValue1().size());
        assertTrue(result.get("/a").getValue1().stream().anyMatch(file -> Objects.equals(file.getValue1(), "f") && Objects.equals(file.getValue0(), 29116L)));
        assertTrue(result.get("/a").getValue1().stream().anyMatch(file -> Objects.equals(file.getValue1(), "g") && Objects.equals(file.getValue0(), 2557L)));
        assertTrue(result.get("/a").getValue1().stream().anyMatch(file -> Objects.equals(file.getValue1(), "h.lst") && Objects.equals(file.getValue0(), 62596L)));

        assertTrue(result.containsKey("/d"));
        assertEquals(24933642L, result.get("/d").getValue0());
        assertEquals(4, result.get("/d").getValue1().size());
        assertTrue(result.get("/d").getValue1().stream().anyMatch(file -> Objects.equals(file.getValue1(), "j") && Objects.equals(file.getValue0(), 4060174L)));
        assertTrue(result.get("/d").getValue1().stream().anyMatch(file -> Objects.equals(file.getValue1(), "d.log") && Objects.equals(file.getValue0(), 8033020L)));
        assertTrue(result.get("/d").getValue1().stream().anyMatch(file -> Objects.equals(file.getValue1(), "d.ext") && Objects.equals(file.getValue0(), 5626152L)));
        assertTrue(result.get("/d").getValue1().stream().anyMatch(file -> Objects.equals(file.getValue1(), "k") && Objects.equals(file.getValue0(), 7214296L)));
        
        assertTrue(result.containsKey("/a/e"));
        assertEquals(584L, result.get("/a/e").getValue0());
        assertEquals(1, result.get("/a/e").getValue1().size());
        assertTrue(result.get("/a/e").getValue1().stream().anyMatch(file -> Objects.equals(file.getValue1(), "i") && Objects.equals(file.getValue0(), 584L)));
        
        assertTrue(result.containsKey("/"));
        assertEquals(48381165L, result.get("/").getValue0());
        assertEquals(2, result.get("/").getValue1().size());
        assertTrue(result.get("/").getValue1().stream().anyMatch(file -> Objects.equals(file.getValue1(), "b.txt") && Objects.equals(file.getValue0(), 14848514L)));
        assertTrue(result.get("/").getValue1().stream().anyMatch(file -> Objects.equals(file.getValue1(), "c.dat") && Objects.equals(file.getValue0(), 8504156L)));
    }
}
