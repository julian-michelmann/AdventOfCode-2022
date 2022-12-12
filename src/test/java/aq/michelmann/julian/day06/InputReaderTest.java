package aq.michelmann.julian.day06;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputReaderTest {

    @Test
    void getString() throws FileNotFoundException {
        InputReader inputReader = new InputReader();

        String result = inputReader.getString("06-test");
        assertEquals("mjqjpqmgbljsphdztnvjfqwrcgsmlb", result);
    }
}