package main.patricia;

public class NoSuchChild extends Exception {
  Edge node;

  public NoSuchChild(Edge edge) {
    this.node  = edge;
  }

  public Edge getNode() {
    return node;
  }
}
