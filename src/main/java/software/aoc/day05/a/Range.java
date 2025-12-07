package software.aoc.day05.a;

public record Range(long start, long end) {
    public boolean in(long num) {
        return start <= num && num <= end;
    }
}
