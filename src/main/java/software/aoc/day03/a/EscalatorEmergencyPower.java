package software.aoc.day03.a;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class EscalatorEmergencyPower {

    private final List<BatteryBank> banks;

    private EscalatorEmergencyPower(List<BatteryBank> banks) {
        this.banks = banks;
    }

    public static EscalatorEmergencyPower with(String... banks) {
        return new EscalatorEmergencyPower(listOf(banks));
    }

    private static List<BatteryBank> listOf(String[] banks) {
        return Arrays.stream(banks)
                .map(EscalatorEmergencyPower::bankWith)
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
        return banks.stream()
                .mapToInt(this::joltageFrom)
                .sum();
    }

    private Integer joltageFrom(BatteryBank bank) {
        return computeJoltageWith(indexOf(maxFirstBatteryFrom(bank), bank.batteries()), bank);
    }

    private Integer computeJoltageWith(Integer firstBatteryIdx, BatteryBank bank) {
        return bank.batteries()[firstBatteryIdx] * 10 + maxLastBatteryFrom(firstBatteryIdx, bank.batteries());
    }

    private Integer indexOf(int maxBattery, int[] batteries) {
        return IntStream.range(0, batteries.length - 1)
                .filter(i -> batteries[i] == maxBattery)
                .findFirst().orElseThrow();
    }

    private static int maxFirstBatteryFrom(BatteryBank bank) {
        return maxFirstBatteryFrom(bank.batteries());
    }

    private static int maxFirstBatteryFrom(int[] batteries) {
        return Arrays.stream(batteries)
                .limit(batteries.length - 1)
                .max().orElseThrow();
    }

    private int maxLastBatteryFrom(int firstBatteryIdx, int[] batteries) {
        return Arrays.stream(batteries, firstBatteryIdx + 1, batteries.length)
                .max().orElseThrow();
    }
}
