package main.patricia;

public class EndOfPattern extends Exception {
  Edge node;

  public EndOfPattern(Edge edge) {
    this.node = edge;
  }

  public Edge getNode() {
    return node;
  }
}
