package software.aoc.day08.a;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparingDouble;

public class Playground {

    private final List<JunctionBox> boxes;

    private Playground(List<JunctionBox> boxes) {
        this.boxes = boxes;
    }

    public static Playground with(List<JunctionBox> boxes) {
        return new Playground(boxes);
    }

    private CircuitSet circuitSetWith(int nConnections) {
        return buildAllPairs()
                    .limit(nConnections)
                    .reduce(CircuitSet.from(boxes.toArray(JunctionBox[]::new)),
                            (c, p) -> c.connect(p.box1(), p.box2()),
                            (a, _) -> a);
    }

    public int multiplyLargestCircuits(int nConnections) {
        return circuitSetWith(nConnections).circuits().stream()
                        .map(Set::size)
                        .sorted(reverseOrder())
                        .limit(3)
                        .reduce((a, b) -> a * b).orElseThrow();
    }

    private Stream<Pair> buildAllPairs() {
        return IntStream.range(0, boxes.size()).boxed()
                .flatMap(this::makePairsWithBoxAtIndex)
                .sorted(comparingDouble(Pair::distance));
    }

    private Stream<Pair> makePairsWithBoxAtIndex(Integer i) {
        return IntStream.range(i + 1, boxes.size())
                        .mapToObj(j -> Pair.of(boxes.get(i), boxes.get(j)));
    }
}
