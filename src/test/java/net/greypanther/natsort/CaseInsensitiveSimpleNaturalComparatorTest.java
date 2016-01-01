package net.greypanther.natsort;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static net.greypanther.natsort.ExpectedTestResult.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RunWith(Parameterized.class)
public final class CaseInsensitiveSimpleNaturalComparatorTest extends AbstractSimpleNaturalComparatorTest {
  private static final Comparator<String> COMPARATOR = CaseInsensitiveSimpleNaturalComparator.getInstance();

  public CaseInsensitiveSimpleNaturalComparatorTest(String string1, ExpectedTestResult expectedRelation, String string2) {
    super(string1, expectedRelation, string2, COMPARATOR);
  }

  @Parameters
  public static Iterable<Object[]> data() {
    List<Object[]> result = new ArrayList<Object[]>(getDefaultTestCases());
    result.add(new Object[] {"a", EQUALS, "A"});
    return result;
  }
}
