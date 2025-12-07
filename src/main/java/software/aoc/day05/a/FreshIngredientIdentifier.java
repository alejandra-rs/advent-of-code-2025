package software.aoc.day05.a;

import java.util.Arrays;
import java.util.List;

public class FreshIngredientIdentifier {

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
        return (int) Arrays.stream(ingredients)
                .mapToLong(Long::parseLong)
                .filter(this::isFresh)
                .count();
    }

    private boolean isFresh(long i) {
        return ranges.stream().anyMatch(r -> r.in(i));
    }
}
