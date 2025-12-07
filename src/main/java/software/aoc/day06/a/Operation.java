package software.aoc.day06.a;

import java.util.Arrays;

public record Operation(String operator, long[] operands) {
    public long result() {
        return operator.equals("+") ? sumOperands() : multiplyOperands();
    }

    private long sumOperands() {
        return Arrays.stream(operands).sum();
    }

    private long multiplyOperands() {
        return Arrays.stream(operands)
                .reduce((a, b) -> a * b)
                .orElseThrow();
    }
}
