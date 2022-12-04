package aq.michelmann.julian.day02;

import aq.michelmann.julian.util.InputReader;
import org.apache.commons.lang3.tuple.Pair;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        List<Pair<String, String>> input = inputReader.getListOfStringPairs("02");

        FirstPart firstPart = new FirstPart();
        Long result = firstPart.solve(input);

        System.out.println(result);
        
        SecondPart secondPart = new SecondPart();
        Long secondResult = secondPart.solve(input);

        System.out.println(secondResult);
    }
}
