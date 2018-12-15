package se.gameoflife.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Cell {
  private final Point point;
  private final boolean state;

  Cell(Point point, boolean state) {
    this.point = point;
    this.state = state;
  }
}
