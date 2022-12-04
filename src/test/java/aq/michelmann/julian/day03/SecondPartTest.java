package aq.michelmann.julian.day03;

import aq.michelmann.julian.util.InputReader;
import org.javatuples.Triplet;
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
        List<Triplet<String, String, String>> input = inputReader.getAsTriples("03-test");

        Long result = secondPart.solve(input);
        
        assertEquals(70L, result);
    }
}