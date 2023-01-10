import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.Event;
import cs5004.animator.model.State;
import cs5004.animator.model.shapes.Rectangle;
import cs5004.animator.model.shapes.Shape;
import cs5004.animator.model.shapes.ShapeAttribute;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for the class cs5004.animator.model.shapes.Rectangle.
 */
public class RectangleTest {

  Shape rectLuckyNumber7;
  Shape rectangle1;
  Shape rectangle2;
  Shape rectangle3;
  Shape rectangle4;
  Shape rectangle5;

  @Before
  public void setup() {
    this.rectLuckyNumber7 = new Rectangle(1, 2, 10, 20, 30,
            5, 6);
    rectangle1 = new Rectangle(21, 35, 56, 35, 123, 15,
            16);
    rectangle2 = new Rectangle(5, 13, 45, 18, 145, 23,
            12);
    rectangle3 = new Rectangle(18, 8, 9, 231, 81, 34,
            45);
    rectangle4 = new Rectangle(18, 8, 9, 231, 81, 43.5,
            40.12);
    rectangle5 = new Rectangle(18, 8, 9, 231, 81, 12.3,
            33.45);
  }

  /**
   * Test for different constructor.
   */
  @Test
  public void constructorTestRec() {
    State rectStateInit = rectLuckyNumber7.atState(0);
    assertEquals(1.0, rectStateInit.valueFor(ShapeAttribute.POSITION_X), 0.01);
    assertEquals(2.0, rectStateInit.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    assertEquals(10.0, rectStateInit.valueFor(ShapeAttribute.RED), 0.01);
    assertEquals(20.0, rectStateInit.valueFor(ShapeAttribute.GREEN), 0.01);
    assertEquals(30.0, rectStateInit.valueFor(ShapeAttribute.BLUE), 0.01);
    assertEquals(5.0, rectStateInit.valueFor(ShapeAttribute.WIDTH), 0.01);
    assertEquals(6.0, rectStateInit.valueFor(ShapeAttribute.HEIGHT), 0.01);
    assertEquals("POSITION_X: 1.0, POSITION_Y: 2.0, RED: 10.0, GREEN: 20.0, BLUE: 30.0, "
            + "WIDTH: 5.0, HEIGHT: 6.0", rectStateInit.toString());
    State rectStateInit1 = rectangle1.atState(0);
    assertEquals(21.0, rectStateInit1.valueFor(ShapeAttribute.POSITION_X), 0.01);
    assertEquals(35.0, rectStateInit1.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    assertEquals(56.0, rectStateInit1.valueFor(ShapeAttribute.RED), 0.01);
    assertEquals(35.0, rectStateInit1.valueFor(ShapeAttribute.GREEN), 0.01);
    assertEquals(123.0, rectStateInit1.valueFor(ShapeAttribute.BLUE), 0.01);
    assertEquals(15.0, rectStateInit1.valueFor(ShapeAttribute.WIDTH), 0.01);
    assertEquals(16.0, rectStateInit1.valueFor(ShapeAttribute.HEIGHT), 0.01);
    assertEquals("POSITION_X: 21.0, POSITION_Y: 35.0, RED: 56.0, GREEN: 35.0, BLUE: 123.0, "
            + "WIDTH: 15.0, HEIGHT: 16.0", rectStateInit1.toString());
    State rectStateInit2 = rectangle2.atState(0);
    assertEquals(5.0, rectStateInit2.valueFor(ShapeAttribute.POSITION_X), 0.01);
    assertEquals(13.0, rectStateInit2.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    assertEquals(45.0, rectStateInit2.valueFor(ShapeAttribute.RED), 0.01);
    assertEquals(18.0, rectStateInit2.valueFor(ShapeAttribute.GREEN), 0.01);
    assertEquals(145.0, rectStateInit2.valueFor(ShapeAttribute.BLUE), 0.01);
    assertEquals(23.0, rectStateInit2.valueFor(ShapeAttribute.WIDTH), 0.01);
    assertEquals(12.0, rectStateInit2.valueFor(ShapeAttribute.HEIGHT), 0.01);
    assertEquals("POSITION_X: 5.0, POSITION_Y: 13.0, RED: 45.0, GREEN: 18.0, BLUE: "
            + "145.0, WIDTH: 23.0, HEIGHT: 12.0", rectStateInit2.toString());
  }

  /**
   * Add event position X test.
   */
  @Test
  public void addEventPosXTest() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, 0, 1, 10,
            20);
    Event event1 = new Event(ShapeAttribute.POSITION_X, 2, 12, 10,
            20);
    Event event2 = new Event(ShapeAttribute.POSITION_X, 14, 20, 20,
            40);
    Event event3 = new Event(ShapeAttribute.POSITION_X, 40, 60, 20,
            40);
    rectLuckyNumber7.addEvent(event0);
    rectLuckyNumber7.addEvent(event1);
    rectLuckyNumber7.addEvent(event2);
    rectLuckyNumber7.addEvent(event3);
    State rectStateAt2 = rectLuckyNumber7.atState(2);
    assertEquals(10.0, rectStateAt2.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt3 = rectLuckyNumber7.atState(5);
    assertEquals(13.0, rectStateAt3.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt4 = rectLuckyNumber7.atState(13);
    assertEquals(20.0, rectStateAt4.valueFor(ShapeAttribute.POSITION_X), 0.01);

    Event event4 = new Event(ShapeAttribute.POSITION_X, 5, 14, 10,
            20);
    Event event5 = new Event(ShapeAttribute.POSITION_X, 15, 23, 10,
            20);
    Event event6 = new Event(ShapeAttribute.POSITION_X, 26, 40, 20,
            40);
    Event event7 = new Event(ShapeAttribute.POSITION_X, 54, 90, 20,
            40);
    rectangle1.addEvent(event4);
    rectangle1.addEvent(event5);
    rectangle1.addEvent(event6);
    rectangle1.addEvent(event7);
    State rectStateAt5 = rectangle1.atState(10);
    assertEquals(15.55, rectStateAt5.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt6 = rectangle1.atState(15);
    assertEquals(10.0, rectStateAt6.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt7 = rectangle1.atState(13);
    assertEquals(18.89, rectStateAt7.valueFor(ShapeAttribute.POSITION_X), 0.01);

    Event event8 = new Event(ShapeAttribute.POSITION_X, 32, 48, 15,
            34);
    Event event9 = new Event(ShapeAttribute.POSITION_X, 56, 68, 36,
            57);
    Event event10 = new Event(ShapeAttribute.POSITION_X, 76, 91, 23,
            40);
    Event event11 = new Event(ShapeAttribute.POSITION_X, 123, 145, 34,
            45);
    rectangle2.addEvent(event8);
    rectangle2.addEvent(event9);
    rectangle2.addEvent(event10);
    rectangle2.addEvent(event11);
    State rectStateAt8 = rectangle1.atState(23);
    assertEquals(20.0, rectStateAt8.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt9 = rectangle1.atState(12);
    assertEquals(17.77, rectStateAt9.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt10 = rectangle1.atState(49);
    assertEquals(40.0, rectStateAt10.valueFor(ShapeAttribute.POSITION_X), 0.01);
  }

  /**
   * Add event position Y test.
   */
  @Test
  public void addEventPosYTest() {
    Event event0 = new Event(ShapeAttribute.POSITION_Y, 0, 1, 15,
            25);
    Event event1 = new Event(ShapeAttribute.POSITION_Y, 2, 12, 10,
            20);
    Event event2 = new Event(ShapeAttribute.POSITION_Y, 14, 20, 25,
            45);
    Event event3 = new Event(ShapeAttribute.POSITION_Y, 40, 60, 25,
            45);
    rectLuckyNumber7.addEvent(event0);
    rectLuckyNumber7.addEvent(event1);
    rectLuckyNumber7.addEvent(event2);
    rectLuckyNumber7.addEvent(event3);
    State rectStateAt2 = rectLuckyNumber7.atState(2);
    assertEquals(10.0, rectStateAt2.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    State rectStateAt3 = rectLuckyNumber7.atState(3);
    assertEquals(11.0, rectStateAt3.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    State rectStateAt4 = rectLuckyNumber7.atState(13);
    assertEquals(20.0, rectStateAt4.valueFor(ShapeAttribute.POSITION_Y), 0.01);

    Event event4 = new Event(ShapeAttribute.POSITION_Y, 0, 1, 15,
            25);
    Event event5 = new Event(ShapeAttribute.POSITION_Y, 2, 12, 10,
            20);
    Event event6 = new Event(ShapeAttribute.POSITION_Y, 14, 20, 25,
            45);
    Event event7 = new Event(ShapeAttribute.POSITION_Y, 40, 60, 25,
            45);
    rectangle3.addEvent(event4);
    rectangle3.addEvent(event5);
    rectangle3.addEvent(event6);
    rectangle3.addEvent(event7);
    State rectStateAt5 = rectangle3.atState(2);
    assertEquals(10.0, rectStateAt5.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    State rectStateAt6 = rectangle3.atState(3);
    assertEquals(11.0, rectStateAt6.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    State rectStateAt7 = rectangle3.atState(13);
    assertEquals(20.0, rectStateAt7.valueFor(ShapeAttribute.POSITION_Y), 0.01);
  }

  /**
   * Add event position X & Y test.
   */
  @Test
  public void addEventPosXYTest() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, 3, 15, 23,
            32);
    Event event1 = new Event(ShapeAttribute.POSITION_Y, 3, 15, 34,
            42);
    Event event2 = new Event(ShapeAttribute.POSITION_X, 20, 76, 10,
            20);
    Event event3 = new Event(ShapeAttribute.POSITION_Y, 20, 76, 10,
            20);
    Event event4 = new Event(ShapeAttribute.POSITION_X, 87, 96, 35,
            43);
    Event event5 = new Event(ShapeAttribute.POSITION_Y, 87, 96, 35,
            43);
    rectangle1.addEvent(event0);
    rectangle1.addEvent(event1);
    rectangle1.addEvent(event2);
    rectangle1.addEvent(event3);
    rectangle1.addEvent(event4);
    rectangle1.addEvent(event5);
    State rectStateAt1 = rectangle1.atState(4);
    assertEquals(23.75, rectStateAt1.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt2 = rectangle1.atState(11);
    assertEquals(39.33, rectStateAt2.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    State rectStateAt3 = rectangle1.atState(34);
    assertEquals(12.5, rectStateAt3.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt4 = rectangle1.atState(24);
    assertEquals(10.71, rectStateAt4.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    State rectStateAt5 = rectangle1.atState(90);
    assertEquals(37.66, rectStateAt5.valueFor(ShapeAttribute.POSITION_X), 0.01);
    State rectStateAt6 = rectangle1.atState(88);
    assertEquals(35.88, rectStateAt6.valueFor(ShapeAttribute.POSITION_Y), 0.01);
  }

  /**
   * Add event for color.
   */
  @Test
  public void addEventColorTest() {
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
    rectangle1.addEvent(event0);
    rectangle1.addEvent(event1);
    rectangle1.addEvent(event2);
    rectangle1.addEvent(event3);
    rectangle1.addEvent(event4);
    rectangle1.addEvent(event5);
    State rectStateAt1 = rectangle1.atState(6);
    assertEquals(25.25, rectStateAt1.valueFor(ShapeAttribute.RED), 0.01);
    State rectStateAt2 = rectangle1.atState(20);
    assertEquals(34.48, rectStateAt2.valueFor(ShapeAttribute.RED), 0.01);
    State rectStateAt3 = rectangle1.atState(15);
    assertEquals(13.85, rectStateAt3.valueFor(ShapeAttribute.GREEN), 0.01);
    State rectStateAt4 = rectangle1.atState(17);
    assertEquals(15.38, rectStateAt4.valueFor(ShapeAttribute.GREEN), 0.01);
    State rectStateAt5 = rectangle1.atState(27);
    assertEquals(36.14, rectStateAt5.valueFor(ShapeAttribute.BLUE), 0.01);
    State rectStateAt6 = rectangle1.atState(88);
    assertEquals(41.79, rectStateAt6.valueFor(ShapeAttribute.BLUE), 0.01);
  }

  /**
   * Add event for width and height.
   */
  @Test
  public void addWeightHeightTest() {
    Event event0 = new Event(ShapeAttribute.WIDTH, 3, 15, 5,
            10);
    Event event1 = new Event(ShapeAttribute.HEIGHT, 17, 67, 21,
            29);
    Event event2 = new Event(ShapeAttribute.WIDTH, 89, 123, 41,
            52);
    Event event3 = new Event(ShapeAttribute.HEIGHT, 68, 74, 65,
            68);
    Event event4 = new Event(ShapeAttribute.WIDTH, 24, 41, 87,
            62);
    Event event5 = new Event(ShapeAttribute.HEIGHT, 76, 88, 94,
            68);
    rectangle5.addEvent(event0);
    rectangle5.addEvent(event1);
    rectangle5.addEvent(event2);
    rectangle5.addEvent(event3);
    rectangle5.addEvent(event4);
    rectangle5.addEvent(event5);
    State rectStateAt1 = rectangle5.atState(7);
    assertEquals(6.66, rectStateAt1.valueFor(ShapeAttribute.WIDTH), 0.01);
    State rectStateAt2 = rectangle5.atState(20);
    assertEquals(21.48, rectStateAt2.valueFor(ShapeAttribute.HEIGHT), 0.01);
    State rectStateAt3 = rectangle5.atState(95);
    assertEquals(42.94, rectStateAt3.valueFor(ShapeAttribute.WIDTH), 0.01);
    State rectStateAt4 = rectangle5.atState(70);
    assertEquals(66, rectStateAt4.valueFor(ShapeAttribute.HEIGHT), 0.01);
    State rectStateAt5 = rectangle5.atState(27);
    assertEquals(82.59, rectStateAt5.valueFor(ShapeAttribute.WIDTH), 0.01);
    State rectStateAt6 = rectangle5.atState(51);
    assertEquals(26.44, rectStateAt6.valueFor(ShapeAttribute.HEIGHT), 0.01);
  }

  /**
   * Test for overlap X event.
   */
  @Test
  public void overLapXEventAddEventTest1() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, 2, 12, 10,
            20);
    Event event1 = new Event(ShapeAttribute.POSITION_X, 10, 20, 20,
            40);
    try {
      rectLuckyNumber7.addEvent(event0);
      rectLuckyNumber7.addEvent(event1);
    } catch (IllegalArgumentException e) {
      return;
    }
    fail();
  }

  /**
   * Test for overlap X event.
   */
  @Test
  public void overLapXEventAddEventTest2() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, 8, 12, 10,
            20);
    Event event1 = new Event(ShapeAttribute.POSITION_X, 2, 10, 20,
            40);
    try {
      rectLuckyNumber7.addEvent(event0);
      rectLuckyNumber7.addEvent(event1);
    } catch (IllegalArgumentException e) {
      return;
    }
    fail();
  }

  /**
   * Test for overlap Y event.
   */
  @Test
  public void overLapYEventAddEventTest1() {
    Event event0 = new Event(ShapeAttribute.POSITION_Y, 23, 43, 15,
            23);
    Event event1 = new Event(ShapeAttribute.POSITION_Y, 10, 23, 13,
            21);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Y event.
   */
  @Test
  public void overLapYEventAddEventTest2() {
    Event event0 = new Event(ShapeAttribute.POSITION_Y, 19, 33, 15,
            23);
    Event event1 = new Event(ShapeAttribute.POSITION_Y, 31, 34, 13,
            21);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Y event.
   */
  @Test
  public void overLapYEventAddEventTest3() {
    Event event0 = new Event(ShapeAttribute.POSITION_Y, 23, 43, 15,
            23);
    Event event1 = new Event(ShapeAttribute.POSITION_Y, 24, 42, 13,
            21);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Red event.
   */
  @Test
  public void overLapRedEventAddEventTest1() {
    Event event0 = new Event(ShapeAttribute.RED, 67, 87, 21,
            35);
    Event event1 = new Event(ShapeAttribute.RED, 10, 70, 34,
            45);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Red event.
   */
  @Test
  public void overLapRedEventAddEventTest2() {
    Event event0 = new Event(ShapeAttribute.RED, 19, 33, 15,
            23);
    Event event1 = new Event(ShapeAttribute.RED, 30, 34, 13,
            21);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Red event.
   */
  @Test
  public void overLapRedEventAddEventTest3() {
    Event event0 = new Event(ShapeAttribute.RED, 31, 33, 15,
            23);
    Event event1 = new Event(ShapeAttribute.RED, 30, 34, 13,
            21);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Green event.
   */
  @Test
  public void overLapGreenEventAddEventTest1() {
    Event event0 = new Event(ShapeAttribute.GREEN, 37, 123, 45,
            56);
    Event event1 = new Event(ShapeAttribute.GREEN, 5, 80, 34,
            45);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Green event.
   */
  @Test
  public void overLapGreenEventAddEventTest2() {
    Event event0 = new Event(ShapeAttribute.GREEN, 19, 33, 15,
            23);
    Event event1 = new Event(ShapeAttribute.GREEN, 20, 36, 13,
            21);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Blue event.
   */
  @Test
  public void overLapBlueEventAddEventTest1() {
    Event event0 = new Event(ShapeAttribute.BLUE, 67, 87, 21,
            35);
    Event event1 = new Event(ShapeAttribute.BLUE, 10, 70, 34,
            45);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Blue event oval.
   */
  @Test
  public void overLapBlueEventAddEventTest2() {
    Event event0 = new Event(ShapeAttribute.BLUE, 19, 33, 15,
            23);
    Event event1 = new Event(ShapeAttribute.BLUE, 30, 34, 13,
            21);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Width event.
   */
  @Test
  public void overLapWidthEventAddEventTest1() {
    Event event0 = new Event(ShapeAttribute.WIDTH, 45, 124, 21,
            35);
    Event event1 = new Event(ShapeAttribute.WIDTH, 6, 123, 34,
            45);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Width event.
   */
  @Test
  public void overLapWidthEventAddEventTest2() {
    Event event0 = new Event(ShapeAttribute.WIDTH, 19, 33, 15,
            23);
    Event event1 = new Event(ShapeAttribute.WIDTH, 30, 78, 13,
            21);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Height event.
   */
  @Test
  public void overLapHeightEventAddEventTest1() {
    Event event0 = new Event(ShapeAttribute.HEIGHT, 35, 102, 21,
            35);
    Event event1 = new Event(ShapeAttribute.HEIGHT, 6, 123, 34,
            45);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for overlap Height event.
   */
  @Test
  public void overLapHeightEventAddEventTest2() {
    Event event0 = new Event(ShapeAttribute.HEIGHT, 9, 36, 15,
            23);
    Event event1 = new Event(ShapeAttribute.HEIGHT, 20, 31, 13,
            21);
    try {
      rectangle1.addEvent(event0);
      rectangle1.addEvent(event1);
      fail("Invalid will throw an exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("This event collides with an existing event", iae.getMessage());
    }
  }

  /**
   * Test for area of rectangle computation.
   */
  @Test
  public void testAreaRectangle() {
    assertEquals(30, rectLuckyNumber7.areaShape(), 0.01);
    assertEquals(240, rectangle1.areaShape(), 0.01);
    assertEquals(276, rectangle2.areaShape(), 0.01);
    assertEquals(1530, rectangle3.areaShape(), 0.01);
    assertEquals(1745.22, rectangle4.areaShape(), 0.01);
    assertEquals(411.44, rectangle5.areaShape(), 0.01);
  }

  /**
   * Test for perimeter of rectangle computation.
   */
  @Test
  public void testPerimeterRectangle() {
    assertEquals(22, rectLuckyNumber7.perimeterShape(), 0.01);
    assertEquals(62, rectangle1.perimeterShape(), 0.01);
    assertEquals(70, rectangle2.perimeterShape(), 0.01);
    assertEquals(158, rectangle3.perimeterShape(), 0.01);
    assertEquals(167.24, rectangle4.perimeterShape(), 0.01);
    assertEquals(91.5, rectangle5.perimeterShape(), 0.01);
  }

  /**
   * no exception for negative X values.
   */
  @Test
  public void testNegPosX() {
    rectangle5 = new Rectangle(-118, 8, 9,
            231, 81, 12.3, 3.45);
    State rectStateInit = rectangle5.atState(0);
    assertEquals(-118.0, rectStateInit.valueFor(ShapeAttribute.POSITION_X), 0.01);
  }

  /**
   * no exception for negative Y values.
   */
  @Test
  public void testNegPosY() {
    rectangle5 = new Rectangle(9, -10, 9, 231,
            81, 12.3, 3.45);
    State rectStateInit = rectangle5.atState(0);
    assertEquals(-10.0, rectStateInit.valueFor(ShapeAttribute.POSITION_Y), 0.01);
  }

  /**
   * no exception for negative X & Y values.
   */
  @Test
  public void testNegPosXY() {
    rectangle5 = new Rectangle(-9, -10, 9, 231,
            81, 12.3, 3.45);
    State rectStateInit = rectangle5.atState(0);
    assertEquals(-9.0, rectStateInit.valueFor(ShapeAttribute.POSITION_X), 0.01);
    assertEquals(-10.0, rectStateInit.valueFor(ShapeAttribute.POSITION_Y), 0.01);
  }

  /**
   * Exception for negative Red values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRedNegValue() {
    rectangle5 = new Rectangle(9, 8, -23, 231,
            81, 12.3, 3.45);
  }

  /**
   * Exception for above 255 Red values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRedAbove255Value() {
    rectangle5 = new Rectangle(9, 8, 256, 231,
            81, 12.3, 3.45);
  }

  /**
   * Exception for negative Green values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGreenNegValue() {
    rectangle5 = new Rectangle(9, 8, 23, -78,
            81, 12.3, 3.45);
  }

  /**
   * Exception for above 255 Green values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGreenAbove255Value() {
    rectangle5 = new Rectangle(9, 8, 23, 278,
            81, 12.3, 3.45);
  }

  /**
   * Exception for negative Blue values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testBlueNegValue() {
    rectangle5 = new Rectangle(9, 8, 23, 78,
            -81, 12.3, 3.45);
  }

  /**
   * Exception for above 255 Blue values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testBlueAbove255Value() {
    rectangle5 = new Rectangle(9, 8, 23, 78,
            281, 12.3, 3.45);
  }

  /**
   * Exception for negative Width values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testWidthNegValue() {
    rectangle5 = new Rectangle(9, 8, 23, 78,
            82, -12.3, 3.45);
  }

  /**
   * Exception for Zero Width values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testWidthZeroValue() {
    rectangle5 = new Rectangle(9, 8, 23,
            78, 82, 0, 3.45);
  }

  /**
   * Exception for negative Height values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testHeightNegValue() {
    rectangle5 = new Rectangle(9, 8, 23, 78,
            82, 12.3, -3.45);
  }

  /**
   * Exception for Zero Height values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testHeightZeroValue() {
    rectangle5 = new Rectangle(9, 8, 23,
            78, 82, 12.3, 0);
  }

  /**
   * Exception for negative start time.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidStartTime() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, -1, 1, 10,
            20);
  }

  /**
   * Exception for negative end time.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidEndTime() {
    Event event0 = new Event(ShapeAttribute.POSITION_X,  1, -1, 10,
            20);
  }

  /**
   * Exception for start time greater than end time.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidStartEndTime() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, 2, 1, 10,
            20);
  }

  @Test
  public void testCloneRec() {
    State rectStateInit1 = rectangle1.atState(0);
    State newStateRec = rectangle1.clone(rectStateInit1);

    assertEquals(21.0, newStateRec.valueFor(ShapeAttribute.POSITION_X), 0.01);
    assertEquals(35.0, newStateRec.valueFor(ShapeAttribute.POSITION_Y), 0.01);
    assertEquals(56.0, newStateRec.valueFor(ShapeAttribute.RED), 0.01);
    assertEquals(35.0, newStateRec.valueFor(ShapeAttribute.GREEN), 0.01);
    assertEquals(123.0, newStateRec.valueFor(ShapeAttribute.BLUE), 0.01);
    assertEquals(15.0, newStateRec.valueFor(ShapeAttribute.WIDTH), 0.01);
    assertEquals(16.0, newStateRec.valueFor(ShapeAttribute.HEIGHT), 0.01);
    assertEquals("POSITION_X: 21.0, POSITION_Y: 35.0, RED: 56.0, GREEN: 35.0, BLUE: 123.0, "
            + "WIDTH: 15.0, HEIGHT: 16.0", newStateRec.toString());
  }

}

