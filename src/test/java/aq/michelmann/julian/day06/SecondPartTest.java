package aq.michelmann.julian.day06;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondPartTest {

    @ParameterizedTest
    @CsvSource(value = {
            "mjqjpqmgbljsphdztnvjfqwrcgsmlb,19",
            "bvwbjplbgvbhsrlpgdmjqwftvncz,23",
            "nppdvjthqldpwncqszvftbrmjlhg,23",
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg,29",
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw,26"
    })
    void solve(String dataStream, Integer expectedResult) {
        SecondPart secondPart = new SecondPart();

        int result = secondPart.solve(dataStream);

        assertEquals(expectedResult, result);
    }

}