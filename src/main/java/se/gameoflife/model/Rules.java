package se.gameoflife.model;

public interface Rules {
  boolean shouldLive(Cell cell, long numberOfAliveNeighbours);
}
