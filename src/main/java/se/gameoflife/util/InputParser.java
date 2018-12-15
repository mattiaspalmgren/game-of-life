package se.gameoflife.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import se.gameoflife.model.Point;

public class InputParser {
  private static final int SIZE_INDEX = 0;
  private static final String POINT_SEPARATOR = ",";
  private static final int X_INDEX = 0;
  private static final int Y_INDEX = 1;

  private InputParser() {
    throw new IllegalStateException("Utility class");
  }

  public static int parseSize(String[] input) {
    return Integer.parseInt(input[SIZE_INDEX]);
  }

  public static List<Point> parsePoints(String[] input) {
    return Stream.of(input)
        .skip(1) // Skip size
        .map(InputParser::parsePoint)
        .collect(Collectors.toList());
  }

  private static Point parsePoint(String input) {
    String[] inputArr = input.split(POINT_SEPARATOR);
    int x = Integer.parseInt(inputArr[X_INDEX]);
    int y = Integer.parseInt(inputArr[Y_INDEX]);
    return new Point(x, y);
  }
}
