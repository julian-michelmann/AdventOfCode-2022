package aq.michelmann.julian.day08;

import org.javatuples.Pair;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        FirstPart firstPart = new FirstPart();
        SecondPart secondPart = new SecondPart();

        List<List<Pair<Integer, Integer>>> treeGrid = inputReader.getIntegerGrid("08");
        
        Long resultFirstPart = firstPart.solve(treeGrid);
        
        System.out.println(resultFirstPart);


        List<List<Pair<Integer, Integer>>> treeGrid2 = inputReader.getIntegerGrid("08");
        Integer resultSecondPart = secondPart.solve(treeGrid2);
        
        System.out.println(resultSecondPart);
    }
}
