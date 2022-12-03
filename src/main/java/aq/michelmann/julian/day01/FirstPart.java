package aq.michelmann.julian.day01;

import java.util.List;

public class FirstPart {
    public String solve(List<List<Long>> input) {
        List<Long> elvesSortedByCalories = orderListOfElvesByCalories(input);

        return elvesSortedByCalories.get(elvesSortedByCalories.size() - 1).toString();
    }

    public List<Long> orderListOfElvesByCalories(List<List<Long>> input) {
        return input
                .stream()
                .map(this::sumUpCalories)
                .sorted()
                .toList();
    }

    public Long sumUpCalories(List<Long> elf) {
        return elf
                .stream()
                .mapToLong(i -> i)
                .sum();
    }
}
