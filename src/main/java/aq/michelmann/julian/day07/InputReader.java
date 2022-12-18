package aq.michelmann.julian.day07;

import aq.michelmann.julian.base.InputReaderBase;
import org.javatuples.Pair;

import java.io.FileNotFoundException;
import java.util.*;

public class InputReader extends InputReaderBase {


    Map<String, Pair<Long, List<Pair<Long, String>>>> filesystem = new HashMap<>();
    String currentDirectory = "";

    //return Map<DirectoryPath, Pair<DirectorySize, List<Pair<FileName, FileSize>>> 
    Map<String, Pair<Long, List<Pair<Long, String>>>> getFilesystem(String day) throws FileNotFoundException {
        Scanner myReader = readFile(day);

        while (myReader.hasNextLine()) {
            String nextLine = myReader.nextLine();

            if (nextLine.startsWith("$ cd ")) {
                calculateNewDirectory(nextLine);
            } else if (!nextLine.contains("$ ") && !nextLine.contains("dir ")) {
                Pair<Long, String> file = createNewFileFromString(nextLine);
                filesystem.get(currentDirectory).getValue1().add(file);
            }
        }

        myReader.close();
        
        calculateDirectorySizes();

        return filesystem;
    }

    private void calculateDirectorySizes() {
        filesystem.forEach((directoryPath, value) -> {
            
            Long realDirectorySize = filesystem
                    .keySet()
                    .stream()
                    .filter(key -> key.startsWith(directoryPath))
                    .map(key -> filesystem.get(key))
                    .map(Pair::getValue1)
                    .flatMap(List::stream)
                    .map(Pair::getValue0)
                    .mapToLong(i -> i)
                    .sum();
            
            Pair<Long, List<Pair<Long, String>>> directory = filesystem.get(directoryPath).setAt0(realDirectorySize);

            Pair<Long, List<Pair<Long, String>>> directoryWithRealSize = directory.setAt0(realDirectorySize);
            filesystem.replace(directoryPath, directoryWithRealSize);
        });
    }

    private Pair<Long, String> createNewFileFromString(String fileAsString) {
        String[] fileAsArray = fileAsString.split(" ");
        return new Pair<>(Long.parseLong(fileAsArray[0]), fileAsArray[1]);
    }

    private void calculateNewDirectory(String moveCommand) {
        if (Objects.equals(moveCommand, "$ cd /")) {
            currentDirectory = "/";
        } else if (Objects.equals(moveCommand, "$ cd ..")) {
            int indexOfLastSlash = currentDirectory.lastIndexOf('/');
            currentDirectory = currentDirectory.substring(0, indexOfLastSlash);
            if (currentDirectory.length() == 0) {
                currentDirectory = "/";
            }
        } else {
            String newDirectory = moveCommand.replace("$ cd ", "");
            if ("/".equals(currentDirectory.substring(currentDirectory.length() - 1))) {
                currentDirectory += newDirectory;
            } else {
                currentDirectory += "/" + newDirectory;
            }
        }

        boolean pathAlreadyExistsInFileSystem = filesystem.containsKey(currentDirectory);

        if (!pathAlreadyExistsInFileSystem) {
            filesystem.put(currentDirectory, new Pair<>(0L, new ArrayList<>()));
        }
    }
}
