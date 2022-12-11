package aq.michelmann.julian.day05;

import org.javatuples.Triplet;

import java.util.List;

public class SecondPart extends FirstPart{

    @Override
    protected void executeInstruction(Triplet<Integer, Integer, Integer> instruction) {
        List<String> sourceStack = crateStacks.get(instruction.getValue1() - 1);
        List<String> destinationStack = crateStacks.get(instruction.getValue2() - 1);

        for (int i = instruction.getValue0(); i >= 1; i--) {
            destinationStack.add(0, sourceStack.remove(i - 1));
        }
    }
}
