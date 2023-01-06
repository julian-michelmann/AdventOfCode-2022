package aq.michelmann.julian.day09;

import org.javatuples.Pair;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FirstPart {

    private static final String HEAD_MARKER = "h";
    private static final String TAIL_MARKER = "t";

    Map<String, Pair<Integer, Integer>> markers;

    List<List<String>> grid;

    List<String> instructions;

    FirstPart(List<List<String>> grid, Map<String, Pair<Integer, Integer>> markers, List<String> instructions) {
        this.grid = grid;
        this.markers = markers;
        this.instructions = instructions;
    }

    public long solve() {
        instructions.forEach(instruction -> {
            String[] instructionSplitted = instruction.split(" ");
            String direction = instructionSplitted[0];
            Integer times = Integer.valueOf(instructionSplitted[1]);
            executeInstruction(direction, times);
        });
        
        return countTailPositions();
    }

    private void executeInstruction(String direction, Integer times) {
        for (int i = 1; i <= times; i++) {
            markTailPosition();
            moveHead(direction);
            if (areMarkerNotTouching()) {
                moveTail();
            }
        }
        
        markTailPosition();
    }

    void moveHead(String direction) {
        switch (direction) {
            case "R" -> moveMarker(HEAD_MARKER, +1, 0);
            case "L" -> moveMarker(HEAD_MARKER, -1, 0);
            case "D" -> moveMarker(HEAD_MARKER, 0, +1);
            case "U" -> moveMarker(HEAD_MARKER, 0, -1);
            default -> throw new RuntimeException(String.format("Could not find instruction option %s", direction));
        }
    }

    void moveTail() {
        Integer headX = markers.get(HEAD_MARKER).getValue0();
        Integer headY = markers.get(HEAD_MARKER).getValue1();
        Integer tailX = markers.get(TAIL_MARKER).getValue0();
        Integer tailY = markers.get(TAIL_MARKER).getValue1();

        if (headX - tailX < 0) {
            moveMarker(TAIL_MARKER, -1, 0);
        } else if (headX - tailX > 0) {
            moveMarker(TAIL_MARKER, 1, 0);
        }

        if (headY - tailY < 0) {
            moveMarker(TAIL_MARKER, 0, -1);
        } else if (tailY - headY > 0) {
            moveMarker(TAIL_MARKER, 0, 1);
        }
    }

    private void moveMarker(String marker, Integer moveX, Integer moveY) {
        Pair<Integer, Integer> position = markers.get(marker);
        Integer xPosition = position.getValue0();
        Integer yPosition = position.getValue1();

        Pair<Integer, Integer> newMarkerPosition = new Pair<>(xPosition + moveX, yPosition + moveY);

        markers.replace(marker, newMarkerPosition);
    }

    private boolean areMarkerNotTouching() {
        Integer headX = markers.get(HEAD_MARKER).getValue0();
        Integer headY = markers.get(HEAD_MARKER).getValue1();
        Integer tailX = markers.get(TAIL_MARKER).getValue0();
        Integer tailY = markers.get(TAIL_MARKER).getValue1();
        
        int differenceX = Math.abs(headX - tailX);
        int differenceY = Math.abs(tailY - headY);
        
        boolean isOverlapping = isOverlapping(differenceX, differenceY);
        boolean isNextTo = isNextTo(differenceX, differenceY);
        boolean isDiagonally = isDiagonally(differenceX, differenceY);
        
        boolean isTouching =(isOverlapping || isNextTo || isDiagonally);
        
        return  !isTouching; 
    }
    
    private boolean isOverlapping(int differenceX, int differenceY) {
        return differenceX == 0 && differenceY == 0;
    }
    
    private boolean isNextTo(int differenceX, int differenceY) {
        return differenceX == 1 && differenceY == 0 || differenceX == 0 && differenceY == 1;
    }
    private boolean isDiagonally(int differenceX, int differenceY){
        return differenceX == 1 && differenceY == 1;
    }

    private void markTailPosition() {
        Integer tailX = markers.get(TAIL_MARKER).getValue0();
        Integer tailY = markers.get(TAIL_MARKER).getValue1();
        
        grid.get(tailY).set(tailX, "#");
    }
    
    private long countTailPositions() {        
        return grid
                .stream()
                .flatMap(Collection::stream)
                .filter(position -> Objects.equals(position, "#"))
                .count();
    }
}