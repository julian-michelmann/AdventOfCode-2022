package aq.michelmann.julian.day06;

import aq.michelmann.julian.base.InputReaderBase;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReader extends InputReaderBase {
    
    String getString(String day) throws FileNotFoundException {
        Scanner myReader = readFile(day);
        
        String dataStream = myReader.nextLine();
        
        myReader.close();
        
        return dataStream;
    }
    
}
