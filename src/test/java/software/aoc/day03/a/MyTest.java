package software.aoc.day03.a;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTest {

    @Test
    public void given_battery_bank_should_account_joltage() {
        assertThat(EscalatorBatteries.with("989216248294").joltage()).isEqualTo(99);
        assertThat(EscalatorBatteries.with("108337364723").joltage()).isEqualTo(87);
        assertThat(EscalatorBatteries.with("123016263670").joltage()).isEqualTo(70);
    }

    public record BatteryBank(int[] batteries) {}

    // TODO: rename
    public static class EscalatorBatteries {

        private final List<BatteryBank> banks;

        private EscalatorBatteries(List<BatteryBank> banks) {
            this.banks = banks;
        }

        public static EscalatorBatteries with(String... banks) {
            return new EscalatorBatteries(listOf(banks));
        }

        private static List<BatteryBank> listOf(String[] banks) {
            return Arrays.stream(banks)
                    .map(EscalatorBatteries::bankWith)
                    .toList();
        }

        private static BatteryBank bankWith(String bank) {
            return bankWith(bank.split(""));
        }

        private static BatteryBank bankWith(String[] batteries) {
            return bankWith(Arrays.stream(batteries).mapToInt(Integer::parseInt));
        }

        private static BatteryBank bankWith(IntStream intStream) {
            return new BatteryBank(intStream.toArray());
        }

        public int joltage() {
            return joltageFrom(firstBatteryIndex());
        }

        private int joltageFrom(int idx) {
            return this.banks.getFirst().batteries[idx] * 10 + maxLastBatteryValueFrom(idx, this.banks.getFirst().batteries);
        }

        private int firstBatteryIndex() {
            return firstBatteryIndexFrom(this.banks.getFirst().batteries());
        }

        private int firstBatteryIndexFrom(int[] batteries) {
            return IntStream.range(0, batteries.length - 1)
                    .filter(i -> batteries[i] == maxFirstBatteryValueFrom(batteries))
                    .findFirst().orElseThrow();
        }

        private static int maxFirstBatteryValueFrom(int[] batteries) {
            return Arrays.stream(batteries)
                    .limit(batteries.length - 1)
                    .max().orElseThrow();
        }

        private int maxLastBatteryValueFrom(int idx, int[] batteries) {
            return IntStream.range(idx + 1, batteries.length)
                    .map(i -> batteries[i])
                    .max().orElseThrow();
        }
    }
}
