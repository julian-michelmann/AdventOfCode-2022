package aq.michelmann.julian.day03;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstPart {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String elfItemsAsString = alphabet + alphabet.toUpperCase();

    List<String> elfItems = new ArrayList<>(Arrays.asList(elfItemsAsString.split("")));


    Long solve(List<Pair<String, String>> rucksacks) {

        return rucksacks
                .stream()
                .map(compartments -> analyzePriorityForRucksack(compartments.getValue0(), compartments.getValue1()))
                .mapToLong(i -> i)
                .sum();
    }

    Long analyzePriorityForRucksack(String firstCompartment, String secondCompartment) {

        return Long.valueOf(elfItems
                .stream()
                .filter(firstCompartment::contains)
                .filter(secondCompartment::contains)
                .map(item -> elfItems.indexOf(item) + 1) // Priority for item is position + 1
                .findFirst()
                .get());
    }
}
