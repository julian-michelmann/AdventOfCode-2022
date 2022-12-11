package aq.michelmann.julian.day05;

import org.javatuples.Triplet;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        FirstPart firstPart = new FirstPart();
        
        List<List<String>> stacks = inputReader.getStacksOfItems("05");
        List<Triplet<Integer, Integer, Integer>> instructions = inputReader.getListOfInstructionTriples("05");
        
        String result = firstPart.solve(stacks, instructions);
        
        System.out.println(result);
    }
}
