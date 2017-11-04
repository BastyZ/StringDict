package main.patricia;

public class InnerEdge extends Edge {

  private Edge left;
  private Edge right;

  InnerEdge(String key, Edge left, Edge right) {
    super(key);
    this.left = left;
    this.right = right;
  }

}
