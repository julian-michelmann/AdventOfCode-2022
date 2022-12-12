package aq.michelmann.julian.day06;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        FirstPart firstPart = new FirstPart();
        SecondPart secondPart = new SecondPart();
        
        String dataStream = inputReader.getString("06");
        
        int resultFirstPart = firstPart.solve(dataStream);
        System.out.println(resultFirstPart);
        
        
        int resultSecondPart = secondPart.solve(dataStream);
        System.out.println(resultSecondPart);
    }
}
