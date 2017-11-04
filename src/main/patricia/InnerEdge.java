package main.patricia;

public class InnerEdge extends Edge {

  private Edge leftSon;
  private Edge rightSon;

  InnerEdge(String key, Edge left, Edge right) {
    super(key);
    this.leftSon = left;
    this.rightSon = right;
  }

  public Edge getLeftSon() {
    return leftSon;
  }

  public Edge getRightSon() {
    return rightSon;
  }

  public void setLeftSon(Edge leftSon) {
    this.leftSon = leftSon;
  }

  public void setRightSon(Edge rightSon) {
    this.rightSon = rightSon;
  }

}
