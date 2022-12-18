package aq.michelmann.julian.day07;

import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondPartTest {

    InputReader inputReader = new InputReader();
    SecondPart secondPart;


    @BeforeEach
    void setup() {
        secondPart = new SecondPart();
    }

    @Test
    void test() throws FileNotFoundException {
        Map<String, Pair<Long, List<Pair<Long, String>>>> filesystem = inputReader.getFilesystem("07-test");

        Long result = secondPart.solve(filesystem);

        assertEquals(24933642L, result);
    }
}
