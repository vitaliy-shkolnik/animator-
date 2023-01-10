package cs5004.animator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cs5004.animator.controller.PlaybackController;
import cs5004.animator.model.SimpleAnimationImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.PlaybackView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextView;
import cs5004.animator.view.VisualView;
import cs5004.animator.view.View;

/**
 * EasyAnimator class that is the View for the model.
 */
public final class EasyAnimator {


  /**
   * The Main method that will take in inputted terminal command lines and execute the commands.
   * @param args a string; represents the terminal commands and parameters inputted.
   */
  public static void main(String[] args) throws FileNotFoundException {
    String inFile = null;
    String viewType = null;
    String outFile = null;
    int speed = 1;
    JFrame frame = new JFrame();
    frame.setSize(200, 200);

    if (args.length % 2 == 1) {
      JOptionPane.showMessageDialog(frame,
              "Invalid number of arguments; are you missing a flag or value?", "Error",
              JOptionPane.ERROR_MESSAGE);
      System.exit(1);

    }
    // Go by twos to find the flag + the value
    for (int i = 0; i < args.length; i += 2) {
      String flag = args[i];
      String value = args[i + 1];
      if (!flag.startsWith("-")) {

        JOptionPane.showMessageDialog(frame,
                "Expected flag requires - in front of it","Error",
                JOptionPane.ERROR_MESSAGE);
        System.exit(1);
      }

      switch (flag) {
        case "-in":
          inFile = value;
          break;
        case "-view":
          viewType = value;
          break;
        case "-out":
          outFile = value;
          break;
        case "-speed":
          speed = Integer.parseInt(value);
          break;
        default:
          JOptionPane.showMessageDialog(frame,
                  "Unrecognized flag: " + flag, "Error",
                  JOptionPane.ERROR_MESSAGE);
          System.exit(1);
      }
    }

    // make sure that required arguments are there
    if (inFile == null) {
      JOptionPane.showMessageDialog(frame,
              "-in is required", "Error",
              JOptionPane.ERROR_MESSAGE);
      System.exit(1);

    }
    List<String> viewTypes = Arrays.asList("text", "svg", "visual", "playback");
    if (viewType == null || !(viewTypes.contains(viewType))) {
      JOptionPane.showMessageDialog(frame,
              "-view must be one of: text, svg, visual, playback", "Error",
              JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }

    File file = new File(inFile);
    //FileReader implements Reader (interface);
    FileReader reader = new FileReader(file);

    SimpleAnimationImpl.Builder builder = new SimpleAnimationImpl.Builder();
    SimpleAnimationImpl animation = AnimationReader.parseFile(reader, builder);

    String output = "";
    switch (viewType) {
      case "text":
        View textView = new TextView();
        textView.createFrom(animation, speed);
        output = textView.output().toString();
        break;
      case "svg":
        SVGView sVGView = new SVGView();
        sVGView.createFrom(animation, speed);
        output = sVGView.output().toString();
        break;
      case "visual":
        VisualView visualView = new VisualView();
        visualView.createFrom(animation, speed);  //set-up for the canvas window
        visualView.animationMove();  //set-up for the canvas window
        break;
      case "playback":
        PlaybackView playbackView = new PlaybackView();
        playbackView.createFrom(animation, speed);  //set-up for the canvas window
        PlaybackController controller = new PlaybackController(animation, playbackView, speed);
        controller.togglePlayOrPause();
        break;
      default:
        System.out.println("default");
    }

    if (outFile != null && !output.isEmpty()) {
      try (FileWriter writer = new FileWriter(outFile)) {
        writer.write(output);
      } catch (IOException e) {
        // Handle the exception
      }
    } else { // print to System.out
      System.out.print(output);
    }
  }
}


