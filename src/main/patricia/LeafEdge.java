package main.patricia;

import java.util.List;

public class LeafEdge extends Edge {
  private List<Integer> values;

  LeafEdge(String key, int value) {
    super(key);
    this.values.add(value);
  }

  public List<Integer> getValues() {
    return values;
  }

  @Override
  public boolean isLeaf() {
    return true;
  }


  public Edge searchNode(String key) throws Exception {
    if (super.prefix().contentEquals(key)) {
      return this;
    } else {
      throw new LeafReached(this);
    }
  }

  public void leafInsertion(String key, int value) {

  }

}
