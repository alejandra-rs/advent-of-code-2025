package software.aoc.day05.a;

import org.junit.Test;

import java.io.*;

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
                    .countFreshIngredientsFrom("1", "5", "10", "15", "20")).isEqualTo(3);
        assertThat(FreshIngredientIdentifier.create(ranges.split("\n"))
                .countFreshIngredientsFrom(ingredients.split("\n"))).isEqualTo(3);
    }

    @Test
    public void reward() throws IOException {
        try (InputStream inputStream = FreshIngredientIdentifier.class.getResourceAsStream("/day05/input_aoc5.txt")) {
            assertThat(createRangesAndCountFreshIngredientsFrom(inputStream)).isEqualTo(798);
        }
    }

    private int createRangesAndCountFreshIngredientsFrom(InputStream inputStream) throws IOException {
        return createRangesAndCountFreshIngredientsFrom(new String(inputStream.readAllBytes()));
    }

    private int createRangesAndCountFreshIngredientsFrom(String str) {
        return createRangesAndCountFreshIngredientsFrom(str.split("\n\n"));
    }

    private int createRangesAndCountFreshIngredientsFrom(String[] split) {
        return FreshIngredientIdentifier.create(split[0].split("\n"))
                .countFreshIngredientsFrom(split[1].split("\n"));
    }

}
