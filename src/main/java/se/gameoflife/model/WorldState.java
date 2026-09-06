package se.gameoflife.model;

import java.util.List;
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
    List<Point> aliveCells = cells.stream()
        .filter(cell -> rules.shouldLive(cell, getNumberOfAliveNeighbours(cell)))
        .map(Cell::point)
        .toList();
    return WorldState.initial(size, aliveCells);
  }

  private long getNumberOfAliveNeighbours(Cell cell) {
    return cells.stream()
        .filter(currentCell -> Point.isNeighbour(currentCell.point(), cell.point()))
        .filter(Cell::state)
        .count();
  }

  List<Cell> getAliveCells() {
    return cells.stream()
        .filter(Cell::state)
        .toList();
  }
}
