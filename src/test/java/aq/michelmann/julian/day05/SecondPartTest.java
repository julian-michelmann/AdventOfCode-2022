package aq.michelmann.julian.day05;

import org.javatuples.Triplet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SecondPartTest {
    @Test
    void solve() {

        SecondPart secondPart = new SecondPart();

        List<String> firstStack = new ArrayList<>();
        firstStack.add("N");
        firstStack.add("Z");

        List<String> secondStack = new ArrayList<>();
        secondStack.add("D");
        secondStack.add("C");
        secondStack.add("M");

        List<String> thirdStack = new ArrayList<>();
        thirdStack.add("P");

        List<List<String>> stacks = new ArrayList<>();
        stacks.add(firstStack);
        stacks.add(secondStack);
        stacks.add(thirdStack);

        List<Triplet<Integer, Integer, Integer>> instructions = List.of(
                new Triplet<>(1, 2, 1),
                new Triplet<>(3, 1, 3),
                new Triplet<>(2, 2, 1),
                new Triplet<>(1, 1, 2)
        );

        String result = secondPart.solve(stacks, instructions);

        assertEquals("MCD", result);
    }
}