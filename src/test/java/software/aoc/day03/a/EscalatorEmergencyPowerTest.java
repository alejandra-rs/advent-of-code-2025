package software.aoc.day03.a;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class EscalatorEmergencyPowerTest {
    public final static String batteryBanks = """
                                              987654321111111
                                              811111111111119
                                              234234234234278
                                              818181911112111
                                              """;

    @Test
    public void given_battery_bank_should_account_joltage() {
        assertThat(EscalatorEmergencyPower.with("989216248294").joltage()).isEqualTo(99);
        assertThat(EscalatorEmergencyPower.with("108337364723").joltage()).isEqualTo(87);
        assertThat(EscalatorEmergencyPower.with("123016263670").joltage()).isEqualTo(70);
    }

    @Test
    public void given_multiple_battery_banks_should_account_joltage() {
        assertThat(EscalatorEmergencyPower.with("989216248294", "123016263670").joltage()).isEqualTo(169);
        assertThat(EscalatorEmergencyPower.with("123512314532", "111113332321").joltage()).isEqualTo(88);
        assertThat(EscalatorEmergencyPower.with(batteryBanks.split("\n")).joltage()).isEqualTo(357);
    }

    @Test
    public void reward() throws IOException {
        try (InputStream inputStream = EscalatorEmergencyPowerTest.class.getResourceAsStream("/day03-a/input_aoc3.txt")) {
            assertThat(EscalatorEmergencyPower.with(new String(inputStream.readAllBytes()).split("\n")).joltage()).isEqualTo(17613);
        }
    }
}
