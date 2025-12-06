package software.aoc.day02.a;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RangeTest {

    @Test
    public void given_id_ranges_should_sum_invalid_ids() {
        assertThat(InvalidIdIdentifier.create("10-20").sumInvalid()).isEqualTo(11);
        assertThat(InvalidIdIdentifier.create("11-22").sumInvalid()).isEqualTo(33);
    }

    public static class InvalidIdIdentifier {

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

    public record Range(int start, int end) {}
}
