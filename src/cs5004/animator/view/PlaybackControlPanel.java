package cs5004.animator.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;


/**
 * PlaybackControlPanel displays all the buttons on the second panel.
 */
public class PlaybackControlPanel extends JPanel {
  final JButton playPauseButton;
  final JButton restartButton;
  final JCheckBox loopCheckbox;

  final JLabel speedLabel;
  final JButton speedIncreaseButton;
  final JButton speedDecreaseButton;

  /**
   * Constructor for playbackControlPanel. It creates and adds all the buttons.
   */
  PlaybackControlPanel() {
    playPauseButton = new JButton("Play/Pause");
    restartButton = new JButton("Restart");
    this.add(playPauseButton);
    this.add(restartButton);

    loopCheckbox = new JCheckBox("Auto-loop");
    this.add(loopCheckbox);

    speedLabel = new JLabel("speed");
    speedIncreaseButton = new JButton("+");
    speedDecreaseButton = new JButton("-");
    speedIncreaseButton.setActionCommand("+");
    speedDecreaseButton.setActionCommand("-");
    this.add(speedDecreaseButton);
    this.add(speedLabel);
    this.add(speedIncreaseButton);
  }
}
