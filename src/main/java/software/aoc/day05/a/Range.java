package software.aoc.day05.a;

public record Range(long start, long end) {

    public static Range from(String range) {
        return rangeOf(range.split("-"));
    }

    public boolean includes(long id) {
        return start <= id && id <= end;
    }

    private static Range rangeOf(String[] range) {
        return new Range(Long.parseLong(range[0]), Long.parseLong(range[1]));
    }

}
