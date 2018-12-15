package se.gameoflife;

import se.gameoflife.util.InputParser;

public class GameOfLifeApplication {
  public static void main(String[] args) {
    new GameOfLife(
        InputParser.parseSize(args),
        InputParser.parsePoints(args))
        .run();
  }
}
