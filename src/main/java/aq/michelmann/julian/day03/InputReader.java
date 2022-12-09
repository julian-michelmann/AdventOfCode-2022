package aq.michelmann.julian.day03;

import aq.michelmann.julian.base.InputReaderBase;
import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader extends InputReaderBase {

    public List<Pair<String, String>> getStringPairs(String day) throws FileNotFoundException {
        List<Pair<String, String>> rucksacks = new ArrayList<>();
        Scanner myReader = readFile(day);

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            final int mid = data.length() / 2;
            String[] parts = {data.substring(0, mid), data.substring(mid)};

            rucksacks.add(Pair.fromCollection(List.of(parts[0], parts[1])));
        }

        myReader.close();

        return rucksacks;
    }

    public List<Triplet<String, String, String>> getAsTriples(String day) throws FileNotFoundException {

        Scanner myReader = readFile(day);

        List<Triplet<String, String, String>> triples = new ArrayList<>();

        while (myReader.hasNextLine()) {
            String firstLine = myReader.nextLine();
            String secondLine = myReader.nextLine();
            String thirdLine = myReader.nextLine();

            triples.add(new Triplet<>(firstLine, secondLine, thirdLine));
        }

        myReader.close();

        return triples;
    }
    
    
}
