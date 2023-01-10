package cs5004.animator.view;


import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * PlaybackView class. This view allows for user interaction using buttons.
 */
public class PlaybackView extends JFrameView {

  private final PlaybackControlPanel controlPanel;

  /**
   * playbackView constructor. Initializes the class and sets up all the panels. panel is where
   * imagine is rendered. controlPanel is where the action buttons are.
   */
  public PlaybackView() {
    super();

    controlPanel = new PlaybackControlPanel();
    setLayout(new FlowLayout());

    //enable the window pane scroll
    add(shapesPanel);
    add(controlPanel);
  }

  /**
   * Renders a single frame of the animation.
   *
   * @param tick represents the time t the animation is suppose to be on.
   */
  public void render(int tick) {
    shapesPanel.tick = tick;
    shapesPanel.repaint();
  }

  /**
   * Method that listens for the playPauseButton.
   *
   * @param actionListener user button.
   */
  public void addPlayPauseActionListener(ActionListener actionListener) {
    //the actionListener is when user pushes button.
    controlPanel.playPauseButton.addActionListener(actionListener);
  }

  /**
   * Method that listens for the restart button.
   *
   * @param actionListener user button.
   */
  public void addRestartActionListener(ActionListener actionListener) {
    controlPanel.restartButton.addActionListener(actionListener);
  }

  /**
   * Method that listens for the loop checkbox.
   *
   * @param listener user checkbox.
   */
  public void addAutoLoopActionListener(ItemListener listener) {
    controlPanel.loopCheckbox.addItemListener(listener);
  }

  /**
   * Method that listens for the + button.
   *
   * @param actionListener user checkbox.
   */
  public void addSpeedChangeListener(ActionListener actionListener) {
    controlPanel.speedIncreaseButton.addActionListener(actionListener);
    controlPanel.speedDecreaseButton.addActionListener(actionListener);
  }

  /**
   * Method that displays the current speed onto the panel.
   *
   * @param speed represents the speed of the animation..
   */
  public void setSpeed(int speed) {
    controlPanel.speedLabel.setText(Integer.toString(speed));
  }
}


