package cs5004.animator.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import cs5004.animator.model.SimpleAnimation;

/**
 * Abstract class between VisualView and PlaybackView.
 */
public abstract class JFrameView extends JFrame implements View {
  protected SimpleAnimation animation;
  protected int speed;
  protected final ShapesPanel shapesPanel = new ShapesPanel();
  // TODO: wrap the shapesPanel in a scroll pane

  /**
   * Constructor for JFrameView.
   *
   */
  JFrameView() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setVisible(true);
  }

  /**
   * Method to create a VisualView object using an animation object and speed.
   * @param animation contains the animation. All the shapes. A SimpleAnimation.
   * @param speed represents speed of animation. An int.
   */
  @Override
  public void createFrom(SimpleAnimation animation, int speed) {
    this.animation = animation;
    this.speed = speed;

    int x = animation.getX();
    int y = animation.getY();
    int maxWidth = animation.getMaxWidth();
    int maxHeight = animation.getMaxHeight();

    //this stores the list of shapes.
    shapesPanel.shapes = animation.listShapes();
    shapesPanel.setPreferredSize(new Dimension(maxWidth, maxHeight));

    shapesPanel.xOffset = x;
    shapesPanel.yOffset = y;

    //is a jFrame tool that automatically resizes itself so it neatly wraps the panel.
    //it accounts for buttons as you put them in. Less code upkeep as you grow your project.
    pack();
  }

  @Override
  public StringBuilder output() {
    // TODO: this should probably throw an exception
    return null;
  }
}
