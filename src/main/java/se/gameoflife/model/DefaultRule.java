package se.gameoflife.model;

public class DefaultRule implements Rules {

  @Override
  public boolean shouldLive(Cell cell, long numberOfAliveNeighbours) {
    return cell.state() && numberOfAliveNeighbours == 2 ||
        cell.state() && numberOfAliveNeighbours == 3 ||
        !cell.state() && numberOfAliveNeighbours == 3;
  }
}
