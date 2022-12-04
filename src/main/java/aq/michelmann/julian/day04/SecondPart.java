package aq.michelmann.julian.day04;

import org.apache.commons.lang3.Range;

public class SecondPart extends FirstPart {

    boolean containsEachOther(Range<Integer> firstElfRange, Range<Integer> secondElfRange) {
        return firstElfRange.isOverlappedBy(secondElfRange);
    }
}
