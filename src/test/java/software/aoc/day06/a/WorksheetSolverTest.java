package software.aoc.day06.a;

import org.junit.Test;
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
}
