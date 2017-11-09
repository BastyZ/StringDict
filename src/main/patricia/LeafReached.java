package main.patricia;

public class LeafReached extends Exception {
  Edge node;
  String insertKey;

  public LeafReached(Edge edge, String key) {
    this.node = edge;
    this.insertKey = key;
  }

  public Edge getNode() {
    return node;
  }

  public Edge getFather() {
    return this.node.getFather();
  }

}
