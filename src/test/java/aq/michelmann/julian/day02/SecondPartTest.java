package aq.michelmann.julian.day02;

import aq.michelmann.julian.util.InputReader;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SecondPartTest {
    
    SecondPart secondPart = new SecondPart();
    
    @Test
    void solve() throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        List<Pair<String, String>> input = inputReader.getListOfStringPairs("02-test");
        
        Long result = secondPart.solve(input);
        
        assertEquals(12, result);
    }
}