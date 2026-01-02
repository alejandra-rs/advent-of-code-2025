package software.aoc.day10.a;

import static java.lang.Integer.parseInt;

public record IndicatorLight (int value, int size) {
    public static IndicatorLight from(String lightDiagram) {
        return createIndicatorLightWith(lightDiagram);
    }

    private static IndicatorLight createIndicatorLightWith(String lightDiagram) {
        return new IndicatorLight(binaryStringToInt(stripBracketsIn(lightDiagram)), lightDiagram.length() - 2);
    }

    private static String stripBracketsIn(String diagram) {
        return diagram.substring(1, diagram.length() - 1);
    }

    private static int binaryStringToInt(String diagram) {
        return parseInt(diagram.replace('.', '0')
                               .replace('#', '1'), 2);
    }
}