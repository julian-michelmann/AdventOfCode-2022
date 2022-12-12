package aq.michelmann.julian.day06;

import org.apache.commons.lang3.StringUtils;

public class CommunicationSystem {

    static final int MARKER_LENGTH = 4;
    static final int MESSAGE_LENGTH = 14;

    public Integer findEndOfFirstMessageAsIndex(String dataStream) {
        return findPackageEndAsIndex(dataStream, MESSAGE_LENGTH);
    }

    public Integer findEndOfFirstMarkerAsIndex(String dataStream) {
        return findPackageEndAsIndex(dataStream, MARKER_LENGTH);
    }

    private Integer findPackageEndAsIndex(String dataStream, int packageLength) {
        for (int i = 0; i < dataStream.length(); i++) {
            String dataPossibleStreamPackage = dataStream.substring(i, i + packageLength);

            if (isValidPackage(dataPossibleStreamPackage)) {
                return i + packageLength;
            }
        }

        return null;
    }

    private boolean isValidPackage(String possibleMarker) {
        for (int i = 0; i < possibleMarker.length(); i++) {
            int amountOfMatches = StringUtils.countMatches(possibleMarker, possibleMarker.charAt(i));

            if (2 <= amountOfMatches) {
                return false;
            }
        }

        return true;
    }
}
