package aq.michelmann.julian.util;


import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

    public List<Pair<String, String>> getListOfStringPairs(String day) throws FileNotFoundException {
        List<Pair<String, String>> resultList = new ArrayList<>();

        Scanner myReader = readFile(day);

        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().split(" ");
            resultList.add(new MutablePair<>(data[0], data[1]));
        }

        return resultList;
    }

    private Scanner  readFile(String day) throws FileNotFoundException {
        File myObj = new File(String.format(PATH_TO_INPUT_FILES, day));
        return new Scanner(myObj);
    }
}
