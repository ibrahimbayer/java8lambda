package ibayer.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import org.junit.Assert;
import org.junit.Test;


/**
 * Unit tests to demonstrate basic mathematical operations over lists
 * @author ibrahim.bayer
 *
 */
public class LambdaMathTests {
  
  List<Integer> data = Arrays.asList(new Integer[]{1,3,5,12,31});
  
  /**
   * The sum of pre defined list has to be 1+3+5+12+31 = 52
   */
  @Test
  public void testSum(){
    int sum = data.stream().mapToInt(Integer::intValue).sum();
    Assert.assertEquals(52, sum);
  }
  
  /**
   * The average of pre defined list has to be 1+3+5+12+31 = 52 / 5 = 10.4
   */
  @Test
  public void testAverage(){
    OptionalDouble average = data.stream().mapToDouble(Integer::doubleValue).average();
    Assert.assertEquals(10.4D, average.getAsDouble(),0D);
  }
  
  
  /**
   * The max of pre defined list is 31
   */
  @Test
  public void testMax(){
    OptionalInt max = data.stream().mapToInt(Integer::intValue).max();
    Assert.assertEquals(31,max.getAsInt());
  }
  
  /**
   * The min value of pre defined list is 1
   */
  @Test
  public void testMin(){
    OptionalInt min = data.stream().mapToInt(Integer::intValue).min();
    Assert.assertEquals(1,min.getAsInt());
  }
}
