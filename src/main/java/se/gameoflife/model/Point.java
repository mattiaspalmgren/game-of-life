package se.gameoflife.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Point {
  private final int x;
  private final int y;

  static boolean isNeighbour(Point point, Point other) {
    if (point.equals(other)) {
      return false;
    }
    int offsetX = Math.abs(point.getX() - other.getX());
    int offsetY = Math.abs(point.getY() - other.getY());
    return offsetX <= 1 && offsetY <= 1;
  }
}
