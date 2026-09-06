package se.gameoflife.model;

public record Point(int x, int y) {

  static boolean isNeighbour(Point point, Point other) {
    if (point.equals(other)) {
      return false;
    }
    int offsetX = Math.abs(point.x() - other.x());
    int offsetY = Math.abs(point.y() - other.y());
    return offsetX <= 1 && offsetY <= 1;
  }
}
