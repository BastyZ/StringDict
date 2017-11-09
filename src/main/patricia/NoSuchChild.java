package main.patricia;

public class NoSuchChild extends Exception {
  private Edge node;
  private String suffix;

  public NoSuchChild(Edge edge, String keySuffix) {
    this.node  = edge;
    this.suffix = keySuffix;
  }

  public String getSuffix() {
    return suffix;
  }

  public Edge getNode() {
    return node;
  }
}
