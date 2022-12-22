package aq.michelmann.julian.day08;

import org.javatuples.Pair;

import java.util.Collection;
import java.util.List;

public class FirstPart {
    
            /*
            3 ######
            2 ######
            1 ######
            0 ######
            ^ 012345 < X
            Y
         */

    // Trees<X, Y, isHidden>
    public long solve(List<List<Pair<Integer, Boolean>>> treeGrid) {

        for (int x = 1; x < treeGrid.size() - 1; x++) {
            List<Integer> treeRow = treeGrid.get(x).stream().map(Pair::getValue0).toList();

            for (int y = 1; y < treeRow.size() - 1; y++) {
                List<Integer> treeColumn = getTreeColumn(treeGrid, y);
                boolean isHiddenInRow = isHiddenInLine(y, treeRow);
                boolean isHiddenInColum = isHiddenInLine(x, treeColumn);

                Pair<Integer, Boolean> markedTree = new Pair<>(treeRow.get(y), isHiddenInRow && isHiddenInColum);

                treeGrid.get(x).set(y, markedTree);
            }
        }

        return countAllUnhiddenTrees(treeGrid);
    }

    protected List<Integer> getTreeColumn(List<List<Pair<Integer, Boolean>>> treeGrid, Integer position) {
        return treeGrid
                .stream()
                .map(treeRow -> treeRow.get(position))
                .map(Pair::getValue0)
                .toList();
    }

    private long countAllUnhiddenTrees(List<List<Pair<Integer, Boolean>>> treeGrid) {
        return treeGrid
                .stream()
                .flatMap(Collection::stream)
                .filter(tree -> !tree.getValue1())
                .count();
    }

    private boolean isHiddenInLine(int position, List<Integer> treeLine) {
        Integer treeHeight = treeLine.get(position);
        List<Integer> treesBefore = treeLine.subList(0, position);
        List<Integer> treesAfter = treeLine.subList(position + 1, treeLine.size());

        boolean isHiddenBefore = treesBefore.stream().anyMatch(tree -> tree >= treeHeight);
        boolean isHiddenAfter = treesAfter.stream().anyMatch(tree -> tree >= treeHeight);

        return isHiddenBefore && isHiddenAfter;
    }
}
