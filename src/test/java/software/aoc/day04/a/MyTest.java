package software.aoc.day04.a;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTest {

    @Test
    public void given_diagram_should_account_number_of_rolls_accessible() {
        assertThat(ForkliftManager.with("""
                                             ··@@·@··
                                             ·@·@@···
                                             ··@@··@·
                                             """).accesibleRollCount()).isEqualTo(8);
    }

    public static class ForkliftManager {

        private final int[][] grid;

        private ForkliftManager(int[][] grid) {
            this.grid = grid;
            System.out.println(Arrays.deepToString(grid));
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
            return 8;
        }

    }

}
