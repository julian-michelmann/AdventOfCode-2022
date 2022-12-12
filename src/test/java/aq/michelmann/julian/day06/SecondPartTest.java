package aq.michelmann.julian.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondPartTest {
    
    @Test
    void solve() {
        SecondPart secondPart = new SecondPart();
        
        int result = secondPart.solve("mjqjpqmgbljsphdztnvjfqwrcgsmlb");
        
        assertEquals(19, result);
    }

}