package cs5004.animator.view;

import cs5004.animator.model.SimpleAnimation;

/**
 * Setting up a View interface.
 */
public interface View {

  /**
   * Method to send View SimpleAnimation animation from parsed datafile.
   * @param animation contains the animation. All the shapes. A SimpleAnimation.
   * @param speed represents speed of animation. An int.
   */
  void createFrom(SimpleAnimation animation, int speed);

  /**
   * Method to return formatted view back to EasyAnimator.
   * @return StringBuilder object containing the representation of the animation.
   */
  StringBuilder output();

}
