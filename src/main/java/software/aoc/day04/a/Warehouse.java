package software.aoc.day04.a;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Warehouse {

    private static final int MaxAdjacentRolls = 4;
    private final Boolean[][] grid;

    private Warehouse(Boolean[][] grid) {
        this.grid = grid;
    }

    public static Warehouse from(String input) {
        return new Warehouse(diagramWith(input));
    }

    public Stream<Position> rollPositions() {
        return IntStream.range(0, grid.length).boxed()
                .flatMap(this::allPositionsAtRow)
                .filter(this::hasRollAtPosition);
    }

    public boolean isAccessible(Position p) {
        return countAdjacentRolls(p) < MaxAdjacentRolls;
    }

    private boolean hasRollAtPosition(Position p) {
        return grid[p.row()][p.col()];
    }

    private Stream<Position> allPositionsAtRow(Integer row) {
        return IntStream.range(0, grid[row].length)
                .mapToObj(col -> new Position(row, col));
    }

    private long countAdjacentRolls(Position p) {
        return p.neighbors()
                .filter(this::isValid)
                .filter(this::hasRollAtPosition)
                .count();
    }

    private boolean isValid(Position p) {
        return 0 <= p.row() && p.row() < grid.length &&
               0 <= p.col() && p.col() < grid[0].length;
    }

    private static Boolean[][] diagramWith(String grid) {
        return diagramWith(grid.split("\n"));
    }

    private static Boolean[][] diagramWith(String[] split) {
        return Arrays.stream(split)
                .map(Warehouse::convertToBoolArray)
                .toArray(Boolean[][]::new);
    }

    private static Boolean[] convertToBoolArray(String row) {
        return Arrays.stream(row.split(""))
                .map(c -> c.equals("@"))
                .toArray(Boolean[]::new);
    }
}