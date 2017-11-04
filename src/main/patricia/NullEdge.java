package main.patricia;

import java.util.List;

public class NullEdge extends Edge {

  NullEdge() {
    super("");
  }

  public boolean isNull() {
    return true;
  }

  public Edge searchNode(String key, int value) throws NoSuchChild, EndOfPattern {
    return null;
  }

  public Edge search(String key) throws Exception {
    throw new Exception();
  }

  public List<Integer> getValues() {
    return null;
  }

  public void leafInsertion(String key, int value) {

  }

}
