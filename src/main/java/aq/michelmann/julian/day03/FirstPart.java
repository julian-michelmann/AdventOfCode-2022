package aq.michelmann.julian.day03;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstPart {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String ELF_ITEMS_AS_STRING = ALPHABET + ALPHABET.toUpperCase();

    protected static final List<String> ELF_ITEMS = new ArrayList<>(Arrays.asList(ELF_ITEMS_AS_STRING.split("")));


    Long solve(List<Pair<String, String>> rucksacks) {

        return rucksacks
                .stream()
                .map(compartments -> analyzePriorityForRucksack(compartments.getValue0(), compartments.getValue1()))
                .mapToLong(i -> i)
                .sum();
    }

    Long analyzePriorityForRucksack(String firstCompartment, String secondCompartment) {

        return Long.valueOf(ELF_ITEMS
                .stream()
                .filter(firstCompartment::contains)
                .filter(secondCompartment::contains)
                .map(item -> ELF_ITEMS.indexOf(item) + 1) // Priority for item is position + 1
                .findFirst()
                .get());
    }
}
