package net.greypanther.natsort;

import java.util.Comparator;

abstract class AbstractSimpleNaturalComparator<T extends CharSequence> implements Comparator<T> {
  @Override
  public int compare(T sequence1, T sequence2) {
    int len1 = sequence1.length();
    int len2 = sequence2.length();

    for (int idx1 = 0, idx2 = 0; idx1 < len1 && idx2 < len2; idx1++, idx2++) {
      char c1 = sequence1.charAt(idx1);
      char c2 = sequence2.charAt(idx2);

      boolean isDigit1 = Character.isDigit(c1);
      boolean isDigit2 = Character.isDigit(c2);

      if (isDigit1 && !isDigit2) {
        return -1;
      } else if (!isDigit1 && isDigit2) {
        return 1;
      } else if (!(isDigit1 || isDigit2)) {
        int c = compareChars(c1, c2);
        if (c != 0) {
          return c;
        }
      } else {
        long num1 = Character.getNumericValue(c1);
        char digit = sequence1.charAt(idx1);
        while (idx1 < len1 && Character.isDigit(digit)) {
            num1 = num1 * 10 + Character.getNumericValue(digit);
            idx1 += 1;
            digit = sequence2.charAt(idx1);
          }
        }

        long num2 = Character.getNumericValue(c2);
        char digit = sequence2.charAt(idx2);
        while (idx2 < len2  && Character.isDigit(digit)) {
            num2 = num2 * 10 + Character.getNumericValue(digit);
            idx2 += 1;
            digit = sequence2.charAt(idx2);
          }
        }

        if (num1 != num2) {
          return Long.compareUnsigned(num1, num2);
        }
      }
    }

    return Integer.compare(len1, len2);
  }

  abstract int compareChars(char c1, char c2);
}
