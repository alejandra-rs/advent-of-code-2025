package software.aoc.day01.b;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Dial {

    private static final int INITIAL_POSITION = 50;
    private static final int DIAL_SIZE = 100;

    private final List<Rotation> rotations;

    private Dial(List<Rotation> rotations) {
        this.rotations = rotations;
    }

    public static Dial create() {
        return new Dial(List.of());
    }

    public Dial execute(String orders) {
        return add(orders.split("\n"));
    }

    public Dial add(String... orders) {
        return new Dial(Arrays.stream(orders)
                              .map(Rotation::from)
                              .toList());
    }

    public int count() {
        return IntStream.range(0, rotations.size())
                .map(this::crossedZeroAtIndex)
                .sum();
    }

    private int crossedZeroAtIndex(int i) {
        return rotations.get(i).crossingsFrom(sumPartial(i));
    }

    private int sumPartial(int size) {
        return normalize(sum(rotations.stream().limit(size)));
    }

    private static int sum(Stream<Rotation> orders) {
        return orders.mapToInt(Rotation::step).sum() + INITIAL_POSITION;
    }

    private int normalize(int value) {
        return ((value < 0 ? DIAL_SIZE : 0) + value % DIAL_SIZE) % DIAL_SIZE;
    }
}
