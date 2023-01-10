package cs5004.animator.model.tools;

import java.util.Comparator;

/**
 * A class to manage a helper method to compare two integers.
 */
public class IntegerComparator implements Comparator<Integer> {

  /**
   * Method to compare two integers.
   * @param o1 represents the first integer.
   * @param o2 represents the second integer.
   * @return an integer based on whether or not the first integer is equal to the second integer.
   */
  @Override
  public int compare(Integer o1, Integer o2) {
    return o1.compareTo(o2);
  }
}
