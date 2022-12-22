package aq.michelmann.julian.day08;

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
        List<List<Pair<Integer, Integer>>> treeGrid  = inputReader.getIntegerGrid("08-test");
        
        Long result = firstPart.solve(treeGrid);
        
        assertEquals(21L, result);
    }
}