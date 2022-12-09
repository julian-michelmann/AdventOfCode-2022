package aq.michelmann.julian.day05;

import aq.michelmann.julian.base.InputReaderBase;
import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader extends InputReaderBase {

    public Pair<List<List<String>>, List<Triplet<Integer, Integer, Integer>>> getListOfStackAndInstructions(String day) throws FileNotFoundException {
        Scanner myReader = readFile(day);

        boolean finishedReadingStackInput = false;


        List<String> instructionInputs = new ArrayList<>();
        List<String> stackInputs = new ArrayList<>();

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            if(data.isEmpty()) {
                finishedReadingStackInput = true;
                continue;
            }

            if(finishedReadingStackInput) {
                instructionInputs.add(data);
            } else {
                stackInputs.add(data);
            }
        }

        myReader.close();

        List<List<String>> stacks = new ArrayList<>();

        List<Triplet<Integer, Integer, Integer>> instructions = instructionInputs
                .stream()
                .map(this::convertToInstructionTriple)
                .toList();

        return new Pair<>(stacks, instructions);
    }

    private Triplet<Integer, Integer, Integer> convertToInstructionTriple(String instructionAsString) {
        String[] instructionAsArray = instructionAsString.split(" "); // Example: "move 1 from 2 to 1"

        return new Triplet<>(
                Integer.parseInt(instructionAsArray[1]),
                Integer.parseInt(instructionAsArray[1]),
                Integer.parseInt(instructionAsArray[1])
        );
    }

    private List<List<String>> convertToStackListsList(List<String> verticalStacks) {
        return List.of();
    }
}
