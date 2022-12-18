package aq.michelmann.julian.day07;

import org.javatuples.Pair;

import java.util.List;
import java.util.Map;

public class FirstPart {
    //Param Map<DirectoryPath, Pair<DirectorySize, List<Pair<FileName, FileSize>>> 
    Long solve(Map<String, Pair<Long, List<Pair<Long, String>>>> filesystem) {
        return filesystem
                .values()
                .stream()
                .filter(objects -> objects.getValue0() <= 100000L)
                .map(Pair::getValue0)
                .mapToLong(i -> i)
                .sum();
    }
}
