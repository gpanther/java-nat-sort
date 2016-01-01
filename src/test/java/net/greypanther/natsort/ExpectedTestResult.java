package net.greypanther.natsort;

enum ExpectedTestResult {
  LESS_THAN("less than", -1), GREATER_THAN("greater than", 1), EQUALS("equal to", 0);

  private final String name;
  private final int signum;

  private ExpectedTestResult(String name, int signum) {
    this.name = name;
    this.signum = signum;
  }

  boolean verify(int comparisonResult) {
    return Math.signum(signum) == Math.signum(comparisonResult);
  }

  @Override
  public String toString() {
    return name;
  }
}
