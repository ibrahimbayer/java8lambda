package ibayer.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class LambdaTest {

  List<Integer> data = Arrays.asList(new Integer[] { 1, 3, 5, 12, 31, 5, 31 });

  /**
   * Test distinct values in array list
   */
  @Test
  public void testDistinct() {
    List<Integer> dataDistinct = data.stream().distinct().collect(Collectors.toList());
    Assert.assertEquals(5, dataDistinct.size());
  }

  /**
   * Print elements one by one
   */
  @Test
  public void testForEach() {
    data.stream().forEach(action -> {
      System.out.println(action.intValue());
    });
  }

}
