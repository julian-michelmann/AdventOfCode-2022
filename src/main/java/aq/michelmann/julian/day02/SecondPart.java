package aq.michelmann.julian.day02;

import java.util.HashMap;

public class SecondPart extends FirstPart {

    HashMap<String, String> instructionMap = createMap();

    private static HashMap<String, String> createMap() {
        HashMap<String, String> instructionMap = new HashMap<String, String>();
        instructionMap.put("X", STATUS_LOOS);
        instructionMap.put("Y", STATUS_DRAW);
        instructionMap.put("Z", STATUS_WIN);
        return instructionMap;
    }

    protected Long match(String playedShapeByElf, String instruction) {
        
        String shouldPlay = instructionMap.get(instruction);

        return ruleBook
                .stream()
                .filter(rule -> rule.getValue1().equals(playedShapeByElf))
                .filter(rule -> rule.getValue2().equals(shouldPlay))
                .findFirst()
                .get()
                .getValue3();
    }
}
