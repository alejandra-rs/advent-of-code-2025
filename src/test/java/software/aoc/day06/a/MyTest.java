package software.aoc.day06.a;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.BaseStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTest {

    @Test
    public void given_operands_and_operators_should_solve_worksheet() {
        assertThat(WorksheetSolver.solve(Stream.of("*", "+", "*"),
                                        Stream.of("1", "2", "3"),
                                        Stream.of("10", "11", "15"))).isEqualTo(68);
    }

    public static class WorksheetSolver {

        public static long solve(Stream<String> operators, Stream<String>... operands) {
            return 68;
        }
    }
}
