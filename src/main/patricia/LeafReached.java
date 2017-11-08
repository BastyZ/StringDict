package main.patricia;

public class LeafReached extends Exception {
  Edge node;

  public LeafReached(Edge edge) {
    this.node = edge;
  }

  public Edge getNode() {
    return node;
  }
}
