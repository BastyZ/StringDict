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

  @Override
  Edge getLeftSon() {
    return this.leftSon;
  }

  @Override
  Edge getRightSon() {
    return this.rightSon;
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

  public List<Integer> search(String key) throws Exception {
    if (super.prefix().contentEquals(key) || !super.prefix().startsWith(key)) {
      throw new Exception();
    }
    String keySuffix;
    keySuffix = (String) key.subSequence(super.prefixSize()-1,key.length()-1);
    if (this.leftSon.prefix().startsWith(keySuffix)) {
      return this.leftSon.search(keySuffix);
    } else if (this.rightSon.prefix().startsWith(keySuffix)){
      return this.rightSon.search(keySuffix);
    } else {
      throw new Exception();
    }
  }

  public void leafInsertion(String key, int value) {

  }
}
