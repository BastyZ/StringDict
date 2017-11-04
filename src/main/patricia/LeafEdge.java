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
}
