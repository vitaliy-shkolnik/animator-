import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import cs5004.animator.model.SimpleAnimationImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.SVGView;
import static org.junit.Assert.assertEquals;

/**
 * Class to run SVGView tests to make sure SVGView executes and throws errors appropriately.
 */
public class SVGViewTest {

  private SVGView newView = new SVGView();
  SimpleAnimationImpl animation;

  /**
   * Setting up input the a initial SVGView to be reference in tests.
   */
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
   * Test to see if SVGView functions appropriately when a Rectangle is entered.
   */
  @Test
  public void testRectangle() {

    newView.createFrom(animation, 1);
    assertEquals("<svg width=\"360\" height =\"360\" viewBox=\"200 70 360 360\" " +
                    "version=\"1.1\"\n" +
                    " xmlns=\"http://www.w3.org/2000/svg\">\n" +
                    "\n" +
                    "<rect id=\"R\" x=\"70.000000\" y=\"100.000000\" width=\"50.000000\" " +
                    "height=\"100.000000\" fill=\"rgb(255, 0, 0)\" visibility=\"visible\">\n" +
                    "\n" +
                    "\t<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\" " +
                    "attributeName=\"x\" from=\"70.0\" to=\"300.0\" fill=\"freeze\" />\n" +
                    "\t<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\" " +
                    "attributeName=\"y\" from=\"100.0\" to=\"70.0\" fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\" " +
                    "attributeName=\"fill\" from=\"rgb(255,0,0)\" to=\"rgb(0,255,0)\" " +
                    "fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\" " +
                    "attributeName=\"width\" from=\"50\" to=\"70\" fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\" " +
                    "attributeName=\"height\" from=\"100\" to=\"80\" fill=\"freeze\" />\n" +
                    "\t<animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" " +
                    "attributeName=\"x\" from=\"300.0\" to=\"210.0\" fill=\"freeze\" />\n" +
                    "\t<animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" " +
                    "attributeName=\"y\" from=\"70.0\" to=\"150.0\" fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" " +
                    "attributeName=\"fill\" from=\"rgb(0,255,0)\" to=\"rgb(0,100,100)\" " +
                    "fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" " +
                    "attributeName=\"width\" from=\"70\" to=\"120\" fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" " +
                    "attributeName=\"height\" from=\"80\" to=\"100\" fill=\"freeze\" />\n" +
                    "\n" +
                    "</rect>\n" +
                    "\n" +
                    "</svg>",
            newView.output().toString());
  }

