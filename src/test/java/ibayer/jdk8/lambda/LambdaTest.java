package ibayer.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for lambda expressions
 */
public class LambdaTest {

  private static final String NAME_JOHN = "John";
  String[] names = new String[] { NAME_JOHN, "Jackson", "Emilie" };

  @Test
  public void testFilter() {
    // Convert array to list
    List<String> namesList = Arrays.asList(names);

    // Filter list by stream api and lambda
    List<String> filteredName = namesList.stream().filter(name -> NAME_JOHN.equals(name)).collect(Collectors.toList());
    
    //test response with desired dataset
    Assert.assertNotNull(filteredName);
    Assert.assertEquals(1, filteredName.size());
    Assert.assertEquals(NAME_JOHN, filteredName.get(0));

  }
}
