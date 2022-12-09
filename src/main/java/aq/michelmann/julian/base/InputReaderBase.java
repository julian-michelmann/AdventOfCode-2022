package aq.michelmann.julian.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class InputReaderBase {

    private static final String PATH_TO_INPUT_FILES = "src/main/java/aq/michelmann/julian/input/input-%s.txt";

    protected Scanner readFile(String day) throws FileNotFoundException {
        File myObj = new File(String.format(PATH_TO_INPUT_FILES, day));
        return new Scanner(myObj);
    }
}
