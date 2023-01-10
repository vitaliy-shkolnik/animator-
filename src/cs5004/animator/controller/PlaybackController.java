package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Timer;

import cs5004.animator.model.SimpleAnimation;
import cs5004.animator.view.PlaybackView;

/**
 * Controller class PlaybackController.
 */
public class PlaybackController implements ActionListener {
  private final SimpleAnimation simpleAnimation;
  private final PlaybackView playbackView;
  private final Timer timer;

  private int speed;
  private boolean loop = false;
  private int tick = 0;


  /**
   * Constructor for playbackController. Controls the playbackView.
   *
   * @param simpleAnimation represents the animation. SimpleAnimationImpl.
   * @param playbackView    represents the view. PlaybackView.
   * @param speed           represents the speed. Int.
   */
  public PlaybackController(SimpleAnimation simpleAnimation, PlaybackView playbackView, int speed) {
    this.simpleAnimation = simpleAnimation;
    this.playbackView = playbackView;
    this.speed = speed;
    this.timer = new Timer(1000 / speed, this);

    //playbackView.addPlayPauseActionListener(e -> this.togglePlayOrPause()).
    playbackView.addPlayPauseActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        togglePlayOrPause();
      }
    });
    playbackView.addRestartActionListener(e -> restart());
    //playbackView.addAutoLoopActionListener(e -> loop = e.getStateChange() == ItemEvent.SELECTED);
    //written without lambda.
    playbackView.addAutoLoopActionListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        loop = e.getStateChange() == ItemEvent.SELECTED;
      }
    });
    playbackView.setSpeed(speed);
    playbackView.addSpeedChangeListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
          case "+":
            PlaybackController.this.speed++;
            break;
          case "-":
            PlaybackController.this.speed--;
            break;
          default:
        }
        updateSpeed();
      }
    });
  }

  /**
   * method for update current speed graphic.
   */
  private void updateSpeed() {
    playbackView.setSpeed(speed);
    timer.setDelay(1000 / speed);
  }

  /**
   * method to play or pause the animation.
   */
  public void togglePlayOrPause() {
    if (timer.isRunning()) {
      timer.stop();
    } else {
      timer.start();
    }
  }

  /**
   * method to restart the animation.
   */
  private void restart() {
    tick = 0;
    timer.restart();
  }

  /**
   * This is called by the timer, so it should implement standard forward playback.
   *
   * @param e is the event from the checkbox.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    playbackView.render(tick++);
    if (this.loop) {
      // e.g. if endTime == 100 and tick = 101, tick%endTime = 1
      tick = tick % (simpleAnimation.endTime() + 1);
    } else if (tick > simpleAnimation.endTime()) {
      timer.stop();
    }
  }
}
