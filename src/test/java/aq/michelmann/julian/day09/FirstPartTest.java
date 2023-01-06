package aq.michelmann.julian.day09;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FirstPartTest {
    
    InputReader inputReader;

    FirstPartTest() throws FileNotFoundException {
        inputReader = new InputReader("09-test");
    }
    
    @Test
    void solve() {
        
        FirstPart firstPart = new FirstPart(inputReader.getGrid(), inputReader.getMarks(), inputReader.getInstructions());
        
        long result = firstPart.solve();
        
        assertEquals(13L, result);
    }

}