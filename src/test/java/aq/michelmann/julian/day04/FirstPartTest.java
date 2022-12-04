package aq.michelmann.julian.day04;

import aq.michelmann.julian.util.InputReader;
import org.apache.commons.lang3.Range;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FirstPartTest {
    
    InputReader inputReader = new InputReader();
    FirstPart firstPart = new FirstPart();
        
    @Test
    void solve() throws FileNotFoundException {
        List<Pair<Range<Integer>, Range<Integer>>> input = inputReader.getAsListOfRangePairs("04-test");
        
        int result = firstPart.solve(input);
        
        assertEquals(2, result);
    }
}