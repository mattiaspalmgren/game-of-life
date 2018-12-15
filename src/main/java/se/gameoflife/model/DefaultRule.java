package se.gameoflife.model;

public class DefaultRule implements Rules {

  @Override
  public boolean shouldLive(Cell cell, long numberOfAliveNeighbours) {
    return cell.isState() && numberOfAliveNeighbours == 2 ||
        cell.isState() && numberOfAliveNeighbours == 3 ||
        !cell.isState() && numberOfAliveNeighbours == 3;
  }
}
