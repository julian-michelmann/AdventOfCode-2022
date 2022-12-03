package aq.michelmann.julian.day01;

import java.util.List;

public class SecondPart {
    public String solve(List<List<Long>> input) {
        FirstPart firstPart = new FirstPart();
        List<Long> elvesSortedByCalories = firstPart.orderListOfElvesByCalories(input);

        List<Long> subListOfSortedElves = elvesSortedByCalories.subList(elvesSortedByCalories.size() - 3, elvesSortedByCalories.size());

        return String.valueOf(subListOfSortedElves
                .stream()
                .mapToLong(i -> i)
                .sum());
    }
}
