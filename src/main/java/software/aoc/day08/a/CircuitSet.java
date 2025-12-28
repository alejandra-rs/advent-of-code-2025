package software.aoc.day08.a;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class CircuitSet {

    private final List<Set<JunctionBox>> circuits;

    private CircuitSet(List<Set<JunctionBox>> circuits) {
        this.circuits = circuits;
    }

    public static CircuitSet from(JunctionBox... boxes) {
        return new CircuitSet(Arrays.stream(boxes).map(Set::of).toList());
    }

    public List<Set<JunctionBox>> circuits() {
        return circuits;
    }

    public CircuitSet connect(JunctionBox box1, JunctionBox box2) {
        if (circuitWith(box1).equals(circuitWith(box2))) return this;
        return new CircuitSet(mergedCircuitsOf(box1, box2));
    }

    private Set<JunctionBox> circuitWith(JunctionBox box) {
        return circuits.stream().filter(c -> c.contains(box)).findFirst().orElseThrow();
    }

    private List<Set<JunctionBox>> mergedCircuitsOf(JunctionBox box1, JunctionBox box2) {
        return Stream.concat(allCircuitsExcept(box1, box2),
                             mergedCircuitOf(box1, box2)).toList();
    }

    private Stream<Set<JunctionBox>> mergedCircuitOf(JunctionBox box1, JunctionBox box2) {
        return Stream.of(Stream.concat(circuitWith(box1).stream(), circuitWith(box2).stream()).collect(toSet()));
    }

    private Stream<Set<JunctionBox>> allCircuitsExcept(JunctionBox box1, JunctionBox box2) {
        return circuits.stream().filter(c -> c != circuitWith(box1) && c != circuitWith(box2));
    }
}
