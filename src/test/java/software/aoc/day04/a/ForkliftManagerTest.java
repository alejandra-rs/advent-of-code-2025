package software.aoc.day04.a;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ForkliftManagerTest {

    public final static String diagram = """
                                        ..@@.@@@@.
                                        @@@.@.@.@@
                                        @@@@@.@.@@
                                        @.@@@@..@.
                                        @@.@@@@.@@
                                        .@@@@@@@.@
                                        .@.@.@.@@@
                                        @.@@@.@@@@
                                        .@@@@@@@@.
                                        @.@.@@@.@.
                                        """;

    @Test
    public void given_diagram_should_account_number_of_rolls_accessible() {
        assertThat(ForkliftManager.with("""
                                             ··@@·@··
                                             ·@·@@···
                                             ··@@··@·
                                             """).accesibleRollCount()).isEqualTo(7);
        assertThat(ForkliftManager.with(diagram).accesibleRollCount()).isEqualTo(13);
    }

    @Test
    public void reward() throws IOException {
        try (InputStream inputStream = ForkliftManagerTest.class.getResourceAsStream("/day04-a/input_aoc4.txt")) {
            assertThat(ForkliftManager.with(new String(inputStream.readAllBytes())).accesibleRollCount()).isEqualTo(1505);
        }
    }
}
