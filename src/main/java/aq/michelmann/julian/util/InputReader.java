package aq.michelmann.julian.util;


import aq.michelmann.julian.day04.FirstPart;
import org.apache.commons.lang3.Range;
import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {


    private static final String PATH_TO_INPUT_FILES = "src/main/java/aq/michelmann/julian/input/input-%s.txt";
    String projectDirectory;

    public InputReader() {
        projectDirectory = System.getProperty("user.dir");
    }

    public List<List<Long>> inputToNestedLongList(String day) throws FileNotFoundException {
        Scanner myReader = readFile(day);

        List<List<Long>> readyInput = new ArrayList<>();
        readyInput.add(new ArrayList<>());

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            if (data.isEmpty()) {
                readyInput.add(new ArrayList<>());
            } else {
                List<Long> part = readyInput.get(readyInput.size() - 1);

                Long parsed = Long.parseLong(data);
                part.add(parsed);
            }
        }

        myReader.close();

        return readyInput;
    }

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

    private Scanner readFile(String day) throws FileNotFoundException {
        File myObj = new File(String.format(PATH_TO_INPUT_FILES, day));
        return new Scanner(myObj);
    }
}
