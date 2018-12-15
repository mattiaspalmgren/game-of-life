package se.gameoflife.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PointTest {

  @Test
  public void isNeighbour() {
    // GIVEN
    Point p1 = new Point(0,0);
    Point p2 = new Point(1,1);
    Point p3 = new Point(2,1);

    // THEN
    assertTrue(Point.isNeighbour(p1, p2));
    assertFalse(Point.isNeighbour(p1, p3));
  }
}
