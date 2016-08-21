package ibayer.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;


/**
 * Basic unit test for lambda expression filter with string value
 * @author ibrahim.bayer
 *
 */
public class LambdaBasicTests {

  private static final String NAME_JOHN = "John";

  // Create list for scenario
  List<String> namesList = Arrays.asList(new String[] { NAME_JOHN, "Jackson", "Emilie" });
  
  @Test
  public void testFilterLambda() {
   
    // Filter list by stream api and lambda
    List<String> filteredName = namesList.stream().filter(name -> NAME_JOHN.equals(name)).collect(Collectors.toList());
    
    testFilterResults(filteredName);

  }
  
  @Test
  public <T> void testFilterPredicate(){
    
    // Predicate classes could be useful for complex tests and re-usable expressions
    Predicate<? super String> filterPredicate = new Predicate<String>() {
      @Override
      public boolean test(String name) {
        return NAME_JOHN.equals(name);
      }
    };
    
    // Filter list by stream api and predicate
    List<String> filteredName = namesList.stream().filter(filterPredicate).collect(Collectors.toList());
    
    testFilterResults(filteredName);
 
  }

  private void testFilterResults(List<String> filteredName) {
    //test response with desired dataset
    Assert.assertNotNull(filteredName);
    Assert.assertEquals(1, filteredName.size());
    Assert.assertEquals(NAME_JOHN, filteredName.get(0));
  }
  
}
