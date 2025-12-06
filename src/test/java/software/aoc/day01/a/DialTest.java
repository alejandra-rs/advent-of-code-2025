package software.aoc.day01.a;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DialTest {
    private static final String orders = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
            """;

    @Test
    public void given_orders_should_account_the_final_position() {
        Dial dial = Dial.create();
        assertThat(Dial.create().add("L1").position()).isEqualTo(49);
        assertThat(Dial.create().add("L1", "R1", "R50").position()).isEqualTo(0);
        assertThat(Dial.create().add("L51", "L500").position()).isEqualTo(99);
        assertThat(Dial.create().execute(orders).position()).isEqualTo(32);
    }

    @Test
    public void given_orders_should_account_the_times_that_position_is_zero() {
        assertThat(Dial.create().execute(orders).count()).isEqualTo(3);
        assertThat(Dial.create().add("L1").count()).isEqualTo(0);
        assertThat(Dial.create().add("L1", "R1", "R50").count()).isEqualTo(1);
        assertThat(Dial.create().add("L51", "L500").count()).isEqualTo(0);
    }

    public static class Dial {
        private final List<Order> orders;
        private Dial() {
            this.orders = new ArrayList<>();
        }
        public static Dial create() {
            return new Dial();
        }

        public Dial add(String... orders) {
            Arrays.stream(orders)
                    .map(this::parse)
                    .forEach(this::add);
            return this;
        }

        private void add(Order order) {
            orders.add(order);
        }

        private Order parse(String order) {
            return new Order(signOf(order) * valueOf(order));
        }

        private int signOf(String order) {
            return order.charAt(0) == 'L' ? -1 : 1;
        }

        private int valueOf(String order) {
            return Integer.parseInt(order.substring(1));
        }

        public int position() {
            return normalize(sumAll());
        }

        private int sumAll() {
            return sum(orders.stream());
        }

        public int count() {
            return (int) iterate()
                    .map(this::sumPartial)
                    .filter(s -> s == 0)
                    .count();
        }

        private IntStream iterate() {
            return IntStream.rangeClosed(1, orders.size()).parallel();
        }

        private int sumPartial(int size) {
            return normalize(sum(orders.stream().limit(size)));
        }

        private static int sum(Stream<Order> orders) {
            return orders.mapToInt(o -> o.step).sum() + 50;
        }

        private int normalize(int value) {
            return ((value < 0 ? 100 : 0) + value) % 100;
        }



        public Dial execute(String orders) {
            return add(orders.split("\n"));
        }
    }

    public record Order(int step) { }
}
