package aq.michelmann.julian.day03;

import aq.michelmann.julian.util.InputReader;
import org.javatuples.Pair;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        List<Pair<String, String>> input = inputReader.getStringPairs("03");

        FirstPart firstPart = new FirstPart();
        Long result = firstPart.solve(input);

        System.out.println(result);
    }
}
