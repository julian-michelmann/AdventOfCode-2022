package aq.michelmann.julian.day07;

import org.javatuples.Pair;

import java.util.List;
import java.util.Map;

public class SecondPart {

    private static final Long NEEDED_SPACE_FOR_UPDATE = 30000000L;
    private static final Long SPACE_FOR_FILESYSTEM = 70000000L;
    

    //Param Map<DirectoryPath, Pair<DirectorySize, List<Pair<FileName, FileSize>>> 
    public Long solve(Map<String, Pair<Long, List<Pair<Long, String>>>> filesystem) {
        Long missingSpace = calculateMissingSpace(filesystem);
        return findDirectorySizeToDelete(filesystem, missingSpace);
    }

    private Long calculateMissingSpace(Map<String, Pair<Long, List<Pair<Long, String>>>> filesystem) {
        Long usedSpace = filesystem.get("/").getValue0();

        return Math.abs(SPACE_FOR_FILESYSTEM - usedSpace - NEEDED_SPACE_FOR_UPDATE);
    }

    private Long findDirectorySizeToDelete(Map<String, Pair<Long, List<Pair<Long, String>>>> filesystem, Long missingSpace) {
        return filesystem
                .values()
                .stream()
                .map(Pair::getValue0)
                .filter(directorySize -> directorySize >= missingSpace)
                .mapToLong(i -> i)
                .min()
                .getAsLong();
    }
}
