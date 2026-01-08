package software.aoc.day02.a;

public record Product(long id) {
    public boolean isInvalid() {
        return String.valueOf(id).matches("^([0-9]+)\\1$");
    }
}
