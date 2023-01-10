package cs5004.animator.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cs5004.animator.model.shapes.Oval;
import cs5004.animator.model.shapes.Rectangle;
import cs5004.animator.model.shapes.Shape;
import cs5004.animator.model.shapes.ShapeAttribute;
import cs5004.animator.util.AnimationBuilder;

/**
 * cs5004.animator.model.SimpleAnimationImpl class to represent animation. List stores all Shapes.
 * Each Shape object contains events SimpleAnimation Impl
 * can list Shapes, addShape, removeShape.
 */
public class SimpleAnimationImpl implements SimpleAnimation {
  private final int x;
  private final int y;
  private final int width;
  private final int height;

  /**
   * SimpleAnimationImpl constructor.
   * @param x      an int; represents the starting x coordinate.
   * @param y      an int; represents the starting y coordinate.
   * @param width  an int; represents the width of the shape.
   * @param height an int; represents the height of the shape.
   */
  public SimpleAnimationImpl(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  //<SimpleAnimationImpl> gets put into doc inside AnimationBuilder.
  //nothing needs to change in Interface?
  //you can put a class within a class. It's static.

  /**
   * The Builder class that will implement the AnimationBuilder to take in shape/event data.
   */
  public static final class Builder implements AnimationBuilder<SimpleAnimationImpl> {
    private int x;
    private int y;
    private int width;
    private int height;

    private final Map<String, Shape> shapes = new LinkedHashMap<>();

    /**
     * Method to build a SimpleAnimationImpl object containing all shapes and events.
     *
     * @return a SimpleAnimationImpl object.
     */
    @Override
    public SimpleAnimationImpl build() {
      SimpleAnimationImpl impl = new SimpleAnimationImpl(x, y, width, height);

      // add all the shapes, etc.
      for (Shape shape : shapes.values()) {
        impl.addShape(shape);
      }
      return impl;
    }

    /**
     * Method to set the bounds of the bounding box.
     *
     * @param x      The leftmost x value.
     * @param y      The topmost y value.
     * @param width  The width of the bounding box.
     * @param height The height of the bounding box.
     * @return Return this.
     */
    @Override
    public AnimationBuilder<SimpleAnimationImpl> setBounds(int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      return this;
    }

    /**
     * Method to declare the type of shape being added.
     *
     * @param name The unique name of the shape to be added. No shape with this name should already
     *             exist.
     * @param type The type of shape (e.g. "ellipse", "rectangle") to be added. The set of supported
     *             shapes is unspecified, but should include "ellipse" and "rectangle" as a
     *             minimum.
     * @return Return this.
     */
    @Override
    public AnimationBuilder<SimpleAnimationImpl> declareShape(String name, String type) {
      switch (type.toLowerCase()) {
        case "rectangle":
          shapes.put(name, new Rectangle(name));
          break;
        case "ellipse":
        case "oval":
          shapes.put(name, new Oval(name));
          break;
        default:
          throw new IllegalArgumentException("Unsupported type");
      }
      return this;
    }

    /**
     * Method to add a motion to a shape.
     *
     * @param name The name of the shape (added with {@link AnimationBuilder#declareShape}).
     * @param t1   The start time of this transformation.
     * @param x1   The initial x-position of the shape.
     * @param y1   The initial y-position of the shape.
     * @param w1   The initial width of the shape.
     * @param h1   The initial height of the shape.
     * @param r1   The initial red color-value of the shape.
     * @param g1   The initial green color-value of the shape.
     * @param b1   The initial blue color-value of the shape.
     * @param t2   The end time of this transformation.
     * @param x2   The final x-position of the shape.
     * @param y2   The final y-position of the shape.
     * @param w2   The final width of the shape.
     * @param h2   The final height of the shape.
     * @param r2   The final red color-value of the shape.
     * @param g2   The final green color-value of the shape.
     * @param b2   The final blue color-value of the shape.
     * @return Return this.
     */
    @Override
    public AnimationBuilder<SimpleAnimationImpl> addMotion(String name, int t1, int x1,
                                                           int y1, int w1, int h1, int r1,
                                                           int g1, int b1, int t2, int x2, int y2,
                                                           int w2, int h2, int r2, int g2, int b2) {
      if (!shapes.containsKey(name)) {
        throw new IllegalArgumentException("Unknown shape");
      }

      Shape shape = shapes.get(name);
      Event xPos = new Event(ShapeAttribute.POSITION_X, t1, t2, x1, x2);
      Event yPos = new Event(ShapeAttribute.POSITION_Y, t1, t2, y1, y2);
      Event red = new Event(ShapeAttribute.RED, t1, t2, r1, r2);
      Event green = new Event(ShapeAttribute.GREEN, t1, t2, g1, g2);
      Event blue = new Event(ShapeAttribute.BLUE, t1, t2, b1, b2);
      Event width = new Event(ShapeAttribute.WIDTH, t1, t2, w1, w2);
      Event height = new Event(ShapeAttribute.HEIGHT, t1, t2, h1, h2);

      shape.addEvent(xPos);
      shape.addEvent(yPos);
      shape.addEvent(red);
      shape.addEvent(green);
      shape.addEvent(blue);
      shape.addEvent(width);
      shape.addEvent(height);

      return this;
    }
  }

  protected final List<Shape> shapes = new ArrayList<>();

  /**
   * Method to return the List of shapes.
   * @return shapes; an ArrayList containing Shape objects.
   */
  @Override
  public List<Shape> listShapes() {
    return shapes;
  }

  /**
   * Method to add shapes to the ArrayList.
   *
   * @param shape represents a shape. Of cs5004.animator.model.shapes.Shape class.
   */
  @Override
  public void addShape(Shape shape) {
    shapes.add(shape);
  }

  /**
   * Method to insert a shape into the ArrayList.
   * @param index represents index. An int.
   * @param shape represents shape. Of Shape class.
   * @throws IllegalArgumentException if the index is out of range.
   */
  @Override
  public void insertShape(int index, Shape shape) throws IllegalArgumentException {
    if (index < 0 || index > shapes.size()) {
      throw new IllegalArgumentException("your index is out of range.");
    }
    shapes.add(index, shape);
  }

  /**
   * Method to remove a shape from the list.
   * @param shape represents a shape. Of cs5004.animator.model.shapes.Shape class.
   * @return boolean; returns true if the size of the list is greater than shapes.size.
   */
  @Override
  public boolean removeShape(Shape shape) {
    int sizeList = shapes.size();
    shapes.remove(shape);
    return sizeList > shapes.size();
  }

  /**
   * Method to return the frame at a time Tick.
   * @param time an int; represents the time currently being viewed.
   * @return states; a list of State objects.
   * @throws IllegalArgumentException if the entered time is less than 0.
   */
  @Override
  public List<State> frameAtTic(int time) throws IllegalArgumentException {
    if (time < 0) {
      throw new IllegalArgumentException("time cannot be less than 0");
    }

    List<State> states = new ArrayList<>();
    for (Shape shape : shapes) {
      states.add(shape.atState(time));
    }
    return states;
  }

  /**
   * Method to get the shape at a given index in the list.
   * @param index an int; represents the index of a list.
   * @return Shape; returns a Shape object.
   * @throws IllegalArgumentException if the entered int is out of index.
   */
  @Override
  public Shape getShape(int index) throws IllegalArgumentException {
    //TODO: Add throw here. Out of index.
    if (index < 0 || index > shapes.size()) {
      throw new IllegalArgumentException("your index is out of range.");
    }
    return shapes.get(index);
  }

  /**
   * Method to get a Shape equal to the inputted String.
   * @param name represents the name of the object. A string.
   * @return a Shape object.
   */
  @Override
  public Shape getShape(String name) throws IllegalArgumentException {

    for (Shape shape : shapes) {
      if (shape.getName().equals(name)) {
        return shape;
      }
    }
    return null;
  }

  /**
   * Method to return the X coordinate of a shape.
   * @return an int; represents the X coordinate.
   */
  @Override
  public int getX() {
    return this.x;
  }

  /**
   * Method to return the Y coordinate of a shape.
   * @return an int; represents the Y coordinate.
   */
  @Override
  public int getY() {
    return this.y;
  }

  /**
   * Method to return the max width.
   * @return an int; represents the max width.
   */
  @Override
  public int getMaxWidth() {
    return this.width;
  }

  /**
   * Method to return the max height.
   *
   * @return an int; represents the max height.
   */
  @Override
  public int getMaxHeight() {
    return this.height;
  }

  /**
   * Method to get the end Time of a shape.
   * @return the end time. an int.
   */
  @Override
  public int endTime() {
    int latestTick = 0;
    for (Shape shape : shapes) {
      latestTick = Math.max(shape.endTime(), latestTick);
    }
    return latestTick;
  }
}