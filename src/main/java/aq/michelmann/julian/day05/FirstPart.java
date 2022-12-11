package aq.michelmann.julian.day05;

import org.javatuples.Triplet;

import java.util.List;
import java.util.stream.Collectors;

public class FirstPart {

    List<List<String>> crateStacks;

    public String solve(List<List<String>> createdStacks, List<Triplet<Integer, Integer, Integer>> instructions) {
        this.crateStacks = createdStacks;

        instructions
                .forEach(this::executeInstruction);

        return getFirstLayersCreate();
    }

    protected void executeInstruction(Triplet<Integer, Integer, Integer> instruction) {
            List<String> sourceStack = crateStacks.get(instruction.getValue1() - 1);
            List<String> destinationStack = crateStacks.get(instruction.getValue2() - 1);
            
        for (int i = 1; instruction.getValue0() >= i; i++) {
            destinationStack.add(0, sourceStack.remove(0));
        }
    }

    private String getFirstLayersCreate() {
        return crateStacks
                .stream()
                .map(crate -> crate.get(0))
                .collect(Collectors.joining(""));
    }
}
