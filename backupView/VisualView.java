package cs5004.animator.view;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs5004.animator.model.SimpleAnimation;

/**
 * Class that renders the shape animation on a window.
 */
//by implementing ActionListener interface VisualView can do ActionListener things.
  //no need to create a ActionListener object.
public class VisualView extends JFrameView implements ActionListener {

  private final DrawShapes panel;
  private final PlaybackControlPanel panel2;
  private int speed = 1;
  private int tick = 0;



  /**
   * Method to construct a VisualView object.
   */
  public VisualView() {
    // TODO: Most of this can live in JFrameView so it can be shared with PlaybackView
    super();

    //initialized automatically when you create a VisualView.
    //this is the panel where the shapes are going to be drawn in.
    panel = new DrawShapes();
    panel2 = new PlaybackControlPanel();

    // setup for the animation and window canvas
    panel.setBackground(Color.WHITE);

    //set exit application using system exit method
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //set window panel not resizeable
    setResizable(false);
    setLayout(new GridLayout(2,0));  // grid with 2 columns & as many rows as we need

    //enable the window pane scroll
    add(panel);
    add(panel2);

    //trigger visibly the canvas window
    setVisible(true);
  }

  /**
   * Method to create a VisualView object using an animation object and speed.
   * @param animation contains the animation. All the shapes. A SimpleAnimation.
   * @param speed represents speed of animation. An int.
   */
  @Override
  public void createFrom(SimpleAnimation animation, int speed) {
    this.speed = speed;
    int x = animation.getX();
    int y = animation.getY();
    int maxWidth = animation.getMaxWidth();
    int maxHeight = animation.getMaxHeight();

    //this stores the list of shapes.
    panel.shapes = animation.listShapes();
    panel.setPreferredSize(new Dimension(maxWidth, maxHeight));
    panel.xOffset = x;
    panel.yOffset = y;

    //is a jFrame tool that automatically resizes itself so it neatly wraps the panel.
    //it accounts for buttons as you put them in. Less code upkeep as you grow your project.
    pack();
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
   * @return null; unused String builder.
   */
  @Override
  public StringBuilder output() {
    return null;
  }

  /**
   * this is what ActionListener does every "frame".
   * @param e not relevant.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    panel.draw(tick);
    tick++;
  }
}
