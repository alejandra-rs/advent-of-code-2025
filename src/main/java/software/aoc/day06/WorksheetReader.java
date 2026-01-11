package software.aoc.day06;

import java.util.Iterator;

public interface WorksheetReader extends Iterable<Operation> {
    Iterator<Operation> iterator();
}
