package aq.michelmann.julian.day02;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;
import java.util.Objects;

public class FirstPart {

    private static final Long POINTS_WINNING_A_GAME = 6L;
    private static final Long POINTS_DRAW_A_GAME = 3L;
    private static final Long POINTS_LOOSING_A_GAME = 0L;

    private static final String ROCK = "X";
    private static final String PAPER = "Y";
    private static final String SCISSOR = "Z";

    private static final String ELVES_ROCK = "A";
    private static final String ELVES_PAPER = "B";
    private static final String ELVES_SCISSOR = "C";

    private static final Long POINTS_ROCK = 1L;
    private static final Long POINTS_PAPER = 2L;
    private static final Long POINTS_SCISSOR = 3L;


    private static final Triple<String, String, Long> ROCK_VS_ELF_ROCK = new ImmutableTriple<>(ROCK, ELVES_ROCK, POINTS_DRAW_A_GAME + POINTS_ROCK);
    private static final Triple<String, String, Long> ROCK_VS_ELF_PAPER = new ImmutableTriple<>(ROCK, ELVES_PAPER, POINTS_LOOSING_A_GAME + POINTS_ROCK);
    private static final Triple<String, String, Long> ROCK_VS_ELF_SCISSOR = new ImmutableTriple<>(ROCK, ELVES_SCISSOR, POINTS_WINNING_A_GAME + POINTS_ROCK);

    private static final Triple<String, String, Long> PAPER_VS_ELF_ROCK = new ImmutableTriple<>(PAPER, ELVES_ROCK, POINTS_WINNING_A_GAME + POINTS_PAPER);
    private static final Triple<String, String, Long> PAPER_VS_ELF_PAPER = new ImmutableTriple<>(PAPER, ELVES_PAPER, POINTS_DRAW_A_GAME + POINTS_PAPER);
    private static final Triple<String, String, Long> PAPER_VS_ELF_SCISSOR = new ImmutableTriple<>(PAPER, ELVES_SCISSOR, POINTS_LOOSING_A_GAME + POINTS_PAPER);

    private static final Triple<String, String, Long> SCISSOR_VS_ELF_ROCK = new ImmutableTriple<>(SCISSOR, ELVES_ROCK, POINTS_LOOSING_A_GAME + POINTS_SCISSOR);
    private static final Triple<String, String, Long> SCISSOR_VS_ELF_PAPER = new ImmutableTriple<>(SCISSOR, ELVES_PAPER, POINTS_WINNING_A_GAME + POINTS_SCISSOR);
    private static final Triple<String, String, Long> SCISSOR_VS_ELF_SCISSOR = new ImmutableTriple<>(SCISSOR, ELVES_SCISSOR, POINTS_DRAW_A_GAME + POINTS_SCISSOR);

    List<Triple<String, String, Long>> ruleBook = List.of(
            ROCK_VS_ELF_ROCK,
            ROCK_VS_ELF_PAPER,
            ROCK_VS_ELF_SCISSOR,
            PAPER_VS_ELF_ROCK,
            PAPER_VS_ELF_PAPER,
            PAPER_VS_ELF_SCISSOR,
            SCISSOR_VS_ELF_ROCK,
            SCISSOR_VS_ELF_PAPER,
            SCISSOR_VS_ELF_SCISSOR
    );


    public Long solve(List<Pair<String, String>> input) {

        return input
                .stream()
                .map(match -> match(match.getLeft(), match.getRight()))
                .filter(points -> points > 0 && points < 10)
                .mapToLong(i -> i)
                .sum();
    }

    private Long match(String playedShape, String playedShapeByElf) {

        return ruleBook
                .stream()
                .filter(rule -> Objects.equals(rule.getMiddle(), playedShape))
                .filter(rule -> Objects.equals(rule.getLeft(), playedShapeByElf))
                .findFirst()
                .get()
                .getRight();
    }
}
