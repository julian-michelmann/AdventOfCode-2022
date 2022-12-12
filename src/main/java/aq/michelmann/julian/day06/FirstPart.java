package aq.michelmann.julian.day06;

import org.apache.commons.lang3.StringUtils;

public class FirstPart {
    
    protected int markerLength;
    
    FirstPart() {
        markerLength = 4; 
    }

    FirstPart(int markerLength) {
        this.markerLength = markerLength;
    }
    
    public Integer solve(String dataStream) {

        for (int i = 0; i < dataStream.length(); i++) {
            String possibleMarker = dataStream.substring(i, i + markerLength);

            if (isMarker(possibleMarker)) {
                return i + markerLength;
            }
        }

        return null;
    }

    private boolean isMarker(String possibleMarker) {
        for (int i = 0; i < possibleMarker.length(); i++) {
            int amountOfMatches = StringUtils.countMatches(possibleMarker, possibleMarker.charAt(i));

            if (2 <= amountOfMatches) {
                return false;
            }
        }

        return true;
    }
}
