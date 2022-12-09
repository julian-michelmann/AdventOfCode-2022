package aq.michelmann.julian.day01;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        InputReader inputReader = new InputReader();
        List<List<Long>> input = inputReader.inputToNestedLongList("01");
        FirstPart firstPart = new FirstPart();

        String resultFirstPart = firstPart.solve(input);

        System.out.println(resultFirstPart);

        SecondPart secondPart = new SecondPart();
        String resultSecondPart = secondPart.solve(input);

        System.out.println(resultSecondPart);
    }
}
