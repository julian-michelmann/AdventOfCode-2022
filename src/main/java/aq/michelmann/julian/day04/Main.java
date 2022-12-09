package aq.michelmann.julian.day04;

import org.apache.commons.lang3.Range;
import org.javatuples.Pair;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        List<Pair<Range<Integer>, Range<Integer>>> input = inputReader.getAsListOfRangePairs("04");

        FirstPart firstPart = new FirstPart();
        int result = firstPart.solve(input);

        System.out.println(result);

        SecondPart secondPart = new SecondPart();
        int resultOfSecondPart = secondPart.solve(input);

        System.out.println(resultOfSecondPart);
    }
}
