package aq.michelmann.julian.day07;

import org.apache.commons.lang3.time.StopWatch;
import org.javatuples.Pair;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        
        InputReader inputReader = new InputReader();
        FirstPart firstPart = new FirstPart();
        SecondPart secondPart = new SecondPart();

        Map<String, Pair<Long, List<Pair<Long, String>>>> filesystem = inputReader.getFilesystem("07");
        
        Long resultFirstPart = firstPart.solve(filesystem);

        System.out.println(resultFirstPart);
        
        Long resultSecondPart = secondPart.solve(filesystem);

        System.out.println(resultSecondPart);

        stopwatch.stop();
        long timeTaken = stopwatch.getTime();
        System.out.println(timeTaken);
    }
}
