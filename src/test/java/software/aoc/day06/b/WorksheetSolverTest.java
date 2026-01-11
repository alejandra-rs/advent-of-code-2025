package software.aoc.day06.b;

import org.junit.Test;
import software.aoc.day06.WorksheetSolver;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class WorksheetSolverTest {

    public final static String worksheet = """
                                           123 328  51 64 \s
                                            45 64  387 23 \s
                                             6 98  215 314\s
                                           *   +   *   +  \s
                                           """;

    @Test
    public void given_operands_and_operators_should_solve_worksheet() {
        assertThat(WorksheetSolver.solve(CephalopodWorksheetReader.from("""
                                                                                   1  2  3\s
                                                                                  10 11 15\s
                                                                                  *  +  * \s
                                                                                  """)))
                .isEqualTo(67);
        assertThat(WorksheetSolver.solve(CephalopodWorksheetReader.from(worksheet)))
                .isEqualTo(3263827);
    }

    @Test
    public void reward() throws IOException {
        try (InputStream inputStream = WorksheetSolverTest.class.getResourceAsStream("/day06/input_aoc6.txt")) {
            assertThat(WorksheetSolver.solve(CephalopodWorksheetReader.from(new String(inputStream.readAllBytes()))))
                    .isEqualTo(7450962489289L);
        }
    }
}
