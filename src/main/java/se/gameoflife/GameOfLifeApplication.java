package se.gameoflife;

import se.gameoflife.model.DefaultRule;
import se.gameoflife.render.SystemOutStateRender;
import se.gameoflife.util.InputParser;

public class GameOfLifeApplication {
  public static void main(String[] args) {
    new GameOfLife(
        InputParser.parseSize(args),
        InputParser.parsePoints(args),
        new SystemOutStateRender(),
        new DefaultRule())
        .run();
  }
}
