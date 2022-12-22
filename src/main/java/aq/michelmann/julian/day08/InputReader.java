package aq.michelmann.julian.day08;

import aq.michelmann.julian.base.InputReaderBase;
import org.javatuples.Pair;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputReader extends InputReaderBase {

    public List<List<Pair<Integer, Integer>>> getIntegerGrid(String day) throws FileNotFoundException {
        Scanner myReader = readFile(day);
        List<List<Pair<Integer, Integer>>> treeGrid = new ArrayList<>();

        while (myReader.hasNextLine()) {
            String[] nextLine = myReader.nextLine().split("");

            List<Pair<Integer, Integer>> treeRow = Arrays.stream(nextLine)
                    .map(Integer::parseInt)
                    .map(height -> new Pair<>(height, 0))
                    .collect(Collectors.toCollection(ArrayList::new));

            treeGrid.add(treeRow);
        }

        return treeGrid;
    }
}
