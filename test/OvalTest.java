import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.Event;
import cs5004.animator.model.State;
import cs5004.animator.model.shapes.Oval;
import cs5004.animator.model.shapes.Rectangle;
import cs5004.animator.model.shapes.Shape;
import cs5004.animator.model.shapes.ShapeAttribute;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the class cs5004.animator.model.shapes.Rectangle.
 */
public class OvalTest {
  Shape ovalShape1;
  Shape ovalShape2;
  Shape ovalShape3;
  Shape ovalShape4;
  Shape ovalShape5;

  @Before
  public void setup() {
    ovalShape1 = new Oval(2, 3, 30, 40, 70, 8, 9
    );
    ovalShape2 = new Oval(-21, 31, 56, 71, 45, 15, 19
    );
    ovalShape3 = new Oval(12, -3, 13, 34, 213, 38, 59
    );
    ovalShape4 = new Oval(-5, -10, 123, 140, 154, 5, 12
    );
    ovalShape5 = new Oval(23, 33, 130, 250, 41, 18, 29
    );
  }

  @Test
  public void constructorTestOval() {
    State rectStateInit1 = ovalShape1.atState(1);
    assertEquals(2.0, rectStateInit1.valueFor(ShapeAttribute.POSITION_X), 0.0001);
    assertEquals(3.0, rectStateInit1.valueFor(ShapeAttribute.POSITION_Y), 0.0001);
    assertEquals(30.0, rectStateInit1.valueFor(ShapeAttribute.RED), 0.0001);
    assertEquals(40.0, rectStateInit1.valueFor(ShapeAttribute.GREEN), 0.0001);
    assertEquals(70.0, rectStateInit1.valueFor(ShapeAttribute.BLUE), 0.0001);
    assertEquals(8.0, rectStateInit1.valueFor(ShapeAttribute.WIDTH), 0.0001);
    assertEquals(9.0, rectStateInit1.valueFor(ShapeAttribute.HEIGHT), 0.0001);
    assertEquals("POSITION_X: 2.0, POSITION_Y: 3.0, RED: 30.0, GREEN: 40.0, BLUE: 70.0, "
            + "WIDTH: 8.0, HEIGHT: 9.0", rectStateInit1.toString());
    State rectStateInit2 = ovalShape3.atState(3);
    assertEquals(12.0, rectStateInit2.valueFor(ShapeAttribute.POSITION_X), 0.0001);
    assertEquals(-3.0, rectStateInit2.valueFor(ShapeAttribute.POSITION_Y), 0.0001);
    assertEquals(13.0, rectStateInit2.valueFor(ShapeAttribute.RED), 0.0001);
    assertEquals(34.0, rectStateInit2.valueFor(ShapeAttribute.GREEN), 0.0001);
    assertEquals(213.0, rectStateInit2.valueFor(ShapeAttribute.BLUE), 0.0001);
    assertEquals(38.0, rectStateInit2.valueFor(ShapeAttribute.WIDTH), 0.0001);
    assertEquals(59.0, rectStateInit2.valueFor(ShapeAttribute.HEIGHT), 0.0001);
    assertEquals("POSITION_X: 12.0, POSITION_Y: -3.0, RED: 13.0, GREEN: 34.0, BLUE: 213.0, "
            + "WIDTH: 38.0, HEIGHT: 59.0", rectStateInit2.toString());
    State rectStateInit3 = ovalShape4.atState(14);
    assertEquals(-5.0, rectStateInit3.valueFor(ShapeAttribute.POSITION_X), 0.0001);
    assertEquals(-10.0, rectStateInit3.valueFor(ShapeAttribute.POSITION_Y), 0.0001);
    assertEquals(123.0, rectStateInit3.valueFor(ShapeAttribute.RED), 0.0001);
    assertEquals(140.0, rectStateInit3.valueFor(ShapeAttribute.GREEN), 0.0001);
    assertEquals(154.0, rectStateInit3.valueFor(ShapeAttribute.BLUE), 0.0001);
    assertEquals(5.0, rectStateInit3.valueFor(ShapeAttribute.WIDTH), 0.0001);
    assertEquals(12.0, rectStateInit3.valueFor(ShapeAttribute.HEIGHT), 0.0001);
    assertEquals("POSITION_X: -5.0, POSITION_Y: -10.0, RED: 123.0, GREEN: 140.0, BLUE: 154.0, "
            + "WIDTH: 5.0, HEIGHT: 12.0", rectStateInit3.toString());
  }

