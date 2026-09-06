package se.gameoflife.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import se.gameoflife.util.Grid;

public record WorldState(int size, List<Cell> cells) {

  public static WorldState initial(int size, List<Point> aliveCells) {
    List<Cell> cells = Grid.getGridAsList(size)
        .stream()
        .map(point -> {
          boolean isAlive = aliveCells.contains(point);
          return new Cell(point, isAlive);
        }).toList();
    return new WorldState(size, cells);
  }

  public WorldState getNext(Rules rules) {
    Set<Point> alivePoints = cells.stream()
        .filter(Cell::state)
        .map(Cell::point)
        .collect(Collectors.toSet());
    List<Point> aliveCells = cells.stream()
        .filter(cell -> rules.shouldLive(cell, getNumberOfAliveNeighbours(cell, alivePoints)))
        .map(Cell::point)
        .toList();
    return WorldState.initial(size, aliveCells);
  }

  private static long getNumberOfAliveNeighbours(Cell cell, Set<Point> alivePoints) {
    return cell.point().neighbours().stream()
        .filter(alivePoints::contains)
        .count();
  }

  List<Cell> getAliveCells() {
    return cells.stream()
        .filter(Cell::state)
        .toList();
  }
}
