package se.gameoflife.render;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import se.gameoflife.model.Cell;
import se.gameoflife.model.WorldState;

public class SystemOutStateRender implements StateRender {
  private static final String ALIVE = " * ";
  private static final String DEAD = " . ";
  private static final String DIVIDER = "\n";
  private static final String SEPARATOR = " ";

  @Override
  public void render(WorldState state) {
    print(DIVIDER);
    Map<Integer, List<Cell>> yMap =
        state.cells()
            .stream()
            .collect(Collectors.groupingBy(cell -> cell.point().y()));
    yMap.values()
        .forEach(SystemOutStateRender::printRow);
  }

  private static void printRow(List<Cell> row) {
    String rowValue = row.stream()
        .map(cell -> cell.state() ? ALIVE : DEAD)
        .collect(Collectors.joining(SEPARATOR));
    print(rowValue);
  }

  private static void print(String value) {
    System.out.println(value);
  }
}
