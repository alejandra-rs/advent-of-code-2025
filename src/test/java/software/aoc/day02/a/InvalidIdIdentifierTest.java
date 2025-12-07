package software.aoc.day02.a;

import org.junit.Test;
import software.aoc.day01.a.DialTest;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InvalidIdIdentifierTest {

    public final static String ranges = """
                                        11-22
                                        95-115
                                        998-1012
                                        1188511880-1188511890
                                        222220-222224
                                        1698522-1698528
                                        446443-446449
                                        38593856-38593862
                                        """;

    @Test
    public void given_id_ranges_should_sum_invalid_ids() {
        assertThat(InvalidIdIdentifier.create("10-20").sumInvalid()).isEqualTo(11);
        assertThat(InvalidIdIdentifier.create("11-22").sumInvalid()).isEqualTo(33);
        assertThat(InvalidIdIdentifier.create(ranges.split("\n")).sumInvalid()).isEqualTo(1227775554);
    }

    @Test
    public void reward() throws IOException {
        try (InputStream inputStream = DialTest.class.getResourceAsStream("/day02/input_aoc2.txt")) {
            assertThat(InvalidIdIdentifier.create(new String(inputStream.readAllBytes()).split(",")).sumInvalid()).isEqualTo(41294979841L);
        }
    }

}
