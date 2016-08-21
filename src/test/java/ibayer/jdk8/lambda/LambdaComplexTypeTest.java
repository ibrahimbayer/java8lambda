package ibayer.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/**
 * Basic unit test for lambda expression filter with complex type
 * 
 * @author ibrahim.bayer
 *
 */
public class LambdaComplexTypeTest {

  private static final String SEARCH_SURNAME_CRITERIA = "Smith";
  List<Person> personList = Arrays.asList(new Person[] { new Person("John", SEARCH_SURNAME_CRITERIA),
      new Person("John", "Doe"), new Person("Jane", SEARCH_SURNAME_CRITERIA) });

  /**
   * The input sampling will be filtered by surname. The matching records are
   * collected to new list and being tested
   */
  @Test
  public void testFilterLambda() {
    // Filter list by stream api and lambda
    // null check is performed just in case
    List<Person> filteredPerson = personList.stream()
        .filter(person -> (person != null && SEARCH_SURNAME_CRITERIA.equals(person.getSurname())))
        .collect(Collectors.toList());

    // test filter result
    Assert.assertNotNull(filteredPerson);
    Assert.assertEquals(2, filteredPerson.size());
    Assert.assertEquals(SEARCH_SURNAME_CRITERIA, filteredPerson.get(0).getSurname());
    Assert.assertEquals(SEARCH_SURNAME_CRITERIA, filteredPerson.get(1).getSurname());
  }

  /**
   * The Person type will be converted to String type by using stream map method
   */
  @Test
  public void testMapLambda() {
    List<String> personSurnamesList = personList.stream().map(person -> person.getSurname())
        .collect(Collectors.toList());
    
    Assert.assertNotNull(personSurnamesList);
    Assert.assertEquals(3, personSurnamesList.size());
    Assert.assertEquals(SEARCH_SURNAME_CRITERIA, personSurnamesList.get(0));
  }
  
}
