package se.gameoflife.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import se.gameoflife.model.Point;

public class InputParserTest {

  @Test
  public void parseSize() {
    // GIVEN
    String[] input = {"5", "1,0", "2,2"};

    // WHEN
    int size = InputParser.parseSize(input);

    // THEN
    assertEquals(5, size);
  }

  @Test
  public void parsePoints() {
    // GIVEN
    String[] input = {"5", "1,0", "2,2"};

    // WHEN
    List<Point> points = InputParser.parsePoints(input);

    // THEN
    assertEquals(2, points.size());
    assertEquals(new Point(1, 0), points.get(0));
    assertEquals(new Point(2, 2), points.get(1));
  }

  @Test
  public void parseSizeMissing() {
    // GIVEN
    String[] input = {};

    // THEN
    assertThrows(IllegalArgumentException.class, () -> InputParser.parseSize(input));
  }

  @Test
  public void parseSizeNotANumber() {
    // GIVEN
    String[] input = {"abc"};

    // THEN
    assertThrows(IllegalArgumentException.class, () -> InputParser.parseSize(input));
  }

  @Test
  public void parsePointsMissingCoordinate() {
    // GIVEN
    String[] input = {"5", "1"};

    // THEN
    assertThrows(IllegalArgumentException.class, () -> InputParser.parsePoints(input));
  }

  @Test
  public void parsePointsNotANumber() {
    // GIVEN
    String[] input = {"5", "a,b"};

    // THEN
    assertThrows(IllegalArgumentException.class, () -> InputParser.parsePoints(input));
  }
}
