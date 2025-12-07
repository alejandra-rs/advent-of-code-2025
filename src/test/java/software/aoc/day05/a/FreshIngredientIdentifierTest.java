package software.aoc.day05.a;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FreshIngredientIdentifierTest {

    public final static String ranges = """
                                        3-5
                                        10-14
                                        16-20
                                        12-18
                                        """;

    public final static String ingredients = """
                                             1
                                             5
                                             8
                                             11
                                             17
                                             32
                                             """;

    @Test
    public void given_ranges_should_count_fresh_ingredients() {
        assertThat(FreshIngredientIdentifier.create("10-20")
                    .countFreshIngredientsFrom("1", "5", "10", "15", "20")).isEqualTo(2);
        assertThat(FreshIngredientIdentifier.create(ranges.split("\n"))
                .countFreshIngredientsFrom(ingredients.split("\n"))).isEqualTo(3);
    }

}
