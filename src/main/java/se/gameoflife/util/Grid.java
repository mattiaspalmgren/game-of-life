package se.gameoflife.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import se.gameoflife.model.Point;

public class Grid {

  private Grid() {
    throw new IllegalStateException("Utility class");
  }

  public static List<Point> getGridAsList(int size) {
    List<Point> indices = new ArrayList<>();
    for (int x : getRange(size)) {
      for (int y : getRange(size)) {
        indices.add(new Point(x, y));
      }
    }
    return indices;
  }

  private static List<Integer> getRange(int end) {
    return IntStream.range(0, end).boxed().collect(Collectors.toList());
  }
}
