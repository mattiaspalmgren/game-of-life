package se.gameoflife.render;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.gameoflife.model.Point;
import se.gameoflife.model.WorldState;

public class SystemOutStateRenderTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  public void render() {
    // GIVEN
    List<Point> points = Collections.singletonList(new Point(1,1));
    WorldState state = WorldState.initial(3, points);
    SystemOutStateRender renderer = new SystemOutStateRender();

    // WHEN
    renderer.render(state);

    // THEN
    String expected = "\n\n .   .   . \n .   *   . \n .   .   . \n";
    assertEquals(expected, outContent.toString());
  }

  @AfterEach
  public void restoreStreams() {
      System.setOut(originalOut);
  }
}
