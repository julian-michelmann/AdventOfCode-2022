package aq.michelmann.julian.day04;

import aq.michelmann.julian.base.InputReaderBase;
import org.apache.commons.lang3.Range;
import org.javatuples.Pair;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader extends InputReaderBase {
    public List<Pair<Range<Integer>, Range<Integer>>> getAsListOfRangePairs(String day) throws FileNotFoundException {
        Scanner myReader = readFile(day);

        List<Pair<Range<Integer>, Range<Integer>>> listOfRangePairs = new ArrayList<>();

        while (myReader.hasNextLine()) {
            String[] linesDivided = myReader.nextLine().split(",");
            String[] firstRangeAsArray = linesDivided[0].split("-");
            String[] secondRangeAsArray = linesDivided[1].split("-");

            Range<Integer> firstRange = Range.between(
                    Integer.parseInt(firstRangeAsArray[0]),
                    Integer.parseInt(firstRangeAsArray[1])
            );

            Range<Integer> secondRange = Range.between(
                    Integer.parseInt(secondRangeAsArray[0]),
                    Integer.parseInt(secondRangeAsArray[1])
            );

            listOfRangePairs.add(new Pair<>(firstRange, secondRange));
        }

        return listOfRangePairs;
    }
}
