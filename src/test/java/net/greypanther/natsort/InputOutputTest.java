package net.greypanther.natsort;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public final class InputOutputTest {
  private final List<String> input;
  private final List<String> expectedOutput;
  private Comparator<String> comparator;

  public InputOutputTest(String inputResource, String expectedOutputResource,
      Comparator<String> comparator) throws IOException {
    this.input = load(inputResource);
    this.expectedOutput = load(expectedOutputResource);
    this.comparator = comparator;
  }

  @Test
  public void testInputOutput() {
    List<String> items = new ArrayList<String>(input);
    Collections.sort(items, comparator);
    assertEquals(expectedOutput, items);
  }

  private static List<String> load(String resourceName) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(InputOutputTest.class.getResourceAsStream(resourceName)));
    String line;
    List<String> result = new ArrayList<String>();
    while ((line = reader.readLine()) != null) {
      if (line.startsWith("#")) {
        continue;
      }
      result.add(line);
    }
    reader.close();
    return result;
  }

  @Parameters
  public static Iterable<Object[]> data() {
    String[][] testcases = {{"/alphanum_test_1_input.txt", "/alphanum_test_1_output.txt"},
        {"/alphanum_test_2_input.txt", "/alphanum_test_2_output.txt"}};
    @SuppressWarnings("unchecked")
    Collection<Comparator<String>> comparators =
        Arrays.asList(SimpleNaturalComparator.<String>getInstance(),
            CaseInsensitiveSimpleNaturalComparator.<String>getInstance());

    List<Object[]> result = new ArrayList<Object[]>(testcases.length * comparators.size());
    for (String[] testcase : testcases) {
      assert testcase.length == 2;
      for (Comparator<String> comparator : comparators) {
        result.add(new Object[] {testcase[0], testcase[1], comparator});
      }
    }
    return Collections.unmodifiableCollection(result);
  }
}
