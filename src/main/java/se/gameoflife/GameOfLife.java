package se.gameoflife;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import se.gameoflife.model.DefaultRule;
import se.gameoflife.model.Point;
import se.gameoflife.model.Rules;
import se.gameoflife.model.WorldState;
import se.gameoflife.render.StateRender;
import se.gameoflife.render.SystemOutStateRender;

class GameOfLife {
  private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
  private static final int TICK = 1;
  private static final StateRender renderer = new SystemOutStateRender();
  private static final Rules rules = new DefaultRule();
  private WorldState state;

  GameOfLife(int size, List<Point> aliveCells) {
    state = new WorldState(size, aliveCells);
  }

  void run() {
    scheduler.scheduleAtFixedRate(() -> {
      renderer.render(state);
      state = state.getNext(rules);
      }, 0, TICK, TimeUnit.SECONDS);
  }
}
