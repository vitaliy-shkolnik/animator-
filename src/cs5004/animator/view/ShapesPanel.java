package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import cs5004.animator.model.State;
import cs5004.animator.model.shapes.Shape;
import cs5004.animator.model.shapes.ShapeAttribute;

/**
 * Class to set up Draw Shape.
 */
public class ShapesPanel extends JPanel implements ActionListener {
  List<Shape> shapes = Collections.emptyList();
  int tick = 0;
  int xOffset = 0;
  int yOffset = 0;

  /**
   * constructor method to DrawShapes.
   */
  public ShapesPanel() {
    super();
    setBackground(Color.WHITE);
  }

  /**
   * Method to Paint Components.
   * @param g a Graphics object.
   */
  @Override
  //This is part of jComponent superClass.
  public void paintComponent(Graphics g) {
    //this clears the previous image off the panel.
    //when extending a class. Usually call super by default.
    //send list of shapes to this object before hand.
    super.paintComponent(g);
    for (Shape shape : shapes) {
      State state = shape.atState(tick);

      g.setColor(new Color((int) state.valueFor(ShapeAttribute.RED),
              (int) state.valueFor(ShapeAttribute.GREEN),
              (int) state.valueFor(ShapeAttribute.BLUE)));
      if (shape.getClass().getSimpleName().equals("Rectangle")) {
        g.fillRect((int) state.valueFor(ShapeAttribute.POSITION_X) - xOffset,
                (int) state.valueFor(ShapeAttribute.POSITION_Y) - yOffset,
                (int) state.valueFor(ShapeAttribute.WIDTH),
                (int) state.valueFor(ShapeAttribute.HEIGHT));
      } else if (shape.getClass().getSimpleName().equals("Oval")) {
        int left = (int) (state.valueFor(ShapeAttribute.POSITION_X)
                - state.valueFor(ShapeAttribute.WIDTH) / 2);
        int top = (int) (state.valueFor(ShapeAttribute.POSITION_Y)
                - state.valueFor(ShapeAttribute.HEIGHT) / 2);

        g.fillOval(left - xOffset,
                top - yOffset,
                (int) state.valueFor(ShapeAttribute.WIDTH),
                (int) state.valueFor(ShapeAttribute.HEIGHT));
      }
    }
  }

  /**
   * Unused method for this class that came from an abstract class.
   * @param e represents an Event object.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    // Part of an abstract class.  This method is used in other classes but not this one.
  }
}