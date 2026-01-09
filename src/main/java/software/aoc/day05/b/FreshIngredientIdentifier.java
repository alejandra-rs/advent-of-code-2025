package software.aoc.day05.b;

import java.util.Arrays;
import java.util.List;

public class FreshIngredientIdentifier {

    private final List<Range> ranges;

    private FreshIngredientIdentifier(List<Range> ranges) {
        this.ranges = ranges;
    }

    public static FreshIngredientIdentifier create(String ranges) {
        return new FreshIngredientIdentifier(parsedListOf(ranges.split("\n")));
    }

    public long countFreshIngredients() {
        return FreshIngredientIdentifier.create(mergedFreshIngredients()).count();
    }

    private static FreshIngredientIdentifier create(List<Range> ranges) {
        return new FreshIngredientIdentifier(ranges);
    }

    private List<Range> mergedFreshIngredients() {
        return RangeMerger.create().merge(ranges);
    }

    private long count() {
        return ranges.stream()
                .mapToLong(Range::rangeExtension)
                .sum();
    }

    private static List<Range> parsedListOf(String[] ranges) {
        return Arrays.stream(ranges)
                .map(Range::from)
                .toList();
    }
}
