package se.gameoflife.util;

import java.util.List;
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
    if (input.length == 0) {
      throw new IllegalArgumentException("Missing world size argument");
    }
    String sizeInput = input[SIZE_INDEX];
    try {
      return Integer.parseInt(sizeInput);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          "Invalid world size '" + sizeInput + "', expected a whole number");
    }
  }

  public static List<Point> parsePoints(String[] input) {
    return Stream.of(input)
        .skip(1) // Skip size
        .map(InputParser::parsePoint)
        .toList();
  }

  private static Point parsePoint(String input) {
    String[] inputArr = input.split(POINT_SEPARATOR);
    if (inputArr.length != 2) {
      throw new IllegalArgumentException(
          "Invalid point '" + input + "', expected format 'x,y'");
    }
    try {
      int x = Integer.parseInt(inputArr[X_INDEX]);
      int y = Integer.parseInt(inputArr[Y_INDEX]);
      return new Point(x, y);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          "Invalid point '" + input + "', expected format 'x,y' with whole numbers");
    }
  }
}
