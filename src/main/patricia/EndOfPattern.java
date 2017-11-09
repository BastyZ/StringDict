package main.patricia;

public class EndOfPattern extends Exception {
  private Edge node;
  private String commPrefix;
  private String leftOver;

  public EndOfPattern(Edge edge, String lcp, String leftover) {
    this.node = edge;
    this.commPrefix = lcp;
    this.leftOver = leftover;
  }

  public Edge getNode() {
    return node;
  }

  public String getLcp() {
    return this.commPrefix;
  }

  public String getLeftOver() {
    return leftOver;
  }
}
