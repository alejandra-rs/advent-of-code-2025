package software.aoc.day04.a;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MyTest {


    @Test
    public void name() {
        ForkliftManager.with("""
··@@·@··
·@·@@···
··@@··@·
""");
    }

    public static class ForkliftManager {

        private final Object[] grid;

        private ForkliftManager(Object[] grid) {
            // TODO: transform Object[] into int[][], somehow
            this.grid = grid;
            System.out.println(Arrays.deepToString(grid));
        }

        public static ForkliftManager with(String grid) {
            return new ForkliftManager(diagramWith(grid));
        }

        private static Object[] diagramWith(String grid) {
            return diagramWith(grid.split("\n"));
        }

        private static Object[] diagramWith(String[] split) {
            return Arrays.stream(split)
                    .map(ForkliftManager::convertToIntArray)
                    .toArray();
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
                    .map(i -> streamOf(i)).sum();
        }

        private int streamOf(int i) {
            return i;
        }

    }

}
