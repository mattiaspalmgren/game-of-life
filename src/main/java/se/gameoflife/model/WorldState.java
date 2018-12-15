package se.gameoflife.model;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import se.gameoflife.util.Grid;

@Getter
public class WorldState {
  private int size;
  private List<Cell> cells;

  public WorldState(int size, List<Point> aliveCells) {
    this.size = size;
    this.cells = Grid.getGridAsList(size)
        .stream()
        .map(point -> {
          boolean isAlive = aliveCells.contains(point);
          return new Cell(point, isAlive);
        }).collect(Collectors.toList());
  }

  public WorldState getNext(Rules rules) {
    List<Point> aliveCells = cells.stream()
        .filter(cell -> rules.shouldLive(cell, getNumberOfAliveNeighbours(cell)))
        .map(Cell::getPoint)
        .collect(Collectors.toList());
    return new WorldState(size, aliveCells);
  }

  private long getNumberOfAliveNeighbours(Cell cell) {
    return cells.stream()
        .filter(currentCell -> Point.isNeighbour(currentCell.getPoint(), cell.getPoint()))
        .filter(Cell::isState)
        .count();
  }

  List<Cell> getAliveCells() {
    return cells.stream()
        .filter(Cell::isState)
        .collect(Collectors.toList());
  }
}
