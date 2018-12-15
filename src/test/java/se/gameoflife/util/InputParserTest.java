package se.gameoflife.util;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;
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
}
