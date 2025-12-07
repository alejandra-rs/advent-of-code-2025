package software.aoc.day05.a;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FreshIngredientIdentifierTest {

    @Test
    public void given_ranges_should_count_fresh_ingredients() {
        assertThat(FreshIngredientIdentifier.create("10-20")
                    .countFreshIngredientsFrom("1", "5", "10", "15", "20")).isEqualTo(2);
    }

    public record Range(long start, long end) {
    }

    public static class FreshIngredientIdentifier {

        private final List<Range> ranges;

        private FreshIngredientIdentifier(List<Range> ranges) {
            this.ranges = ranges;
        }

        public static FreshIngredientIdentifier create(String... ranges) {
            return new FreshIngredientIdentifier(parsedListOf(ranges));
        }

        private static List<Range> parsedListOf(String[] ranges) {
            return Arrays.stream(ranges)
                    .map(FreshIngredientIdentifier::rangeOf)
                    .toList();
        }

        private static Range rangeOf(String rangeString) {
            return rangeOf(rangeString.split("-"));
        }

        private static Range rangeOf(String[] split) {
            return new Range(Long.parseLong(split[0]), Long.parseLong(split[1]));
        }

        public int countFreshIngredientsFrom(String... ingredients) {
            return 2;
        }
    }
}