  /**
   * Test to see if SVGView functions appropriately when an ellipse is entered.
   */
  @Test
  public void testOval() {

    String input =
            "canvas 200 70 360 360\n" +
                    "shape C Ellipse\n" +
                    "motion C 1  70  100 50 100 255 0  0    10  300 70  70 80  0  255 0\n" +
                    "motion C 10 300 70  70 80  0  255 0    50  210 150 120 100 0 100 100\n";

    SimpleAnimationImpl.Builder builder = new SimpleAnimationImpl.Builder();
    animation = AnimationReader.parseFile(new StringReader(input), builder);

    newView.createFrom(animation, 1);
    assertEquals("<svg width=\"360\" height =\"360\" viewBox=\"200 70 360 360\" " +
                    "version=\"1.1\"\n" +
                    " xmlns=\"http://www.w3.org/2000/svg\">\n" +
                    "\n" +
                    "<ellipse id=\"C\" cx=\"70.000000\" cy=\"100.000000\" rx=\"25.000000\" " +
                    "ry=\"50.000000\" fill=\"rgb(255, 0, 0)\" visibility=\"visible\">\n" +
                    "\n" +
                    "\t<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\" " +
                    "attributeName=\"cx\" from=\"70.0\" to=\"300.0\" fill=\"freeze\" />\n" +
                    "\t<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\" " +
                    "attributeName=\"cy\" from=\"100.0\" to=\"70.0\" fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\" " +
                    "attributeName=\"fill\" from=\"rgb(255,0,0)\" to=\"rgb(0,255,0)\" " +
                    "fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\" " +
                    "attributeName=\"width\" from=\"25.0\" to=\"35.0\" fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\" " +
                    "attributeName=\"height\" from=\"50.0\" to=\"40.0\" fill=\"freeze\" />\n" +
                    "\t<animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" " +
                    "attributeName=\"cx\" from=\"300.0\" to=\"210.0\" fill=\"freeze\" />\n" +
                    "\t<animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" " +
                    "attributeName=\"cy\" from=\"70.0\" to=\"150.0\" fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" " +
                    "attributeName=\"fill\" from=\"rgb(0,255,0)\" to=\"rgb(0,100,100)\" " +
                    "fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" " +
                    "attributeName=\"width\" from=\"35.0\" to=\"60.0\" fill=\"freeze\" />\n" +
                    "    <animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" " +
                    "attributeName=\"height\" from=\"40.0\" to=\"50.0\" fill=\"freeze\" />\n" +
                    "\n" +
                    "</ellipse>\n" +
                    "\n" +
                    "</svg>",
            newView.output().toString());
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
    assertEquals("<svg width=\"360\" height =\"360\" viewBox=\"200 70 " +
            "360 360\" version=\"1.1\"\n" +
            " xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "\n" +
            "<ellipse id=\"C\" cx=\"70.000000\" cy=\"100.000000\" " +
            "rx=\"25.000000\" ry=\"50.000000\" fill=\"rgb(255, 0, 0)\" visibility=\"visible\">\n" +
            "\n" +
            "\t<animate attributeType=\"xml\" begin=\"1000ms\" " +
            "dur=\"9000ms\" attributeName=\"cx\" from=\"70.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "\t<animate attributeType=\"xml\" begin=\"1000ms\" " +
            "dur=\"9000ms\" attributeName=\"cy\" from=\"100.0\" to=\"70.0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000ms\" " +
            "dur=\"9000ms\" attributeName=\"fill\" from=\"rgb(255,0,0)\" " +
            "to=\"rgb(0,255,0)\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000ms\" " +
            "dur=\"9000ms\" attributeName=\"width\" from=\"25.0\" " +
            "to=\"35.0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000ms\" " +
            "dur=\"9000ms\" attributeName=\"height\" from=\"50.0\" " +
            "to=\"40.0\" fill=\"freeze\" />\n" +
            "\t<animate attributeType=\"xml\" begin=\"10000ms\" " +
            "dur=\"40000ms\" attributeName=\"cx\" from=\"300.0\" " +
            "to=\"210.0\" fill=\"freeze\" />\n" +
            "\t<animate attributeType=\"xml\" begin=\"10000ms\" " +
            "dur=\"40000ms\" attributeName=\"cy\" from=\"70.0\" " +
            "to=\"150.0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10000ms\" " +
            "dur=\"40000ms\" attributeName=\"fill\" from=\"rgb(0,255,0)\" " +
            "to=\"rgb(0,100,100)\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10000ms\" " +
            "dur=\"40000ms\" attributeName=\"width\" from=\"35.0\" " +
            "to=\"60.0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10000ms\" " +
            "dur=\"40000ms\" attributeName=\"height\" from=\"40.0\" " +
            "to=\"50.0\" fill=\"freeze\" />\n" +
            "\n" +
            "</ellipse>\n" +
            "\n" +
            "<rect id=\"R\" x=\"70.000000\" y=\"100.000000\" " +
            "width=\"50.000000\" height=\"100.000000\" fill=\"rgb(255, 0, 0)\" " +
            "visibility=\"visible\">\n" +
            "\n" +
            "\t<animate attributeType=\"xml\" begin=\"1000ms\" " +
            "dur=\"9000ms\" attributeName=\"x\" from=\"70.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "\t<animate attributeType=\"xml\" begin=\"1000ms\" " +
            "dur=\"9000ms\" attributeName=\"y\" from=\"100.0\" to=\"70.0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000ms\" " +
            "dur=\"9000ms\" attributeName=\"fill\" from=\"rgb(255,0,0)\" " +
            "to=\"rgb(0,255,0)\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000ms\" " +
            "dur=\"9000ms\" attributeName=\"width\" from=\"50\" to=\"70\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"1000ms\" " +
            "dur=\"9000ms\" attributeName=\"height\" from=\"100\" to=\"80\" fill=\"freeze\" />\n" +
            "\t<animate attributeType=\"xml\" begin=\"10000ms\" " +
            "dur=\"40000ms\" attributeName=\"x\" from=\"300.0\" " +
            "to=\"210.0\" fill=\"freeze\" />\n" +
            "\t<animate attributeType=\"xml\" begin=\"10000ms\" " +
            "dur=\"40000ms\" attributeName=\"y\" from=\"70.0\" to=\"150.0\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10000ms\" " +
            "dur=\"40000ms\" attributeName=\"fill\" from=\"rgb(0,255,0)\" " +
            "to=\"rgb(0,100,100)\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10000ms\" " +
            "dur=\"40000ms\" attributeName=\"width\" from=\"70\" to=\"120\" fill=\"freeze\" />\n" +
            "    <animate attributeType=\"xml\" begin=\"10000ms\" " +
            "dur=\"40000ms\" attributeName=\"height\" from=\"80\" " +
            "to=\"100\" fill=\"freeze\" />\n" +
            "\n" +
            "</rect>\n" +
            "\n" +
            "</svg>", newView.output().toString());
  }

}
