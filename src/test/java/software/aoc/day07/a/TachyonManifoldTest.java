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
        assertThat(TachyonManifold.with(tachyon_map).extend()).isEqualTo(new int[] {83, 46, 83, 46, 83, 46, 83, 46, 83, 46, 83, 83, 83, 46, 83});
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
            return extend(0, new Step(map[0], 0)).layer();
        }

        private Step extend(int i, Step step) {
            if (i == map.length - 1) return step;
            return extend(i + 1, propagate(i, step));
        }

        private Step propagate(int i, Step step) {
            return new Step(fillNextLayer(i, step, new int[step.layer().length]),
                     step.nSplits() + splitBeamsIn(i, step.layer()));
        }

        private int[] fillNextLayer(int i, Step step, int[] nextLayer) {
            Arrays.fill(nextLayer, 46);
            IntStream.range(0, nextLayer.length)
                    .filter(j -> step.layer()[j] == 83)
                    .forEach(j -> propagateBeam(i, j, nextLayer));
            return nextLayer;
        }

        private void propagateBeam(int i, int j, int[] nextLayer) {
            if (map[i + 1][j] != 94) {
                nextLayer[j] = 83;
                return;
            }
            nextLayer[j - 1] = nextLayer[j + 1] = 83;
        }

        private int splitBeamsIn(int i, int[] currentLayer) {
            return (int) IntStream.range(0, currentLayer.length)
                    .filter(j -> currentLayer[j] == 83 && map[i+1][j] == 94)
                    .count();
        }
    }

    public record Step(int[] layer, int nSplits) {}
}
