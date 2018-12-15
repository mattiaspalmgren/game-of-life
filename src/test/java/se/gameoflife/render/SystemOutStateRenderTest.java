package se.gameoflife.render;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.gameoflife.model.Point;
import se.gameoflife.model.WorldState;

public class SystemOutStateRenderTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  public void render() {
    // GIVEN
    List<Point> points = Collections.singletonList(new Point(1,1));
    WorldState state = new WorldState(3, points);
    SystemOutStateRender renderer = new SystemOutStateRender();

    // WHEN
    renderer.render(state);

    // THEN
    String expected = "\n\n .   .   . \n .   *   . \n .   .   . \n";
    assertEquals(expected, outContent.toString());
  }

  @After
  public void restoreStreams() {
      System.setOut(originalOut);
  }
}
