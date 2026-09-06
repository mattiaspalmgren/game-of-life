package se.gameoflife.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class WorldStateTest {

  @Test
  public void stillLife() {
    // GIVEN
    Rules rules = new DefaultRule();
    List<Point> points = Arrays.asList(
            new Point(1,1),
            new Point(2,1),
            new Point(1,2),
            new Point(2,2)
    );
    WorldState worldState = WorldState.initial(4, points);

    // WHEN
    WorldState nextState = worldState.getNext(rules);

    // THEN
    List<Cell> expectedCells = points.stream()
        .map(point -> new Cell(point, true))
        .toList();

    assertEquals(expectedCells.size(), nextState.getAliveCells().size());
    assertTrue(nextState.getAliveCells().containsAll(expectedCells)) ;
  }

  @Test
  public void oscillatorLife() {
    // GIVEN
    Rules rules = new DefaultRule();
    List<Point> points = Arrays.asList(
        new Point(1,2),
        new Point(2,2),
        new Point(3,2)
    );
    WorldState worldState = WorldState.initial(5, points);

    // WHEN
    WorldState nextState = worldState.getNext(rules);

    // THEN
    List<Cell> expectedCells = Stream.of(
        new Point(2,1),
        new Point(2,2),
        new Point(2,3)
    ).map(point -> new Cell(point, true)).toList();

    assertEquals(expectedCells.size(), nextState.getAliveCells().size());
    assertTrue(nextState.getAliveCells().containsAll(expectedCells)) ;
  }
}
