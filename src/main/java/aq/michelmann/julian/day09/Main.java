package aq.michelmann.julian.day09;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader("09");
        FirstPart firstPart = new FirstPart(inputReader.getGrid(), inputReader.getMarks(), inputReader.getInstructions());
        
        long result = firstPart.solve();
        
        System.out.println(result);
    }
}
