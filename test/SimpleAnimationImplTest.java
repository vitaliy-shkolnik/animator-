import org.junit.Before;
import org.junit.Test;

import java.util.List;

import cs5004.animator.model.Event;
import cs5004.animator.model.SimpleAnimation;
import cs5004.animator.model.SimpleAnimationImpl;
import cs5004.animator.model.State;
import cs5004.animator.model.shapes.Oval;
import cs5004.animator.model.shapes.Rectangle;
import cs5004.animator.model.shapes.Shape;
import cs5004.animator.model.shapes.ShapeAttribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests for SimpleAnimationImpl. checks the methods to ensure functionality.
 */
public class SimpleAnimationImplTest {
  SimpleAnimation animationSoyuz;
  SimpleAnimation animationApollo;

  Shape rectangleAleatory;
  Shape rectangleOrder;

  Shape rectangle1;
  Shape rectangle2;
  Shape rectangle3;
  Shape oval1;
  Shape oval2;
  Shape oval3;

  @Before
  public void setup() {

    rectangle1 = new Rectangle(21, 35, 56, 35, 123,
            15, 16);
    rectangle2 = new Rectangle(5, 13, 45, 18, 145,
            23, 12);
    rectangle3 = new Rectangle(18, 8, 9, 231, 81,
            34, 45);

    oval1 = new Oval(2, 3, 30, 40, 70,
            8, 9);

    oval2 = new Oval(6, 16, 30, 40, 70,
            8, 9);

    oval3 = new Oval(8, 65, 30, 40, 70,
            8, 9);

    animationSoyuz = new SimpleAnimationImpl(0, 0, 100, 100);
    animationSoyuz.addShape(rectangle1);
    animationSoyuz.addShape(rectangle2);
    animationSoyuz.addShape(rectangle3);
    animationSoyuz.addShape(oval1);
    animationSoyuz.addShape(oval2);
    animationSoyuz.addShape(oval3);
  }

  @Test
  public void constructorTest() {

    List<Shape> newList = animationSoyuz.listShapes();
    int newListSize = newList.size();
    assertEquals(6, newListSize);
    assertEquals(rectangle2, animationSoyuz.getShape(1));
    assertEquals(oval3, animationSoyuz.getShape(5));
  }


  @Test
  public void addShapeTest() {
    rectangleAleatory = new Rectangle(21, 35, 56, 35, 123,
            15, 16);

    animationSoyuz.addShape(rectangleAleatory);
    assertEquals(rectangleAleatory, animationSoyuz.getShape(6));
  }

  @Test
  public void insertShapeTest() {
    rectangleAleatory = new Rectangle(21, 35, 56, 35, 123,
            15, 16);

    animationSoyuz.insertShape(0, rectangleAleatory);
    assertEquals(rectangleAleatory, animationSoyuz.getShape(0));
    assertEquals(rectangle1, animationSoyuz.getShape(1));
  }

  @Test
  public void insertShapeFailLessThanZeroTest() {

    rectangleAleatory = new Rectangle(21, 35, 56, 35, 123,
            15, 16);
    try {
      animationSoyuz.insertShape(-1, rectangleAleatory);

    } catch (IllegalArgumentException e) {
      return;
    }
    fail();
  }

  @Test
  public void insertShapeFailGreaterListSizeTest() {

    rectangleAleatory = new Rectangle(21, 35, 56, 35, 123,
            15, 16);
    try {
      animationSoyuz.insertShape(8, rectangleAleatory);

    } catch (IllegalArgumentException e) {
      return;
    }
    fail();
  }

  @Test
  public void listShapeTest() {
    List<Shape> newList = animationSoyuz.listShapes();
    int newListSize = newList.size();
    assertEquals(6, newListSize);
    assertEquals(rectangle2, animationSoyuz.getShape(1));
    assertEquals(oval3, animationSoyuz.getShape(5));

  }

  @Test
  public void removeShapeSuccessTest() {

    List<Shape> testList = animationSoyuz.listShapes();
    assertEquals(6, testList.size());
    assertTrue(animationSoyuz.removeShape(oval3));
    List<Shape> testListAfter = animationSoyuz.listShapes();
    assertEquals(5, testListAfter.size());

  }

  @Test
  public void removeShapeFailTest() {

    List<Shape> testList = animationSoyuz.listShapes();
    assertEquals(6, testList.size());
    assertFalse(animationSoyuz.removeShape(rectangleOrder));
    List<Shape> testListAfter = animationSoyuz.listShapes();
    assertEquals(6, testListAfter.size());
  }

  @Test
  public void getShapeTest() {
    assertEquals(oval3, animationSoyuz.getShape(5));
  }

