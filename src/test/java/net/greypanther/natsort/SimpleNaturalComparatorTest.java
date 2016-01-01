package net.greypanther.natsort;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Comparator;

@RunWith(Parameterized.class)
public final class SimpleNaturalComparatorTest extends AbstractSimpleNaturalComparatorTest {
  private static final Comparator<String> COMPARATOR = SimpleNaturalComparator.getInstance();

  public SimpleNaturalComparatorTest(String string1, ExpectedTestResult expectedRelation, String string2) {
    super(string1, expectedRelation, string2, COMPARATOR);
  }

  @Parameters
  public static Iterable<Object[]> data() {
    return getDefaultTestCases();
  }
}
