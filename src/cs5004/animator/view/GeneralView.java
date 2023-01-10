package cs5004.animator.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cs5004.animator.model.Event;
import cs5004.animator.model.SimpleAnimation;
import cs5004.animator.model.shapes.Shape;
import cs5004.animator.model.shapes.ShapeAttribute;

/**
 * Setting up class GeneralView.
 */
public abstract class GeneralView implements View {
  SimpleAnimation animation;
  StringBuilder textOutput;

  /**
   * Setting up a method to create an Animation object with the inputted speed.
   * @param animation contains the animation. All the shapes. A SimpleAnimation.
   * @param speed represents speed of animation. An int.
   */
  @Override
  public void createFrom(SimpleAnimation animation, int speed) {
    this.animation = animation;
  }

  @Override
  public StringBuilder output() {
    return textOutput;
  }

  /**
   * Method to extract the initial color values (RGB) from the shape.
   * @param name represents the name of the shape.
   * @return Red, Green, Blue values as a string.
   */
  public String initialColor(String name) {
    Shape shape = this.animation.getShape(name);
    Map<ShapeAttribute, List<Event>> events = shape.getEvents();
    List<Event> redEvents = events.get(ShapeAttribute.RED);
    List<Event> greenEvents = events.get(ShapeAttribute.GREEN);
    List<Event> blueEvents = events.get(ShapeAttribute.BLUE);
    Event redInitialValue = redEvents.get(0);
    Event greenInitialValue = greenEvents.get(0);
    Event blueInitialValue = blueEvents.get(0);
    double redValue = redInitialValue.startValue;
    double greenValue = greenInitialValue.startValue;
    double blueValue = blueInitialValue.startValue;

    String stringRed = String.format("%.0f", redValue);
    String stringGreen = String.format("%.0f", greenValue);
    String stringBlue = String.format("%.0f", blueValue);

    return "(" + stringRed + ", " + stringGreen + ", " + stringBlue + ")";
  }

  /**
   * Method to extract the initial x value from the shape.
   * @param name represents the name of the shape. A string.
   * @return x value. A double.
   */
  public double initialX(String name) {
    Shape shape = this.animation.getShape(name);
    Map<ShapeAttribute, List<Event>> events = shape.getEvents();
    List<Event> xEvents = events.get(ShapeAttribute.POSITION_X);

    Event xInitialValue = xEvents.get(0);

    double xValue = xInitialValue.startValue;

    return xValue;
  }

  /**
   * Method to extract the initial y value from the shape.
   * @param name represents the name of the shape. A string.
   * @return y value. A double.
   */
  public double initialY(String name) {
    Shape shape = this.animation.getShape(name);
    Map<ShapeAttribute, List<Event>> events = shape.getEvents();

    List<Event> yEvents = events.get(ShapeAttribute.POSITION_Y);

    Event yInitialValue = yEvents.get(0);

    double yValue = yInitialValue.startValue;

    return yValue;
  }

  /**
   * Method to extract the initial width value from the shape.
   * @param name represents the name of the shape. A string.
   * @return width value. A double.
   */
  public double initialW(String name) {
    Shape shape = this.animation.getShape(name);
    Map<ShapeAttribute, List<Event>> events = shape.getEvents();
    List<Event> wEvents = events.get(ShapeAttribute.WIDTH);
    Event wInitialValue = wEvents.get(0);

    double wValue = wInitialValue.startValue;
    double radWValue = wInitialValue.startValue / 2;

    if (shape.getClass().getSimpleName().equals("Rectangle")) {
      return wValue;
    }

    if (shape.getClass().getSimpleName().equals("Oval")) {
      return radWValue;
    }
    return 0;
  }

  /**
   * Method to extract the initial height value from the shape.
   * @param name represents the name of the shape. A string.
   * @return height value. A double.
   */
  public double initialH(String name) {
    Shape shape = this.animation.getShape(name);
    Map<ShapeAttribute, List<Event>> events = shape.getEvents();
    List<Event> hEvents = events.get(ShapeAttribute.HEIGHT);
    Event hInitialValue = hEvents.get(0);

    double hValue = hInitialValue.startValue;
    double radHValue = hInitialValue.startValue / 2;


    String stingHeight = String.format("%.0f", hValue);
    String stingRadHeight = String.format("%.0f", radHValue);

    if (shape.getClass().getSimpleName().equals("Rectangle")) {
      return hValue;
    }

    if (shape.getClass().getSimpleName().equals("Oval")) {
      return radHValue;
    }
    return 0;
  }

  /**
   * Method to extract the initial time value from the shape.
   * @param name represents the name of the shape. A string.
   * @return time value. A double.
   */
  public String shapeStartTime(String name) {
    Shape shape = this.animation.getShape(name);
    Map<ShapeAttribute, List<Event>> events = shape.getEvents();
    List<Event> tEvents = events.get(ShapeAttribute.WIDTH);
    int shapeStartTime = tEvents.get(0).startTime;
    return String.valueOf(shapeStartTime);
  }

  /**
   * Method to extract the final end time value from the shape.
   * @param name represents the name of the shape. A string.
   * @return time value. A double.
   */
  public String shapeEndTime(String name) {
    Shape shape = this.animation.getShape(name);
    return String.valueOf(shape.endTime());
  }

