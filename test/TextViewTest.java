import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import cs5004.animator.model.SimpleAnimationImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.TextView;

import static org.junit.Assert.assertEquals;

/**
 * Class to test TextView and make sure it executes and throws errors appropriately.
 */
public class TextViewTest {

  private TextView newView = new TextView();
  SimpleAnimationImpl animation;

  @Before
  public void setup() {
    String input =
            "canvas 200 70 360 360\n" +
                    "shape R rectangle\n" +
                    "motion R 1  70  100 50 100 255 0  0    10  300 70  70 80  0  255 0\n" +
                    "motion R 10 300 70  70 80  0  255 0    50  210 150 120 100 0 100 100\n";

    SimpleAnimationImpl.Builder builder = new SimpleAnimationImpl.Builder();
    animation = AnimationReader.parseFile(new StringReader(input), builder);
  }

  /**
   * Testing the output TextView with valid inputs.
   * Note that the assertEquals views the "expected" as a String but the input as a StringBuilder.
   */
  @Test
  public void testOutput() {

    newView.createFrom(animation, 1);
    assertEquals("Create (255, 0, 0) Rectangle R with corner at (70.0,100.0),\n" +
            "width 50.0 and height 100.0. R appears at time t=1 and disappears at time t=50.\n" +
            "\n" +
            "R MOVES FROM (70,100) to (300,70). From time t=1 to t=10.\n" +
            "R CHANGES COLOR FROM (255,0,0) to (0,255,0). From time t=1 to t=10\n" +
            "R WIDTH CHANGES FROM 50 to 70. From time t=1 to t=10.\n" +
            "R HEIGHT CHANGES FROM 100 to 80. From time t=1 to t=10.\n" +
            "R MOVES FROM (300,70) to (210,150). From time t=10 to t=50.\n" +
            "R CHANGES COLOR FROM (0,255,0) to (0,100,100). From time t=10 to t=50\n" +
            "R WIDTH CHANGES FROM 70 to 120. From time t=10 to t=50.\n" +
            "R HEIGHT CHANGES FROM 80 to 100. From time t=10 to t=50." + "\n" + "\n" + "\n",
            newView.output().toString());
  }

  /**
   * Testing that the TextView works with Ellipse shape inputs.
   */
  @Test
  public void ovalTest() {

    String input = "canvas 200 70 360 360\n" +
                    "shape C ellipse\n" +
                    "motion C 1  70  100 50 100 255 0  0    10  300 70  70 80  0  255 0\n" +
                    "motion C 10 300 70  70 80  0  255 0    50  210 150 120 100 0 100 100\n";

    SimpleAnimationImpl.Builder builder = new SimpleAnimationImpl.Builder();
    animation = AnimationReader.parseFile(new StringReader(input), builder);

    newView.createFrom(animation, 1);
    assertEquals("Create (255, 0, 0) Oval C with corner at (70.0,100.0),\n" +
                    "radius 25.0 and 100.0. C appears at time t=1 and disappears at time t=50.\n" +
                    "\n" +
                    "C MOVES FROM (70,100) to (300,70). From time t=1 to t=10.\n" +
                    "C CHANGES COLOR FROM (255,0,0) to (0,255,0). From time t=1 to t=10\n" +
                    "C WIDTH RADIUS CHANGES FROM 25.0 to 35.0. From time t=1 to t=10.\n" +
                    "C HEIGHT RADIUS CHANGES FROM 50.0 to 40.0. From time t=1 to t=10.\n" +
                    "C MOVES FROM (300,70) to (210,150). From time t=10 to t=50.\n" +
                    "C CHANGES COLOR FROM (0,255,0) to (0,100,100). From time t=10 to t=50\n" +
                    "C WIDTH RADIUS CHANGES FROM 35.0 to 60.0. From time t=10 to t=50.\n" +
                    "C HEIGHT RADIUS CHANGES FROM 40.0 to 50.0. From time t=10 to t=50." +
                    "\n" + "\n" + "\n", newView.output().toString());
  }

  /**
   * Testing that the TextView works with two shape inputs.
   */
  @Test
  public void twoShapeTest() {

    String input = "canvas 200 70 360 360\n" +
            "shape C ellipse\n" +
            "motion C 1  70  100 50 100 255 0  0    10  300 70  70 80  0  255 0\n" +
            "motion C 10 300 70  70 80  0  255 0    50  210 150 120 100 0 100 100\n" +
            "shape R rectangle\n" +
            "motion R 1  70  100 50 100 255 0  0    10  300 70  70 80  0  255 0\n" +
            "motion R 10 300 70  70 80  0  255 0    50  210 150 120 100 0 100 100\n";

    SimpleAnimationImpl.Builder builder = new SimpleAnimationImpl.Builder();
    animation = AnimationReader.parseFile(new StringReader(input), builder);

    newView.createFrom(animation, 1);
    assertEquals("Create (255, 0, 0) Oval C with corner at (70.0,100.0),\n" +
            "radius 25.0 and 100.0. C appears at time t=1 and disappears at time t=50.\n" +
            "\n" +
            "C MOVES FROM (70,100) to (300,70). From time t=1 to t=10.\n" +
            "C CHANGES COLOR FROM (255,0,0) to (0,255,0). From time t=1 to t=10\n" +
            "C WIDTH RADIUS CHANGES FROM 25.0 to 35.0. From time t=1 to t=10.\n" +
            "C HEIGHT RADIUS CHANGES FROM 50.0 to 40.0. From time t=1 to t=10.\n" +
            "C MOVES FROM (300,70) to (210,150). From time t=10 to t=50.\n" +
            "C CHANGES COLOR FROM (0,255,0) to (0,100,100). From time t=10 to t=50\n" +
            "C WIDTH RADIUS CHANGES FROM 35.0 to 60.0. From time t=10 to t=50.\n" +
            "C HEIGHT RADIUS CHANGES FROM 40.0 to 50.0. From time t=10 to t=50.\n" +
            "\n" +
            "\n" +
            "Create (255, 0, 0) Rectangle R with corner at (70.0,100.0),\n" +
            "width 50.0 and height 100.0. R appears at time t=1 and disappears at time t=50.\n" +
            "\n" +
            "R MOVES FROM (70,100) to (300,70). From time t=1 to t=10.\n" +
            "R CHANGES COLOR FROM (255,0,0) to (0,255,0). From time t=1 to t=10\n" +
            "R WIDTH CHANGES FROM 50 to 70. From time t=1 to t=10.\n" +
            "R HEIGHT CHANGES FROM 100 to 80. From time t=1 to t=10.\n" +
            "R MOVES FROM (300,70) to (210,150). From time t=10 to t=50.\n" +
            "R CHANGES COLOR FROM (0,255,0) to (0,100,100). From time t=10 to t=50\n" +
            "R WIDTH CHANGES FROM 70 to 120. From time t=10 to t=50.\n" +
            "R HEIGHT CHANGES FROM 80 to 100. From time t=10 to t=50." +
            "\n" + "\n" + "\n", newView.output().toString());
  }
}
