package cs5004.animator.view;

import java.util.List;
import java.util.Map;
import cs5004.animator.model.Event;
import cs5004.animator.model.SimpleAnimation;
import cs5004.animator.model.shapes.Shape;
import cs5004.animator.model.shapes.ShapeAttribute;

/**
 * Creating a SVGView class.
 */
public class SVGView extends GeneralView {

  /**
   * Constructor method to create an SVG view using the inputted speed.
   * @param animation contains the animation. All the shapes. A SimpleAnimation.
   * @param speed represents speed of animation. An int.
   */
  @Override
  public void createFrom(SimpleAnimation animation, int speed) {
    this.animation = animation;

    StringBuilder sb = new StringBuilder();

    List<Shape> listOfShapes = animation.listShapes();
    int maxWidth = animation.getMaxWidth();
    int maxHeight = animation.getMaxHeight();
    int x = animation.getX();
    int y = animation.getY();

    sb.append("<svg width=\"").append(maxWidth).append("\"").append(" height =\"").append(maxHeight)
            .append("\"").append(" viewBox=").append("\"").append(x).append(" ").append(y)
            .append(" ").append(maxWidth).append(" ").append(maxHeight).append("\"")
            .append(" version=\"1.1\"").append("\n xmlns=\"")
            .append("http://www.w3.org/2000/svg\">\n\n");
    textOutput = sb;

    for (Shape shape : listOfShapes) {
      Map<ShapeAttribute, List<Event>> events = shape.getEvents();
      String name = shape.getName();
      String shapeType = shape.getClass().getSimpleName();
      String shapeTypeStatic = shape.getClass().getSimpleName();
      List<Event> xEvents = events.get(ShapeAttribute.POSITION_X);
      List<Event> yEvents = events.get(ShapeAttribute.POSITION_Y);
      List<Event> redEvents = events.get(ShapeAttribute.RED);
      List<Event> greenEvents = events.get(ShapeAttribute.GREEN);
      List<Event> blueEvents = events.get(ShapeAttribute.BLUE);
      List<Event> wEvents = events.get(ShapeAttribute.WIDTH);
      List<Event> hEvents = events.get(ShapeAttribute.HEIGHT);

      if (shapeType.equals("Rectangle")) {
        shapeType = "rect";
      } else if (shapeType.equals("Oval")) {
        shapeType = "ellipse";
      } else {
        throw new IllegalStateException("Unsupported shape: " + shapeType);
      }

      sb.append(String.format(
              "<%s id=\"%s\" %sx=\"%f\" %sy=\"%f\" %s=\"%f\" %s=\"%f\" " +
                      "fill=\"rgb%s\" visibility=\"visible\">\n\n",
              shapeType,
              name, // id=
              shapeType.equals("ellipse") ? "c" : "", // cx
              initialX(name),
              shapeType.equals("ellipse") ? "c" : "", // cy
              initialY(name),
              shapeType.equals("ellipse") ? "rx" : "width", // cx
              initialW(name), // width
              shapeType.equals("ellipse") ? "ry" : "height", // cx
              initialH(name), // height
              initialColor(name)
      ));


      int sizePOS = xEvents.size();
      for (int i = 0; i < sizePOS; i++) {
        Event xPos = xEvents.get(i);
        Event yPos = yEvents.get(i);
        Event red = redEvents.get(i);
        Event green = greenEvents.get(i);
        Event blue = blueEvents.get(i);
        Event width = wEvents.get(i);
        Event height = hEvents.get(i);
        int begin = (xPos.startTime * 1000) / speed;
        int dur = (width.endTime - width.startTime) * 1000 / speed;

        if (xPos.startValue != xPos.endValue) {

          sb.append(String.format("\t<animate attributeType=\"xml\" " +
                          "begin=\"%dms\" dur=\"%dms\" attributeName=\"",
                  begin, // begin=
                  dur // dur=
          ));

          sb.append(shapeType.equals("ellipse") ? "c" : "");
          sb.append("x\"");

          sb.append(" from=").append("\"").append(xPos.startValue)
                  .append("\"").append(" to=").append("\"").append(xPos.endValue).append("\"")
                  .append(" fill=").append("\"").append("freeze").append("\"").append(" />")
                  .append("\n");
        }

        if (yPos.startValue != yPos.endValue) {
          sb.append(String.format("\t<animate attributeType=\"xml\" " +
                          "begin=\"%dms\" dur=\"%dms\" attributeName=\"",
                  begin, // begin=
                  dur // dur=
          ));

          sb.append(shapeType.equals("ellipse") ? "c" : "");
          sb.append("y\"");

          sb.append(" from=").append("\"").append(yPos.startValue)
                  .append("\"").append(" to=").append("\"").append(yPos.endValue).append("\"")
                  .append(" fill=").append("\"").append("freeze").append("\"").append(" />")
                  .append("\n");
        }

        List<String> rGB = eventRGB(red, green, blue);

        if (!rGB.get(0).equals(rGB.get(1))) {
          sb.append("    <animate attributeType=").append("\"").append("xml").append("\"")
                  .append(" begin=").append("\"").append(begin)
                  .append("ms").append("\"").append(" dur=").append("\"")
                  .append(dur).append("ms").append("\"")
                  .append(" attributeName=").append("\"")
                  .append("fill").append("\"").append(" from=").append("\"").append("rgb")
                  .append(rGB.get(0)).append("\"").append(" to=").append("\"").append("rgb")
                  .append(rGB.get(1)).append("\"").append(" fill=").append("\"").append("freeze")
                  .append("\"").append(" />").append("\n");
        }

        //WHInfo = Element0: wValueStart, E1:wValueEnd, E2:wTimeStart, E3:wTimeEnd.
        //WHInfo = Element4: hValueStart, E5:hValueEnd, E6:hTimeStart, E7:hTimeEnd.

        List<String> wHInfo = eventWH(shapeTypeStatic, width, height);
        if (width.startValue != width.endValue && shapeType.equals("rect")) {

          sb.append("    <animate attributeType=").append("\"").append("xml").append("\"")
                  .append(" begin=").append("\"").append(begin)
                  .append("ms").append("\"").append(" dur=").append("\"")
                  .append(dur).append("ms").append("\"")
                  .append(" attributeName=").append("\"")
                  .append("width").append("\"").append(" from=").append("\"").append(wHInfo.get(0))
                  .append("\"").append(" to=").append("\"").append(wHInfo.get(1)).append("\"")
                  .append(" fill=").append("\"").append("freeze").append("\"").append(" />")
                  .append("\n");
        }

        if (width.startValue != width.endValue && shapeType.equals("ellipse")) {

          sb.append("    <animate attributeType=").append("\"").append("xml").append("\"")
                  .append(" begin=").append("\"").append(begin)
                  .append("ms").append("\"").append(" dur=").append("\"")
                  .append(dur).append("ms").append("\"")
                  .append(" attributeName=").append("\"")
                  .append("width").append("\"").append(" from=").append("\"").append(wHInfo.get(0))
                  .append("\"").append(" to=").append("\"").append(wHInfo.get(1)).append("\"")
                  .append(" fill=").append("\"").append("freeze").append("\"").append(" />")
                  .append("\n");
        }

        if (height.startValue != height.endValue && shapeType.equals("rect")) {

          sb.append("    <animate attributeType=").append("\"").append("xml").append("\"")
                  .append(" begin=").append("\"").append(begin)
                  .append("ms").append("\"").append(" dur=").append("\"")
                  .append(dur).append("ms").append("\"")
                  .append(" attributeName=").append("\"")
                  .append("height").append("\"").append(" from=").append("\"").append(wHInfo.get(4))
                  .append("\"").append(" to=").append("\"").append(wHInfo.get(5)).append("\"")
                  .append(" fill=").append("\"").append("freeze").append("\"").append(" />")
                  .append("\n");
        }

        if (height.startValue != height.endValue && shapeType.equals("ellipse")) {

          sb.append("    <animate attributeType=").append("\"").append("xml").append("\"")
                  .append(" begin=").append("\"").append(begin)
                  .append("ms").append("\"").append(" dur=").append("\"")
                  .append(dur).append("ms").append("\"")
                  .append(" attributeName=").append("\"")
                  .append("height").append("\"").append(" from=").append("\"").append(wHInfo.get(4))
                  .append("\"").append(" to=").append("\"").append(wHInfo.get(5)).append("\"")
                  .append(" fill=").append("\"").append("freeze").append("\"").append(" />")
                  .append("\n");
        }
      }
      sb.append("\n").append("</").append(shapeType).append(">").append("\n\n");
      textOutput = sb;
    }

    sb.append("</svg>");
  }

  /**
   * StringBuilder Method to generate an output.
   * Returns a String.
   */
  public StringBuilder output() {
    // this.animation.listShapes();

    return textOutput;
  }


}
