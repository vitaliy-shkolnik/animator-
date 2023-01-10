package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


/**
 * Class that renders the shape animation on a window.
 */
//by implementing ActionListener interface VisualView can do ActionListener things.
//no need to create a ActionListener object.
public class VisualView extends JFrameView implements ActionListener {
  private int tick = 0;

  /**
   * Method to construct a VisualView object.
   */
  public VisualView() {

    super();
    //enable the window pane scroll
    add(shapesPanel);

  }


  /**
   * method for the visual view option.
   */
  public void animationMove() {

    // speed = ticks per second
    //timer for the repaint
    //ActionListener:
    //this is VisualView.
    Timer timer = new Timer(1000 / speed, this);
    timer.start();
  }


  /**
   * Unused String builder method.
   *
   * @return null; unused String builder.
   */
  @Override
  public StringBuilder output() {
    return null;
  }

  /**
   * this is what ActionListener does every "frame".
   *
   * @param e not relevant.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    shapesPanel.tick = tick;
    shapesPanel.repaint();
    tick++;
  }
}
