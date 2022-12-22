package aq.michelmann.julian.day08;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SecondPartTest 
{
    
    SecondPart secondPart = new SecondPart();
    InputReader inputReader = new InputReader();
    
    @Test
    void solve() throws FileNotFoundException {
        List<List<Pair<Integer, Integer>>> treeGrid = inputReader.getSecond("08-test");
        Integer result = secondPart.solve(treeGrid);
        
        assertEquals(8, result);
    }
}