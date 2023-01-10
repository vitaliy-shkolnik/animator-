package cs5004.animator.view;

import java.util.List;
import java.util.Map;

import cs5004.animator.model.Event;
import cs5004.animator.model.SimpleAnimation;
import cs5004.animator.model.shapes.Shape;
import cs5004.animator.model.shapes.ShapeAttribute;

/**
 * Class to manage the TextView view.
 */
public class TextView extends GeneralView {


  /**
   * Constructor method to create a TextView.
   * @param animation contains the animation. All the shapes. A SimpleAnimation.
   * @param speed represents speed of animation. An int.
   */
  @Override
  public void createFrom(SimpleAnimation animation, int speed) {
    this.animation = animation;
    StringBuilder sb = new StringBuilder();
    List<Shape> listOfShapes = animation.listShapes();

    for (Shape shape : listOfShapes) {

      String name = shape.getName();
      String shapeType = shape.getClass().getSimpleName();
      String shapeColor = initialColor(name);
      Map<ShapeAttribute, List<Event>> events = shape.getEvents();

      sb.append("Create ").append(shapeColor).append(" ").append(shapeType).append(" ")
              .append(name).append(" with corner at ").append("(").append(initialX(name))
              .append(",").append(initialY(name)).append(")").append(",").append("\n");

      if (shapeType.equals("Rectangle")) {
        sb.append("width ").append(initialW(name)).append(" and height ").append(initialY(name));
      }

      if (shapeType.equals("Oval")) {
        sb.append("radius ").append(initialW(name)).append(" and ").append(initialY(name));
      }

      sb.append(". ").append(name).append(" appears at time t=").append(shapeStartTime(name))
              .append(" and disappears at time t=").append(shapeEndTime(name))
              .append(".").append("\n");

      textOutput = sb;

      List<Event> xEvents = events.get(ShapeAttribute.POSITION_X);
      List<Event> yEvents = events.get(ShapeAttribute.POSITION_Y);
      List<Event> redEvents = events.get(ShapeAttribute.RED);
      List<Event> greenEvents = events.get(ShapeAttribute.GREEN);
      List<Event> blueEvents = events.get(ShapeAttribute.BLUE);
      List<Event> wEvents = events.get(ShapeAttribute.WIDTH);
      List<Event> hEvents = events.get(ShapeAttribute.HEIGHT);
      sb.append("\n");

      int sizePOS = xEvents.size();
      for (int i = 0; i < sizePOS; i++) {
        Event xPos = xEvents.get(i);
        Event yPos = yEvents.get(i);
        Event red = redEvents.get(i);
        Event green = greenEvents.get(i);
        Event blue = blueEvents.get(i);
        Event width = wEvents.get(i);
        Event height = hEvents.get(i);


        //XYPos = Element0: xValueStart, E1:xValueEnd, E2:xTimeStart, E3:xTimeEnd.
        //XYPos = Element4: yValueStart, E5:yValueEnd, E6:yTimeStart, E7:yTimeEnd.
        List<String> xYPos = eventXY(xPos, yPos);

        if (xPos.startValue != xPos.endValue || yPos.startValue != yPos.endValue) {
          sb.append(name);
          sb.append(" MOVES FROM ");
          sb.append("(").append(xYPos.get(0)).append(",").append(xYPos.get(4)).append(")");
          sb.append(" to ").append("(").append(xYPos.get(1)).append(",")
                  .append(xYPos.get(5)).append(")");
          sb.append(". From time t=").append(xPos.startTime)
                  .append(" to t=").append(xPos.endTime);
          sb.append(".").append("\n");
        }

        //RGB = Element0: startValue(RGB), E1: endValue(RGB), E2: startTime(RBG), E3: endTime(RGB).
        List<String> rGB = eventRGB(red, green, blue);

        if (!rGB.get(0).equals(rGB.get(1))) {

          sb.append(name).append(" CHANGES COLOR FROM ").append(rGB.get(0)).append(" to ")
                  .append(rGB.get(1)).append(". From time t=").append(rGB.get(2))
                  .append(" to t=").append(rGB.get(3)).append("\n");
        }

        //WHInfo = Element0: wValueStart, E1:wValueEnd, E2:wTimeStart, E3:wTimeEnd.
        //WHInfo = Element4: hValueStart, E5:hValueEnd, E6:hTimeStart, E7:hTimeEnd.
        List<String> wHInfo = eventWH(shapeType, width, height);

        if (width.startValue != width.endValue && shapeType.equals("Rectangle")) {
          sb.append(name).append(" WIDTH CHANGES FROM ").append(wHInfo.get(0))
                  .append(" to ").append(wHInfo.get(1)).append(".").append(" From time t=")
                  .append(width.startTime).append(" to t=").append(width.endTime)
                  .append(".").append("\n");
        }

        if (width.startValue != width.endValue && shapeType.equals("Oval")) {
          sb.append(name).append(" WIDTH RADIUS CHANGES FROM ").append(wHInfo.get(0))
                  .append(" to ").append(wHInfo.get(1)).append(".").append(" From time t=")
                  .append(width.startTime).append(" to t=").append(width.endTime)
                  .append(".").append("\n");
        }

        if (height.startValue != height.endValue && shapeType.equals("Rectangle")) {
          sb.append(name).append(" HEIGHT CHANGES FROM ").append(wHInfo.get(4))
                  .append(" to ").append(wHInfo.get(5)).append(".").append(" From time t=")
                  .append(height.startTime).append(" to t=").append(height.endTime)
                  .append(".").append("\n");
        }

        if (height.startValue != height.endValue && shapeType.equals("Oval")) {
          sb.append(name).append(" HEIGHT RADIUS CHANGES FROM ").append(wHInfo.get(4))
                  .append(" to ").append(wHInfo.get(5)).append(".").append(" From time t=")
                  .append(height.startTime).append(" to t=").append(height.endTime)
                  .append(".").append("\n");
        }
      }
      sb.append("\n\n");
    }
  }

  /**
   * StringBuilder method that will output a textual view of the animation.
   * @return a String representing a textual view of the animation.
   */
  @Override
  public StringBuilder output() {
    return textOutput;
  }


}
