package software.aoc.day02.a;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class InvalidIdIdentifier {

    private final List<Range> ranges;

    private InvalidIdIdentifier(List<Range> ranges) {
        this.ranges = ranges;
    }

    public static InvalidIdIdentifier create(String... ranges) {
        return new InvalidIdIdentifier(parsedListOf(ranges));
    }

    private static List<Range> parsedListOf(String[] ranges) {
        return Arrays.stream(ranges)
                .map(InvalidIdIdentifier::rangeOf)
                .toList();
    }

    private static Range rangeOf(String rangeString) {
        return rangeOf(rangeString.split("-"));
    }

    private static Range rangeOf(String[] split) {
        return new Range(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    public int sumInvalid() {
        return ranges.stream()
                .mapToInt(this::sumInvalid)
                .sum();
    }

    private int sumInvalid(Range range) {
        return IntStream.range(range.start(), range.end() + 1)
                .filter(this::isIdInvalid)
                .sum();
    }

    private boolean isIdInvalid(int id) {
        return isIdInvalid(String.valueOf(id));
    }

    private boolean isIdInvalid(String s) {
        return s.matches("^([0-9]+)\1$");
    }
}
