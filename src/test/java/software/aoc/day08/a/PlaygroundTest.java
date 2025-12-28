package software.aoc.day08.a;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

public class PlaygroundTest {

    String inputBoxes = """    
                        162,817,812
                        57,618,57
                        906,360,560
                        592,479,940
                        352,342,300
                        466,668,158
                        542,29,236
                        431,825,988
                        739,650,466
                        52,470,668
                        216,146,977
                        819,987,18
                        117,168,530
                        805,96,715
                        346,949,466
                        970,615,88
                        941,993,340
                        862,61,35
                        984,92,344
                        425,690,689
                        """;

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
        assertThat(Playground.with(parseInputIn(inputBoxes)).multiplyLargestCircuits(10)).isEqualTo(40);
    }

    private List<JunctionBox> parseInputIn(String inputBoxes) {
        return parseInputIn(inputBoxes.split("\n"));
    }

    private List<JunctionBox> parseInputIn(String[] split) {
        return Arrays.stream(split)
                .map(this::boxIn)
                .toList();
    }

    private JunctionBox boxIn(String s) {
        return boxIn(s.split(","));
    }

    private JunctionBox boxIn(String[] split) {
        return new JunctionBox(parseInt(split[0]), parseInt(split[1]), parseInt(split[2]));
    }


}
