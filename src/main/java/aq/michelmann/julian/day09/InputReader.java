package aq.michelmann.julian.day09;

import aq.michelmann.julian.base.InputReaderBase;
import aq.michelmann.julian.base.InputReaderException;
import lombok.Getter;
import org.javatuples.Pair;

import java.io.FileNotFoundException;
import java.util.*;

public class InputReader extends InputReaderBase {

    @Getter
    private List<List<String>> grid = new ArrayList<>();

    @Getter
    private List<String> instructions = new ArrayList<>();

    @Getter
    private Map<String, Pair<Integer, Integer>> marks =  new HashMap<>();
    
    private int spaceRight = 0;
    private int spaceLeft = 0;
    private int spaceUp = 0;
    private int spaceDown = 0;

    public InputReader(String day) throws FileNotFoundException {
        getInstructionLines(day);
        calculateSpaceNeededForGrid();
        renderGrid();
        settingStartingMarks();
    }

    private void calculateSpaceNeededForGrid() {
        for (String instruction : instructions) {
            String[] partsOfInstruction = instruction.split(" ");
            String direction = partsOfInstruction[0];
            int times = Integer.parseInt(partsOfInstruction[1]);

            switch (direction) {
                case "R" -> spaceRight += times;
                case "L" -> spaceLeft += times;
                case "U" -> spaceUp += times;
                case "D" -> spaceDown += times;
                default ->
                        throw new InputReaderException(String.format("Instruction option %s is not existing", direction));
            }
        }
    }

    private void renderGrid() {
        int xLength = spaceRight + spaceLeft;
        int yLength = spaceUp + spaceDown;

        List<String> xLine = new ArrayList<>();
        for (int i = 0; i <= xLength; i++) {
            xLine.add(".");
        }

        for (int i = 0; i <= yLength; i++) {
            grid.add(new ArrayList<>(xLine));
        }
    }
    
    /*
    1l 3r 
    
    4
    3
    2
    1
    0 1 2 3 4 
     */

    private void settingStartingMarks() {
        marks.put("s", new Pair<>(spaceLeft, spaceUp));
        marks.put("h", new Pair<>(spaceLeft, spaceUp));
        marks.put("t", new Pair<>(spaceLeft, spaceUp));
    }

    private void getInstructionLines(String day) throws FileNotFoundException {
        Scanner myReader = readFile(day);

        while (myReader.hasNextLine()) {
            instructions.add(myReader.nextLine());
        }
        myReader.close();
    }
}
