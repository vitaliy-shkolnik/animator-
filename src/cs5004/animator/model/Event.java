package cs5004.animator.model;

import java.awt.Shape;
import cs5004.animator.model.shapes.ShapeAttribute;

/**
 * An animation event that happens to a {@link Shape}.
 */
public class Event {
  public final ShapeAttribute attribute;
  public final int startTime;
  public final int endTime;
  public final double startValue;
  public final double endValue;

  /**
   * Constructor for cs5004.animator.model.Event method.
   * @param attribute attribute parameter.
   * @param startTime startTime parameter.
   * @param endTime endTime parameter.
   * @param startValue startValue parameter.
   * @param endValue endValue parameter.
   * @throws IllegalArgumentException exception for invalid values.
   */
  public Event(ShapeAttribute attribute, int startTime, int endTime, double startValue,
               double endValue) throws IllegalArgumentException {
    if (startTime < 0 || endTime < 0 || startTime > endTime) {
      throw new IllegalArgumentException("cs5004.animator.model.Event - Invalid input parameters");
    }
    this.attribute = attribute;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startValue = startValue;
    this.endValue = endValue;
  }

  /**
   * Whether this event's [startTime, endTime) overlaps with the other event.
   * @param other time value.
   * @return true if there is time overlap in other or this, false other wise.
   */
  public boolean overlaps(Event other) {
    if (this.contains(other.startTime)) {
      return true;
    }
    return other.contains(this.startTime);
  }

  /**
   * Whether a time is within event's [startTime, endTime).
   * @param time time value.
   * @return true if time is within, false otherwise.
   */
  public boolean contains(int time) {
    // usually start is inclusive, end is exclusive
    return startTime <= time && time < endTime;
  }

  /**
   * The calculated value of the attribute for a time inside this Event's time interval.
   * @param time event time.
   * @return return calculated value of attribute for time.
   * @throws IllegalArgumentException exception if time is not inside the event.
   */
  public double valueAt(int time) throws IllegalArgumentException {
    if (!this.contains(time)) {
      throw new IllegalArgumentException("Time is not inside this event");
    }

    double valueDelta = endValue - startValue;
    double timeDelta = endTime - startTime;
    double slope = valueDelta / timeDelta;

    return startValue + (slope * (time - startTime));
  }
}