  @Test
  public void getShapeOutOfIndexNegativeTest() {

    rectangleAleatory = new Rectangle(21, 35, 56, 35, 123,
            15, 16);
    try {
      animationSoyuz.getShape(-8);

    } catch (IllegalArgumentException e) {
      return;
    }
    fail();
  }

  @Test
  public void getShapeOutOfIndexGreaterListSizeTest() {

    rectangleAleatory = new Rectangle(21, 35, 56, 35, 123,
            15, 16);
    try {
      animationSoyuz.getShape(8);

    } catch (IllegalArgumentException e) {
      return;
    }
    fail();
  }


  @Test
  public void frameAtTic() {
    Event event0 = new Event(ShapeAttribute.POSITION_X, 2, 12, 10, 20);
    Event event1 = new Event(ShapeAttribute.POSITION_Y, 2, 12, 10, 20);
    Event event2 = new Event(ShapeAttribute.RED, 2, 12, 20, 40);
    Event event3 = new Event(ShapeAttribute.GREEN, 2, 12, 20, 40);
    Event event4 = new Event(ShapeAttribute.BLUE, 2, 12, 10, 20);
    Event event6 = new Event(ShapeAttribute.WIDTH, 2, 12, 20, 40);
    Event event7 = new Event(ShapeAttribute.HEIGHT, 2, 12, 20, 40);
    rectangle1.addEvent(event0);
    rectangle1.addEvent(event1);
    rectangle1.addEvent(event2);
    rectangle1.addEvent(event3);
    rectangle1.addEvent(event4);
    rectangle1.addEvent(event6);
    rectangle1.addEvent(event7);

    oval1.addEvent(event0);
    oval1.addEvent(event1);
    oval1.addEvent(event2);
    oval1.addEvent(event3);
    oval1.addEvent(event4);
    oval1.addEvent(event6);
    oval1.addEvent(event7);

    animationApollo = new SimpleAnimationImpl(0, 0, 100, 100);
    animationApollo.addShape(rectangle1);
    animationApollo.addShape(oval1);

    //rectangle1 state
    List<State> listOfStatesTime0 = animationApollo.frameAtTic(0);
    State object0State0 = listOfStatesTime0.get(0);
    assertEquals("POSITION_X: 21.0, POSITION_Y: 35.0, RED: 56.0, GREEN: 35.0," +
            " BLUE: 123.0, WIDTH: 15.0, HEIGHT: 16.0", object0State0.toString());

    //oval1 state
    State object1State0 = listOfStatesTime0.get(1);
    assertEquals("POSITION_X: 2.0, POSITION_Y: 3.0, RED: 30.0, GREEN: 40.0," +
            " BLUE: 70.0, WIDTH: 8.0, HEIGHT: 9.0", object1State0.toString());


    //rectangle1 state be the same at time 1. No event happening until time 2.
    List<State> listOfStatesTime1 = animationApollo.frameAtTic(1);
    State object0State1 = listOfStatesTime1.get(0);
    assertEquals("POSITION_X: 21.0, POSITION_Y: 35.0, RED: 56.0, GREEN: 35.0," +
            " BLUE: 123.0, WIDTH: 15.0, HEIGHT: 16.0", object0State1.toString());

    //rectangle1 state be the same at time 2. Values must match next event at start 0.
    List<State> listOfStatesTime2 = animationApollo.frameAtTic(2);
    State object0State2 = listOfStatesTime2.get(0);
    assertEquals("POSITION_X: 10.0, POSITION_Y: 10.0, RED: 20.0, GREEN: 20.0," +
            " BLUE: 10.0, WIDTH: 20.0, HEIGHT: 20.0", object0State2.toString());

    ////rectangle1 state be the same at time 3. Values extrapolate by 1 second.
    List<State> listOfStatesTime3 = animationApollo.frameAtTic(3);
    State object0State3 = listOfStatesTime3.get(0);
    assertEquals("POSITION_X: 11.0, POSITION_Y: 11.0, RED: 22.0, GREEN: 22.0," +
            " BLUE: 11.0, WIDTH: 22.0, HEIGHT: 22.0", object0State3.toString());

    //rectangle1 state be the same at time 15. Values be last endValues.
    List<State> listOfStatesTime4 = animationApollo.frameAtTic(15);
    State object0State15 = listOfStatesTime4.get(0);
    assertEquals("POSITION_X: 20.0, POSITION_Y: 20.0, RED: 40.0, GREEN: 40.0," +
            " BLUE: 20.0, WIDTH: 40.0, HEIGHT: 40.0", object0State15.toString());

  }

  @Test
  public void frameAtTicFail() {

    try {
      animationSoyuz.frameAtTic(-1);

    } catch (IllegalArgumentException e) {
      return;
    }
    fail();
  }
}