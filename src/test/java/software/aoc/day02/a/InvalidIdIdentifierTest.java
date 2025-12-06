package software.aoc.day02.a;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InvalidIdIdentifierTest {

    @Test
    public void given_id_ranges_should_sum_invalid_ids() {
        assertThat(InvalidIdIdentifier.create("10-20").sumInvalid()).isEqualTo(11);
        assertThat(InvalidIdIdentifier.create("11-22").sumInvalid()).isEqualTo(33);
    }

}
