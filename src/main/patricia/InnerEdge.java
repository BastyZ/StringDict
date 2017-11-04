package main.patricia;

import java.util.List;

public class InnerEdge extends Edge {

  private Edge leftSon;
  private Edge rightSon;

  InnerEdge(String key, Edge left, Edge right) {
    super(key);
    this.leftSon = left;
    this.rightSon = right;
  }

  Edge getLeftSon() {
    return leftSon;
  }

  Edge getRightSon() {
    return rightSon;
  }

  void setLeftSon(Edge leftSon) {
    this.leftSon = leftSon;
  }

  void setRightSon(Edge rightSon) {
    this.rightSon = rightSon;
  }

  public Edge searchNode(String key, int value) throws NoSuchChild, EndOfPattern {
    return null;
  }

  public List<Integer> search(String key) {
    return null;
  }

  public void leafInsertion(String key, int value) {

  }
}
