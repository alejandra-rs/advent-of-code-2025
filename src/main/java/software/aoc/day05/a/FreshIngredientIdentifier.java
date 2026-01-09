package software.aoc.day05.a;

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

    private static List<Range> parsedListOf(String[] ranges) {
        return Arrays.stream(ranges)
                .map(Range::from)
                .toList();
    }

    public int countFreshIngredientsFrom(String ingredients) {
        return (int) Arrays.stream(ingredients.split("\n"))
                .mapToLong(Long::parseLong)
                .filter(this::isFresh)
                .count();
    }

    private boolean isFresh(long i) {
        return ranges.stream().anyMatch(r -> r.includes(i));
    }
}
