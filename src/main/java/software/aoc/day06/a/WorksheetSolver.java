package software.aoc.day06.a;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.BaseStream;
import java.util.stream.Stream;

public class WorksheetSolver {

    public static long solve(Stream<String> operators, Stream<String>... operands) {
        return operationStreamWith(operators, operands)
                .mapToLong(Operation::result)
                .sum();
    }

    private static Stream<Operation> operationStreamWith(Stream<String> operators, Stream<String>[] operands) {
        return operationStreamWith(operators.iterator(), Arrays.stream(operands).map(BaseStream::iterator).toList());
    }

    private static Stream<Operation> operationStreamWith(Iterator<String> operatorIter, List<Iterator<String>> operandIter) {
        return Stream.generate(() -> nextOperationIn(operatorIter, operandIter))
                .takeWhile(Objects::nonNull);
    }

    private static Operation nextOperationIn(Iterator<String> operatorIter, List<Iterator<String>> operandIter) {
        return operatorIter.hasNext() && allHaveNextFrom(operandIter) ?
                readOperationIn(operatorIter.next(), allNextOperandsFrom(operandIter)) :
                null;
    }

    private static Operation readOperationIn(String operator, long[] operands) {
        return new Operation(operator, operands);
    }

    private static boolean allHaveNextFrom(List<Iterator<String>> operandIter) {
        return operandIter.stream().allMatch(Iterator::hasNext);
    }

    private static long[] allNextOperandsFrom(List<Iterator<String>> operandIter) {
        return operandIter.stream()
                .map(Iterator::next)
                .mapToLong(Long::parseLong)
                .toArray();
    }

}
