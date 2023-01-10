import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import cs5004.animator.EasyAnimator;

/**
 * Class to generate tests for the EasyAnimator class.
 */
public class EasyAnimatorTest {
  JFrame frame = new JFrame();

  @Test(expected = FileNotFoundException.class)
  public void fileNotFoundTest() throws FileNotFoundException {
    EasyAnimator.main(new String[]{"-in", "notFound.txt", "-view", "text"});
  }

  @Test(expected = IOException.class)
  public void cannotWriteToOutFile() throws IOException {
    EasyAnimator.main(new String[]{"-in", "notFound.txt", "-view", "text", "-out", "output.svg"});
  }
}