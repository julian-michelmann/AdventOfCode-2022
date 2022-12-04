package aq.michelmann.julian.day03;

import org.javatuples.Triplet;

import java.util.List;

import static aq.michelmann.julian.day03.FirstPart.ELF_ITEMS;

public class SecondPart {


    Long solve(List<Triplet<String, String, String>> rucksackTriples) {
        return rucksackTriples
                .stream()
                .map(rucksackTriple -> analyzePriorityRucksackTripel(rucksackTriple.getValue0(), rucksackTriple.getValue1(), rucksackTriple.getValue2()))
                .mapToLong(i -> i)
                .sum();
    }

    Long analyzePriorityRucksackTripel(String rucksack1, String rucksack2, String rucksack3) {
        return Long.valueOf(ELF_ITEMS
                .stream()
                .filter(rucksack1::contains)
                .filter(rucksack2::contains)
                .filter(rucksack3::contains)
                .map(item -> ELF_ITEMS.indexOf(item) + 1) // Priority for item is position + 1
                .findFirst()
                .get());
    }
}
