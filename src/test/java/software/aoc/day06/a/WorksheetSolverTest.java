package software.aoc.day06.a;

import org.junit.Test;
import software.aoc.day05.a.FreshIngredientIdentifier;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WorksheetSolverTest {

    public final static Stream<String> operators = Stream.of("*", "+", "*", "+");

    public final static Stream<String>[] operands = new Stream[]{
                                                                    Stream.of("123", "328", "51", "64"),
                                                                    Stream.of("45", "64", "387", "23"),
                                                                    Stream.of("6", "98", "215", "314")
                                                                };

    @Test
    public void given_operands_and_operators_should_solve_worksheet() {
        assertThat(WorksheetSolver.solve(Stream.of("*", "+", "*"),
                                        Stream.of("1", "2", "3"),
                                        Stream.of("10", "11", "15"))).isEqualTo(68);
        assertThat(WorksheetSolver.solve(operators, operands)).isEqualTo(4277556);
    }

    @Test
    public void reward() throws IOException {
        try (InputStream inputStream = FreshIngredientIdentifier.class.getResourceAsStream("/day06/input_aoc6.txt")) {
            assertThat(solveWorksheetIn(inputStream)).isEqualTo(4405895212738L);
        }
    }

    private long solveWorksheetIn(InputStream inputStream) throws IOException {
        return solveWorksheetIn(new String(inputStream.readAllBytes()));
    }

    private long solveWorksheetIn(String str) {
        return solveWorksheetIn(str.replaceAll(" +", " ").split("\n"));
    }

    private long solveWorksheetIn(String[] split) {
        return WorksheetSolver.solve(operatorsIn(split),
                                     operandsIn(split));
    }

    private Stream<String> operatorsIn(String[] split) {
        return Arrays.stream(split[split.length - 1].split(" "));
    }

    private Stream<String>[] operandsIn(String[] split) {
        return Arrays.stream(split)
                .limit(split.length - 1)
                .map(s -> Stream.of(s.split(" ")))
                .toArray(Stream[]::new);
    }
}
