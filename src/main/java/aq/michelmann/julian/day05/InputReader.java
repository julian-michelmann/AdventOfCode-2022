package aq.michelmann.julian.day05;

import aq.michelmann.julian.base.InputReaderBase;
import org.javatuples.Triplet;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader extends InputReaderBase {
    
    public List<Triplet<Integer, Integer, Integer>> getListOfInstructionTriples(String day) throws FileNotFoundException {
        List<Triplet<Integer, Integer, Integer>> instruction = new ArrayList<>();
        Scanner myReader = readFile(day);

        while (myReader.hasNextLine()) {
            String inputLine = myReader.nextLine();

            if(inputLine.contains("move")) {
                instruction.add(convertToInstructionTriple(inputLine));
            }
        }
        
        myReader.close();
        
        return instruction;
    }

    private Triplet<Integer, Integer, Integer> convertToInstructionTriple(String instructionAsString) {
        String[] instructionAsArray = instructionAsString.split(" "); // Example: "move 1 from 2 to 1"

        return new Triplet<>(
                Integer.parseInt(instructionAsArray[1]),
                Integer.parseInt(instructionAsArray[3]),
                Integer.parseInt(instructionAsArray[5])
        );
    }
    
    public List<List<String>> getStacksOfItems(String day) throws FileNotFoundException {
        List<List<String>> stacks = new ArrayList<>();
        Scanner myReader = readFile(day);
        
        List<String> itemRows = new ArrayList<>();

        while (myReader.hasNextLine()) {
            String itemRow = myReader.nextLine();
            if(itemRow.contains("[")) {
                itemRows.add(getListOfItemsByRow(itemRow));
            }
        }

        int neededStacks = itemRows.get(0).length();
        while (stacks.size() < neededStacks) {
            stacks.add(new ArrayList<>());
        }

        itemRows.forEach(itemRow -> {
            for (int i = 0; i < itemRow.length(); i++) {
                String item = String.valueOf(itemRow.charAt(i));
                
                if(!item.isBlank()) {
                    stacks.get(i).add(item);
                }
            }
        });

        myReader.close();

        return stacks;
    }

    private String getListOfItemsByRow(String rowOfItems) {
        StringBuilder listOfItemsInARow = new StringBuilder();
        
        String[] itemStrings = rowOfItems.split("(?<=\\G.{4})");

        for (String itemString : itemStrings) {
            listOfItemsInARow.append(itemString.charAt(1));
        }
        
        return listOfItemsInARow.toString();
    }
}
