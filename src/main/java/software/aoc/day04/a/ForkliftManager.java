package software.aoc.day04.a;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ForkliftManager {

    private final int[][] grid;

    private ForkliftManager(int[][] grid) {
        this.grid = grid;
    }

    public static ForkliftManager with(String grid) {
        return new ForkliftManager(diagramWith(grid));
    }

    private static int[][] diagramWith(String grid) {
        return diagramWith(grid.split("\n"));
    }

    private static int[][] diagramWith(String[] split) {
        return Arrays.stream(split)
                .map(ForkliftManager::convertToIntArray)
                .toArray(int[][]::new);
    }

    private static int[] convertToIntArray(String row) {
        return Arrays.stream(row.split(""))
                .mapToInt(ForkliftManager::convertToInt)
                .toArray();
    }

    private static int convertToInt(String c) {
        return c.equals("@") ? 1 : 0;
    }

    public int accesibleRollCount() {
        return IntStream.range(0, grid.length)
                .map(this::rollCountInRow)
                .sum();
    }

    private int rollCountInRow(int i) {
        return (int) IntStream.range(0, grid[i].length)
                .filter(j -> grid[i][j] == 1)
                .map(j -> countAdjacentRollsInPosition(i, j))
                .filter(n -> n < 4)
                .count();
    }

    private int countAdjacentRollsInPosition(int i, int j) {
        return validAdjacentPositions(i, j)
                .mapToInt(p -> grid[p[0]][p[1]])
                .sum();
    }

    private Stream<int[]> validAdjacentPositions(int i, int j) {
        return IntStream.range(-1, 2)
                .boxed()
                .flatMap(dr -> getColumnStreamWith(i, j, dr))
                .filter(pos -> !isCenter(pos, i, j))
                .filter(this::isInsideGrid);
    }

    private static Stream<int[]> getColumnStreamWith(int rowCenter, int colCenter, int diffRow) {
        return IntStream.rangeClosed(-1, 1)
                .mapToObj(diffCol -> new int[]{rowCenter + diffRow, colCenter + diffCol});
    }

    private boolean isCenter(int[] pos, int i, int j) {
        return pos[0] == i && pos[1] == j;
    }

    private boolean isInsideGrid(int[] pos) {
        return rowIsValid(pos[0]) && colIsValid(pos[1]);
    }

    private boolean rowIsValid(int posRow) {
        return 0 <= posRow && posRow < grid.length;
    }

    private boolean colIsValid(int posCol) {
        return 0 <= posCol && posCol < grid[0].length;
    }
}
