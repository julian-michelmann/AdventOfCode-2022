package aq.michelmann.julian.day02;

import org.apache.commons.lang3.tuple.Pair;
import org.javatuples.Quartet;

import java.util.List;
import java.util.Objects;

public class FirstPart {

    protected static final String STATUS_WIN = "win";
    protected static final String STATUS_LOOS = "loos";
    protected static final String STATUS_DRAW = "draw";

    protected static final Long POINTS_WINNING_A_GAME = 6L;
    protected static final Long POINTS_DRAW_A_GAME = 3L;
    protected static final Long POINTS_LOOSING_A_GAME = 0L;

    protected static final String ROCK = "X";
    protected static final String PAPER = "Y";
    protected static final String SCISSOR = "Z";

    protected static final String ELVES_ROCK = "A";
    protected static final String ELVES_PAPER = "B";
    protected static final String ELVES_SCISSOR = "C";

    protected static final Long POINTS_ROCK = 1L;
    protected static final Long POINTS_PAPER = 2L;
    protected static final Long POINTS_SCISSOR = 3L;


    protected static final Quartet<String, String, String, Long> ROCK_VS_ELF_ROCK = new Quartet<>(ROCK, ELVES_ROCK, STATUS_DRAW, POINTS_DRAW_A_GAME + POINTS_ROCK);
    protected static final Quartet<String, String, String, Long> ROCK_VS_ELF_PAPER = new Quartet<>(ROCK, ELVES_PAPER, STATUS_LOOS, POINTS_LOOSING_A_GAME + POINTS_ROCK);
    protected static final Quartet<String, String, String, Long> ROCK_VS_ELF_SCISSOR = new Quartet<>(ROCK, ELVES_SCISSOR, STATUS_WIN, POINTS_WINNING_A_GAME + POINTS_ROCK);

    protected static final Quartet<String, String, String, Long> PAPER_VS_ELF_ROCK = new Quartet<>(PAPER, ELVES_ROCK, STATUS_WIN, POINTS_WINNING_A_GAME + POINTS_PAPER);
    protected static final Quartet<String, String, String, Long> PAPER_VS_ELF_PAPER = new Quartet<>(PAPER, ELVES_PAPER, STATUS_DRAW, POINTS_DRAW_A_GAME + POINTS_PAPER);
    protected static final Quartet<String, String, String, Long> PAPER_VS_ELF_SCISSOR = new Quartet<>(PAPER, ELVES_SCISSOR, STATUS_LOOS, POINTS_LOOSING_A_GAME + POINTS_PAPER);

    protected static final Quartet<String, String, String, Long> SCISSOR_VS_ELF_ROCK = new Quartet<>(SCISSOR, ELVES_ROCK, STATUS_LOOS, POINTS_LOOSING_A_GAME + POINTS_SCISSOR);
    protected static final Quartet<String, String, String, Long> SCISSOR_VS_ELF_PAPER = new Quartet<>(SCISSOR, ELVES_PAPER, STATUS_WIN, POINTS_WINNING_A_GAME + POINTS_SCISSOR);
    protected static final Quartet<String, String, String, Long> SCISSOR_VS_ELF_SCISSOR = new Quartet<>(SCISSOR, ELVES_SCISSOR, STATUS_DRAW, POINTS_DRAW_A_GAME + POINTS_SCISSOR);

    List<Quartet<String, String, String, Long>> ruleBook = List.of(
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

    protected Long match(String playedShapeByElf, String playedShape) {

        return ruleBook
                .stream()
                .filter(rule -> Objects.equals(rule.getValue1(), playedShapeByElf))
                .filter(rule -> Objects.equals(rule.getValue0(), playedShape))
                .findFirst()
                .get()
                .getValue3();
    }
}