  /**
   * add event position X test oval.
   */
  @Test
  public void addEventPosXTestOval() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, 0, 3, 11,
            21);
    Event event1 = new Event(ShapeAttribute.POSITION_X, 5, 19, 11,
            21);
    Event event2 = new Event(ShapeAttribute.POSITION_X, 25, 48, 21,
            41);
    Event event3 = new Event(ShapeAttribute.POSITION_X, 54, 60, 21,
            41);
    ovalShape3.addEvent(event0);
    ovalShape3.addEvent(event1);
    ovalShape3.addEvent(event2);
    ovalShape3.addEvent(event3);
    State rectStateAt2 = ovalShape3.atState(2);
    assertEquals(17.66, rectStateAt2.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt3 = ovalShape3.atState(10);
    assertEquals(14.57, rectStateAt3.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt4 = ovalShape3.atState(41);
    assertEquals(34.91, rectStateAt4.valueFor(ShapeAttribute.POSITION_X), 0.01);

    Event event4 = new Event(ShapeAttribute.POSITION_X, 62, 75, 10,
            20);
    Event event5 = new Event(ShapeAttribute.POSITION_X, 78, 84, 10,
            20);
    Event event6 = new Event(ShapeAttribute.POSITION_X, 87, 95, 20,
            40);
    Event event7 = new Event(ShapeAttribute.POSITION_X, 98, 104, 20,
            40);
    ovalShape4.addEvent(event4);
    ovalShape4.addEvent(event5);
    ovalShape4.addEvent(event6);
    ovalShape4.addEvent(event7);
    State rectStateAt5 = ovalShape4.atState(70);
    assertEquals(16.15, rectStateAt5.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt6 = ovalShape4.atState(76);
    assertEquals(20.0, rectStateAt6.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt7 = ovalShape4.atState(56);
    assertEquals(-5.0, rectStateAt7.valueFor(ShapeAttribute.POSITION_X), 0.01);

    Event event8 = new Event(ShapeAttribute.POSITION_X, 32, 48, 15,
            34);
    Event event9 = new Event(ShapeAttribute.POSITION_X, 56, 68, 36,
            57);
    Event event10 = new Event(ShapeAttribute.POSITION_X, 76, 91, 23,
            40);
    Event event11 = new Event(ShapeAttribute.POSITION_X, 123, 145, 34,
            45);
    ovalShape1.addEvent(event8);
    ovalShape1.addEvent(event9);
    ovalShape1.addEvent(event10);
    ovalShape1.addEvent(event11);
    State rectStateAt8 = ovalShape1.atState(35);
    assertEquals(18.56, rectStateAt8.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt9 = ovalShape1.atState(61);
    assertEquals(44.75, rectStateAt9.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt10 = ovalShape1.atState(85);
    assertEquals(33.2, rectStateAt10.valueFor(ShapeAttribute.POSITION_X), 0.01);
  }

  /**
   * add event position X & Y test oval.
   */
  @Test
  public void addEventPosXYTestOval() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, 3, 15, 23,
            32);
    Event event1 = new Event(ShapeAttribute.POSITION_Y, 5, 25, 34,
            42);
    Event event2 = new Event(ShapeAttribute.POSITION_X, 20, 76, 10,
            20);
    Event event3 = new Event(ShapeAttribute.POSITION_Y, 26, 74, 10,
            20);
    Event event4 = new Event(ShapeAttribute.POSITION_X, 87, 96, 35,
            43);
    Event event5 = new Event(ShapeAttribute.POSITION_Y, 88, 108, 35,
            43);
    ovalShape1.addEvent(event0);
    ovalShape1.addEvent(event1);
    ovalShape1.addEvent(event2);
    ovalShape1.addEvent(event3);
    ovalShape1.addEvent(event4);
    ovalShape1.addEvent(event5);
    State rectStateAt1 = ovalShape1.atState(10);
    assertEquals(28.25, rectStateAt1.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt2 = ovalShape1.atState(22);
    assertEquals(40.8, rectStateAt2.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    State rectStateAt3 = ovalShape1.atState(37);
    assertEquals(13.03, rectStateAt3.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt4 = ovalShape1.atState(30);
    assertEquals(10.83, rectStateAt4.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    State rectStateAt5 = ovalShape1.atState(90);
    assertEquals(37.66, rectStateAt5.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt6 = ovalShape1.atState(92);
    assertEquals(36.6, rectStateAt6.valueFor(ShapeAttribute.POSITION_Y), 0.01);
  }

  /**
   * add event for color oval.
   */
  @Test
  public void addEventColorTestOval() {
    Event event0 = new Event(ShapeAttribute.RED, 3, 15, 23,
            32);
    Event event1 = new Event(ShapeAttribute.RED, 17, 67, 34,
            42);
    Event event2 = new Event(ShapeAttribute.GREEN, 10, 23, 10,
            20);
    Event event3 = new Event(ShapeAttribute.GREEN, 35, 68, 10,
            20);
    Event event4 = new Event(ShapeAttribute.BLUE, 25, 39, 35,
            43);
    Event event5 = new Event(ShapeAttribute.BLUE, 43, 96, 35,
            43);
    ovalShape1.addEvent(event0);
    ovalShape1.addEvent(event1);
    ovalShape1.addEvent(event2);
    ovalShape1.addEvent(event3);
    ovalShape1.addEvent(event4);
    ovalShape1.addEvent(event5);
    State rectStateAt1 = ovalShape1.atState(2);
    assertEquals(30.0, rectStateAt1.valueFor(ShapeAttribute.RED), 0.01);
    State rectStateAt2 = ovalShape1.atState(11);
    assertEquals(29.0, rectStateAt2.valueFor(ShapeAttribute.RED), 0.01);
    State rectStateAt3 = ovalShape1.atState(8);
    assertEquals(40.0, rectStateAt3.valueFor(ShapeAttribute.GREEN), 0.01);
    State rectStateAt4 = ovalShape1.atState(32);
    assertEquals(20.0, rectStateAt4.valueFor(ShapeAttribute.GREEN), 0.01);
    State rectStateAt5 = ovalShape1.atState(21);
    assertEquals(70.0, rectStateAt5.valueFor(ShapeAttribute.BLUE), 0.01);
    State rectStateAt6 = ovalShape1.atState(34);
    assertEquals(40.14, rectStateAt6.valueFor(ShapeAttribute.BLUE), 0.01);
  }

  /**
   * add event for width and height oval.
   */
  @Test
  public void addWeightHeightTestOval() {
    Event event0 = new Event(ShapeAttribute.WIDTH, 13, 25, 5,
            10);
    Event event1 = new Event(ShapeAttribute.HEIGHT, 37, 67, 21,
            29);
    Event event2 = new Event(ShapeAttribute.WIDTH, 79, 85, 41,
            52);
    Event event3 = new Event(ShapeAttribute.HEIGHT, 87, 99, 65,
            68);
    Event event4 = new Event(ShapeAttribute.WIDTH, 101, 123, 87,
            62);
    Event event5 = new Event(ShapeAttribute.HEIGHT, 134, 145, 94,
            68);
    ovalShape5.addEvent(event0);
    ovalShape5.addEvent(event1);
    ovalShape5.addEvent(event2);
    ovalShape5.addEvent(event3);
    ovalShape5.addEvent(event4);
    ovalShape5.addEvent(event5);
    State rectStateAt1 = ovalShape5.atState(15);
    assertEquals(5.83, rectStateAt1.valueFor(ShapeAttribute.WIDTH), 0.01);
    State rectStateAt2 = ovalShape5.atState(40);
    assertEquals(21.8, rectStateAt2.valueFor(ShapeAttribute.HEIGHT), 0.01);
    State rectStateAt3 = ovalShape5.atState(83);
    assertEquals(48.33, rectStateAt3.valueFor(ShapeAttribute.WIDTH), 0.01);
    State rectStateAt4 = ovalShape5.atState(90);
    assertEquals(65.75, rectStateAt4.valueFor(ShapeAttribute.HEIGHT), 0.01);
    State rectStateAt5 = ovalShape5.atState(110);
    assertEquals(76.77, rectStateAt5.valueFor(ShapeAttribute.WIDTH), 0.01);
    State rectStateAt6 = ovalShape5.atState(142);
    assertEquals(75.09, rectStateAt6.valueFor(ShapeAttribute.HEIGHT), 0.01);
  }

  /**
   * test for overlap X event oval.
   */
  @Test
  public void overLapXEventAddEventTestOval() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, 8, 12, 10,
            20);
    Event event1 = new Event(ShapeAttribute.POSITION_X, 2, 10, 20,
            40);
    try {
      ovalShape1.addEvent(event0);
      ovalShape1.addEvent(event1);
    } catch (IllegalArgumentException e) {
      return;
    }
    fail();
  }

  /**
   * test for overlap Y event oval.
   */
  @Test
  public void overLapYEventAddEventTestOval() {
    Event event0 = new Event(ShapeAttribute.POSITION_Y, 23, 43, 15,
            23);
    Event event1 = new Event(ShapeAttribute.POSITION_Y, 43, 56, 13,
            21);
    try {
      ovalShape4.addEvent(event0);
      ovalShape4.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * test for overlap Red event oval.
   */
  @Test
  public void overLapRedEventAddEventTestOval() {
    Event event0 = new Event(ShapeAttribute.RED, 67, 87, 21,
            35);
    Event event1 = new Event(ShapeAttribute.RED, 10, 67, 34,
            45);
    try {
      ovalShape2.addEvent(event0);
      ovalShape2.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * test for overlap Green event oval.
   */
  @Test
  public void overLapGreenEventAddEventTestOval() {
    Event event0 = new Event(ShapeAttribute.GREEN, 37, 74, 45,
            56);
    Event event1 = new Event(ShapeAttribute.GREEN, 5, 80, 34,
            45);
    try {
      ovalShape3.addEvent(event0);
      ovalShape3.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * test for overlap Blue event oval.
   */
  @Test
  public void overLapBlueEventAddEventTestOval() {
    Event event0 = new Event(ShapeAttribute.BLUE, 19, 33, 15,
            23);
    Event event1 = new Event(ShapeAttribute.BLUE, 30, 34, 13,
            21);
    try {
      ovalShape1.addEvent(event0);
      ovalShape1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * test for overlap Width event oval.
   */
  @Test
  public void overLapWidthEventAddEventTestOval() {
    Event event0 = new Event(ShapeAttribute.WIDTH, 45, 124, 21,
            35);
    Event event1 = new Event(ShapeAttribute.WIDTH, 6, 46, 34,
            45);
    try {
      ovalShape2.addEvent(event0);
      ovalShape2.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * test for overlap Height event oval.
   */
  @Test
  public void overLapHeightEventAddEventTestOval() {
    Event event0 = new Event(ShapeAttribute.HEIGHT, 9, 36, 15,
            23);
    Event event1 = new Event(ShapeAttribute.HEIGHT, 20, 31, 13,
            21);
    try {
      ovalShape4.addEvent(event0);
      ovalShape4.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * test for oval area.
   */
  @Test
  public void testAreaOval() {
    assertEquals(226.19, ovalShape1.areaShape(), 0.01);
    assertEquals(895.35, ovalShape2.areaShape(), 0.01);
    assertEquals(7043.45, ovalShape3.areaShape(), 0.01);
    assertEquals(188.49, ovalShape4.areaShape(), 0.01);
    assertEquals(1639.91, ovalShape5.areaShape(), 0.01);
  }

  /**
   * test for perimeter oval.
   */
  @Test
  public void testPerimeterOval() {
    assertEquals(53.50, ovalShape1.perimeterShape(),0.01);
    assertEquals(107.55, ovalShape2.perimeterShape(),0.01);
    assertEquals(311.79, ovalShape3.perimeterShape(),0.01);
    assertEquals(57.76, ovalShape4.perimeterShape(),0.01);
    assertEquals(151.64, ovalShape5.perimeterShape(),0.01);
  }

  /**
   * No exception for negative X values oval.
   */
  @Test
  public void testNegPosXOval() {
    ovalShape4 = new Rectangle(-1, 8, 9, 231,
            81, 12.3, 3.45);
    State rectStateInit = ovalShape4.atState(2);
    assertEquals(-1.0, rectStateInit.valueFor(ShapeAttribute.POSITION_X), 0.01);
  }

  /**
   * No exception for negative Y values oval.
   */
  @Test
  public void testNegPosYOval() {
    ovalShape4 = new Rectangle(9, -90, 9, 231,
            81, 12.3, 3.45);
    State rectStateInit = ovalShape4.atState(4);
    assertEquals(-90.0, rectStateInit.valueFor(ShapeAttribute.POSITION_Y), 0.01);
  }

  /**
   * no exception for negative X & Y values oval.
   */
  @Test
  public void testNegPosXYOval() {
    ovalShape2 = new Rectangle(-29, -101, 9, 231,
            81, 12.3, 3.45);
    State rectStateInit = ovalShape2.atState(6);
    assertEquals(-29.0, rectStateInit.valueFor(ShapeAttribute.POSITION_X), 0.01);
    assertEquals(-101.0, rectStateInit.valueFor(ShapeAttribute.POSITION_Y), 0.01);
  }

  /**
   * exception for negative Green values oval.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGreenNegValueOval() {
    ovalShape2 = new Rectangle(9, 8, 23, -78, 81,
            12.3, 3.45);
  }

  /**
   * exception for negative Blue values oval.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testBlueNegValueOval() {
    ovalShape3 = new Rectangle(9, 8, 23, 78, -81,
            12.3, 3.45);
  }

  /**
   * exception for negative Width values oval.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testWidthNegValueOval() {
    ovalShape1 = new Rectangle(9, 8, 23, 78, 82,
            -12.3, 3.45);
  }

  /**
   * exception for Zero Width values oval.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testWidthZeroValueOval() {
    ovalShape1 = new Rectangle(9, 8, 23, 78, 82,
            0, 3.45);
  }

  /**
   * exception for negative Height values oval.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testHeightNegValueOval() {
    ovalShape1 = new Rectangle(9, 8, 23, 78, 82, 12.3, -3.45);
  }

  /**
   * exception for Zero height values oval.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testHeightZeroValueOval() {
    ovalShape1 = new Rectangle(9, 8, 23, 78, 82, 12.3, 0);
  }

  /**
   * exception for negative start time oval.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidStartTimeOval() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, -1, 1, 10,
            20);
  }

  /**
   * exception for negative end time oval.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidEndTimeOval() {
    Event event0 = new Event(ShapeAttribute.POSITION_X,  1, -1, 10,
            20);
  }

  /**
   * exception for start time greater than end time oval.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidStartEndTimeOval() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, 2, 1, 10,
            20);
  }
}
