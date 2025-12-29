package software.aoc.day08.b;

import software.aoc.day08.JunctionBox;
import software.aoc.day08.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparingDouble;

public class Playground {

    private final List<JunctionBox> boxes;

    private Playground(List<JunctionBox> boxes) {
        this.boxes = boxes;
    }

    public static Playground with(String boxes) {
        return new Playground(listWith(boxes));
    }

    private static List<JunctionBox> listWith(String boxes) {
        return Arrays.stream(boxes.split("\n")).map(JunctionBox::from).toList();
    }

    public int lastConnectedBoxes() {
        return multipliedXCoordinatesIn(unifiedCircuitSet());
    }

    private int multipliedXCoordinatesIn(CircuitSet circuitSet) {
        return circuitSet.lastConnectedBoxAt(0).x() * circuitSet.lastConnectedBoxAt(1).x();
    }

    private CircuitSet unifiedCircuitSet() {
        return allBoxWirings()
                    .reduce(CircuitSet.from(boxes.stream()),
                            (c, p) -> c.connect(p.box1(), p.box2()),
                            (a, _) -> a);
    }

    private Stream<Pair> allBoxWirings() {
        return IntStream.range(0, boxes.size()).boxed()
                .flatMap(this::makePairsWithBoxAtIndex)
                .sorted(comparingDouble(Pair::distance));
    }

    private Stream<Pair> makePairsWithBoxAtIndex(Integer i) {
        return IntStream.range(i + 1, boxes.size())
                        .mapToObj(j -> Pair.of(boxes.get(i), boxes.get(j)));
    }
}
