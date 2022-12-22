package aq.michelmann.julian.day08;

import org.javatuples.Pair;

import java.util.Collection;
import java.util.List;

public class SecondPart {

    public Integer solve(List<List<Pair<Integer, Integer>>> treeGrid) {

        for (int x = 1; x < treeGrid.size() - 1; x++) {
            List<Integer> treeRow = treeGrid.get(x).stream().map(Pair::getValue0).toList();

            for (int y = 1; y < treeRow.size() - 1; y++) {
                List<Integer> treeColumn = getTreeColumn(treeGrid, y);
                Integer isHiddenInRow = calculateScenicScoreForOneLine(y, treeRow);
                Integer isHiddenInColum = calculateScenicScoreForOneLine(x, treeColumn);
                
                Pair<Integer, Integer> markedTree = new Pair<>(treeRow.get(y), isHiddenInRow * isHiddenInColum);

                treeGrid.get(x).set(y, markedTree);
            }
        }

        return findTreeWithHighestScenicScore(treeGrid);
    }

    private Integer findTreeWithHighestScenicScore(List<List<Pair<Integer, Integer>>> treeGrid) {
        return treeGrid
                .stream()
                .flatMap(Collection::stream)
                .map(Pair::getValue1)
                .mapToInt(i -> i)
                .max()
                .getAsInt();
    }


    private Integer calculateScenicScoreForOneLine(int position, List<Integer> treeLine) {
        Integer treeHeight = treeLine.get(position);
        Integer treeScoreBeforeTree = 0;
        Integer treeScoreBehindTree = 0;
        
        for (int i = position - 1; i >= 0; i--) {
            treeScoreBeforeTree++;
            Integer heightOfNextTreeInLine = treeLine.get(i);
            if (heightOfNextTreeInLine >= treeHeight) {
                break;
            }
        }
        
        for (int i = position + 1; i < treeLine.size(); i++) {
            treeScoreBehindTree++;
            Integer heightOfNextTreeInLine = treeLine.get(i);
            if (heightOfNextTreeInLine >= treeHeight) {
                break;
            }
            
        }


        return treeScoreBeforeTree * treeScoreBehindTree;
    }

    private List<Integer> getTreeColumn(List<List<Pair<Integer, Integer>>> treeGrid, Integer position) {
        return treeGrid
                .stream()
                .map(treeRow -> treeRow.get(position))
                .map(Pair::getValue0)
                .toList();
    }
}