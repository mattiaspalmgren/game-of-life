package se.gameoflife.model;

import java.util.List;

public record Point(int x, int y) {

  private static final List<Point> NEIGHBOUR_OFFSETS = List.of(
      new Point(-1, -1), new Point(0, -1), new Point(1, -1),
      new Point(-1, 0), new Point(1, 0),
      new Point(-1, 1), new Point(0, 1), new Point(1, 1)
  );

  static boolean isNeighbour(Point point, Point other) {
    if (point.equals(other)) {
      return false;
    }
    int offsetX = Math.abs(point.x() - other.x());
    int offsetY = Math.abs(point.y() - other.y());
    return offsetX <= 1 && offsetY <= 1;
  }

  List<Point> neighbours() {
    return NEIGHBOUR_OFFSETS.stream()
        .map(this::plus)
        .toList();
  }

  Point plus(Point offset) {
    return new Point(x + offset.x(), y + offset.y());
  }
}
