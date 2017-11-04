package main.patricia;

import java.util.List;

public class LeafEdge extends Edge {
  private List<Integer> values;

  LeafEdge(String key, int value) {
    super(key);
    this.values.add(value);
  }

  public List<Integer> getValue() {
    return values;
  }

  @Override
  public boolean isLeaf() {
    return true;
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
