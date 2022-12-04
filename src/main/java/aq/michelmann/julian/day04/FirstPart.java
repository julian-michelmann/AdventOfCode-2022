package aq.michelmann.julian.day04;

import org.apache.commons.lang3.Range;
import org.javatuples.Pair;

import java.util.List;

public class FirstPart {

    int solve(List<Pair<Range<Integer>, Range<Integer>>> elfPairs) {
        return elfPairs
                .stream()
                .filter(elfPair -> fullyContainsEachOther(elfPair.getValue0(), elfPair.getValue1()))
                .toList()
                .size();
    }

    boolean fullyContainsEachOther(Range<Integer> firstElfRange, Range<Integer> secondElfRange) {
        return firstElfRange.containsRange(secondElfRange) || secondElfRange.containsRange(firstElfRange);
    }
}
