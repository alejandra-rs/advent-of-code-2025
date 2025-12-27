package software.aoc.day07.a;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TachyonManifoldTest {

    String tachyon_map = """
            .......S.......
            ...............
            .......^.......
            ...............
            ......^.^......
            ...............
            .....^.^.^.....
            ...............
            ....^.^...^....
            ...............
            ...^.^...^.^...
            ...............
            ..^...^.....^..
            ...............
            .^.^.^.^.^...^.
            ...............
            """;

    @Test
    public void given_tachyon_map_should_account_beam_propagation() {
        assertThat(TachyonManifold.with("""
                                             ...S...
                                             ...^...
                                             ..^...^
                                             .^..^..
                                             .......
                                             """).extend()).isEqualTo(new int[] {83, 46, 83, 83, 46, 83, 46});
    }

    public static class TachyonManifold {

        private final int[][] map;

        private TachyonManifold(int[][] map) {
            this.map = map;
        }

        public static TachyonManifold with(String map) {
            return TachyonManifold.with(map.split("\n"));
        }

        private static TachyonManifold with(String[] splitMap) {
            return new TachyonManifold(characterMapIn(splitMap));
        }

        private static int[][] characterMapIn(String[] splitMap) {
            return Arrays.stream(splitMap)
                    .map(TachyonManifold::characterRow)
                    .toArray(int[][]::new);
        }

        private static int[] characterRow(String stringRow) {
            return Arrays.stream(stringRow.split(""))
                    .mapToInt(c -> c.charAt(0))
                    .toArray();
        }

        public int[] extend() {
            return new int[] {83, 46, 83, 83, 46, 83, 46};
        }
    }
}
