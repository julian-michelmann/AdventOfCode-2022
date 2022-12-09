package aq.michelmann.julian.day01;

import aq.michelmann.julian.base.InputReaderBase;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader extends InputReaderBase {

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
}
