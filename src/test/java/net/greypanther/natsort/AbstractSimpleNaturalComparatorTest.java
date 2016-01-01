package net.greypanther.natsort;

import static net.greypanther.natsort.ExpectedTestResult.EQUALS;
import static net.greypanther.natsort.ExpectedTestResult.GREATER_THAN;
import static net.greypanther.natsort.ExpectedTestResult.LESS_THAN;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import org.junit.Test;

public abstract class AbstractSimpleNaturalComparatorTest {
  private final String string1;
  private final String string2;
  private final ExpectedTestResult expectedRelation;
  private final Comparator<String> comparator;

  AbstractSimpleNaturalComparatorTest(String string1, ExpectedTestResult expectedRelation, String string2, Comparator<String> comparator) {
    this.string1 = string1;
    this.string2 = string2;
    this.expectedRelation = expectedRelation;
    this.comparator = comparator;
  }

  @Test
  public void testSimpleNaturalComparator() {
    int c = comparator.compare(string1, string2);
    assertTrue(String.format("Expected '%s' to be %s '%s', but was: %d", string1, expectedRelation,
        string2, c), expectedRelation.verify(c));
  }

  static Collection<Object[]> getDefaultTestCases() {
    return Arrays.asList(new Object[][] {
      {"z2.doc", LESS_THAN, "z10.doc"},
      {"z010.doc", EQUALS, "z10.doc"},
      {"z10", LESS_THAN, "z10a"},
      {"z10a", GREATER_THAN, "z10"},
      {"a", LESS_THAN, "z"},
      {"10", LESS_THAN, "z"},
      {"z", GREATER_THAN, "10"},
      {"10", LESS_THAN, "20"},
      {"10", GREATER_THAN, "5"},
      {"10", EQUALS, "10"},
      {"9223372036854775806", LESS_THAN, "9223372036854775807"},
      {"18446744073709551614", LESS_THAN, "18446744073709551615"},
    });
  }
}
