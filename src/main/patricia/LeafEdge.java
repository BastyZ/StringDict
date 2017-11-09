package main.patricia;

import java.util.ArrayList;
import java.util.List;

public class LeafEdge extends Edge {
  private List<Integer> values = new ArrayList<>();
  private Edge father;

  LeafEdge(String key, int value, Edge dad) {
    super(key);
    this.values.add(value);
    this.father = dad;
  }

  LeafEdge(String key, List<Integer> values, Edge dad) {
    super(key);
    this.values = values;
    this.father = dad;
  }

  public List<Integer> getValues() {
    return values;
  }

  @Override
  public boolean isLeaf() {
    return true;
  }

  @Override
  public boolean isRoot() {
    return this.father == null;
  }

  public Edge searchNode(String key) throws Exception {
    if (super.prefix().contentEquals(key)) {
      return this;
    } else {
      throw new LeafReached(this, key);
    }
  }

  @Override
  public Edge getFather() {
    return this.father;
  }

  @Override
  public void insert(int value) {
    values.add(value);
  }

  @Override
  public Edge findLeaf() {
    return this;
  }

  @Override
  public ArrayList<Edge> getChildren() {
    return null;
  }

  @Override
  public void clearChildren() {

  }

  @Override
  public void addChildren(Edge baby, Edge son) {

  }

  @Override
  public void leafInsertion(LeafReached e, int value) {

  }
}
