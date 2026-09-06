package se.gameoflife;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import se.gameoflife.model.Point;
import se.gameoflife.model.Rules;
import se.gameoflife.model.WorldState;
import se.gameoflife.render.StateRender;

class GameOfLife {
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
  private static final int TICK = 1;
  private final StateRender renderer;
  private final Rules rules;
  private WorldState state;

  GameOfLife(int size, List<Point> aliveCells, StateRender renderer, Rules rules) {
    this.renderer = renderer;
    this.rules = rules;
    state = WorldState.initial(size, aliveCells);
  }

  void run() {
    scheduler.scheduleAtFixedRate(() -> {
      renderer.render(state);
      state = state.getNext(rules);
      }, 0, TICK, TimeUnit.SECONDS);
  }
}
