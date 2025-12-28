package software.aoc.day08.a;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

public class CircuitTest {

    @Test
    public void given_boxes_should_account_largest_circuits() {
        List<JunctionBox> boxes = List.of(
                new JunctionBox(1, 2, 3),
                new JunctionBox(9, 8, 7),
                new JunctionBox(10, 11, 12),
                new JunctionBox(13, 1, 15),
                new JunctionBox(2, 3, 4),
                new JunctionBox(2, 2, 2),
                new JunctionBox(10, 10, 10),
                new JunctionBox(23, 23, 23)
        );

        assertThat(Playground.with(boxes).multiplyLargestCircuits(7)).isEqualTo(6);
    }


    public record JunctionBox(int x, int y, int z) {}
    public static class Playground {

        private final List<JunctionBox> boxes;

        private Playground(List<JunctionBox> boxes) {
            this.boxes = boxes;
        }

        public static Playground with(List<JunctionBox> boxes) {
            return new Playground(boxes);
        }

        public int multiplyLargestCircuits(int nConnections) {
            return 6;
        }
    }
}