  /**
   * Method to extract the XY values from the shape.
   * @param xPos represents the name of the event. A Event.
   * @param yPos represents the name of the event. A Event.
   * @return list containing relevant information about xy.
   */
  public List<String> eventXY(Event xPos, Event yPos) {
    double xValueStart = xPos.startValue;
    double xValueEnd = xPos.endValue;
    double xTimeStart = xPos.startTime;
    double xTimeEnd = xPos.endTime;

    double yValueStart = yPos.startValue;
    double yValueEnd = yPos.endValue;
    double yTimeStart = yPos.startTime;
    double yTimeEnd = yPos.endTime;

    String xPosValueStart = String.format("%.0f", xValueStart);
    String xPosValueEnd = String.format("%.0f", xValueEnd);
    String xPosTimeStart = String.format("%.0f", xTimeStart);
    String xPosTimeEnd = String.format("%.0f", xTimeEnd);

    String yPosValueStart = String.format("%.0f", yValueStart);
    String yPosValueEnd = String.format("%.0f", yValueEnd);
    String yPosTimeStart = String.format("%.0f", yTimeStart);
    String yPosTimeEnd = String.format("%.0f", yTimeEnd);

    List<String> xyValues = new ArrayList<>();
    xyValues.add(xPosValueStart);
    xyValues.add(xPosValueEnd);
    xyValues.add(xPosTimeStart);
    xyValues.add(xPosTimeEnd);
    xyValues.add(yPosValueStart);
    xyValues.add(yPosValueEnd);
    xyValues.add(yPosTimeStart);
    xyValues.add(yPosTimeEnd);

    return xyValues;
  }

  /**
   * Method to extract the RGB values from the shape.
   * @param red represents the name of the event. A Event.
   * @param green represents the name of the event. A Event.
   * @param blue represents the name of the event. A Event.
   * @return list containing relevant information about RGB.
   */
  public List<String> eventRGB(Event red, Event green, Event blue) {
    double redValueStart = red.startValue;
    double redValueEnd = red.endValue;
    double redTimeStart = red.startTime;
    double redTimeEnd = red.endTime;

    double greenValueStart = green.startValue;
    double greenValueEnd = green.endValue;


    double blueValueStart = blue.startValue;
    double blueValueEnd = blue.endValue;

    String redVStart = String.format("%.0f", redValueStart);
    String greenVStart = String.format("%.0f", greenValueStart);
    String blueVStart = String.format("%.0f", blueValueStart);
    String redVEnd = String.format("%.0f", redValueEnd);
    String greenVEnd = String.format("%.0f", greenValueEnd);
    String blueVEnd = String.format("%.0f", blueValueEnd);
    String redTStart = String.format("%.0f", redTimeStart);
    String redTEnd = String.format("%.0f", redTimeEnd);

    String startRGB = "(" + redVStart + "," + greenVStart + "," + blueVStart + ")";
    String endRGB = "(" + redVEnd + "," + greenVEnd + "," + blueVEnd + ")";

    List<String> rGBValues = new ArrayList<>();
    rGBValues.add(startRGB);
    rGBValues.add(endRGB);
    rGBValues.add(redTStart);
    rGBValues.add(redTEnd);

    return rGBValues;
  }

  /**
   * Method to extract the WH values from the shape.
   * @param type represents the type of shape.
   * @param width represents the name of the event. A Event.
   * @param height represents the name of the event. A Event.
   * @return list containing relevant information about WH.
   */
  public List<String> eventWH(String type, Event width, Event height) {

    double wValueStart = width.startValue;
    double wValueEnd = width.endValue;
    double wTimeStart = width.startTime;
    double wTimeEnd = width.endTime;

    double hValueStart = height.startValue;
    double hValueEnd = height.endValue;
    double hTimeStart = height.startTime;
    double hTimeEnd = height.endTime;

    if (type.equals("Rectangle")) {

      String wVStart = String.format("%.0f", wValueStart);
      String wVEnd = String.format("%.0f", wValueEnd);
      String wTStart = String.format("%.0f", wTimeStart);
      String wTEnd = String.format("%.0f", wTimeEnd);

      String hVStart = String.format("%.0f", hValueStart);
      String hVEnd = String.format("%.0f", hValueEnd);
      String hTStart = String.format("%.0f", hTimeStart);
      String hTEnd = String.format("%.0f", hTimeEnd);

      List<String> wHValues = new ArrayList<>();
      wHValues.add(wVStart);
      wHValues.add(wVEnd);
      wHValues.add(wTStart);
      wHValues.add(wTEnd);
      wHValues.add(hVStart);
      wHValues.add(hVEnd);
      wHValues.add(hTStart);
      wHValues.add(hTEnd);

      return wHValues;
    }
    if (type.equals("Oval")) {
      double radWValueStart = width.startValue / 2;
      double radWValueEnd = width.endValue / 2;
      double radHValueStart = height.startValue / 2;
      double radHValueEnd = height.endValue / 2;

      String radWVStart = String.format("%.1f", radWValueStart);
      String radWVEnd = String.format("%.1f", radWValueEnd);
      String radWTStart = String.format("%.1f", wTimeStart);
      String radWTEnd = String.format("%.1f", wTimeEnd);

      String radHVStart = String.format("%.1f", radHValueStart);
      String radHVEnd = String.format("%.1f", radHValueEnd);
      String radHTStart = String.format("%.1f", hTimeStart);
      String radHTEnd = String.format("%.1f", hTimeEnd);

      List<String> wHValues = new ArrayList<>();
      wHValues.add(radWVStart);
      wHValues.add(radWVEnd);
      wHValues.add(radWTStart);
      wHValues.add(radWTEnd);
      wHValues.add(radHVStart);
      wHValues.add(radHVEnd);
      wHValues.add(radHTStart);
      wHValues.add(radHTEnd);

      return wHValues;
    }
    return null;
  }
}
