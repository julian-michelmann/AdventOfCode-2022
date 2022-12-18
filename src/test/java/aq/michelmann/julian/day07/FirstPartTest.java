package aq.michelmann.julian.day07;

import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstPartTest {

    FirstPart firstPart;
    InputReader inputReader = new InputReader();

    @BeforeEach
    void setup() {
        firstPart = new FirstPart();
    }

    @Test
    void test() throws FileNotFoundException {
        Map<String, Pair<Long, List<Pair<Long, String>>>> filesystem = inputReader.getFilesystem("07-test");

        Long result = firstPart.solve(filesystem);

        assertEquals(95437L, result);
    }

}
