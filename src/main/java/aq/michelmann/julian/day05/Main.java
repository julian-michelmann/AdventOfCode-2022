package aq.michelmann.julian.day05;

import org.javatuples.Triplet;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        FirstPart firstPart = new FirstPart();
        
        List<List<String>> stacks = inputReader.getStacksOfItems("05");
        List<Triplet<Integer, Integer, Integer>> instructions = inputReader.getListOfInstructionTriples("05");
        
        String resultFirstPart = firstPart.solve(new ArrayList<>(stacks), new ArrayList<>(instructions));
        
        System.out.println(resultFirstPart);
        
        stacks = inputReader.getStacksOfItems("05");
        instructions = inputReader.getListOfInstructionTriples("05");
        
        SecondPart secondPart = new SecondPart();
        String resultSecondPart = secondPart.solve(new ArrayList<>(stacks), new ArrayList<>(instructions));

        System.out.println(resultSecondPart);
    }
}
