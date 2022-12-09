package aq.michelmann.julian.day02;

import aq.michelmann.julian.base.InputReaderBase;
import org.javatuples.Pair;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader extends InputReaderBase {

    public List<Pair<String, String>> getListOfStringPairs(String day) throws FileNotFoundException {
        List<Pair<String, String>> resultList = new ArrayList<>();

        Scanner myReader = readFile(day);

        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().split(" ");
            resultList.add(new Pair<>(data[0], data[1]));
        }

        myReader.close();

        return resultList;
    }
}
