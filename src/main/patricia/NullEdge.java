package main.patricia;

import java.util.ArrayList;
import java.util.List;

public class NullEdge extends Edge {

  NullEdge() {
    super("");
  }

  public boolean isNull() {
    return true;
  }

  @Override
  public Edge findLeaf() {
    return null;
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

  public Edge searchNode(String key, int value) throws NoSuchChild, EndOfPattern {
    return null;
  }

  @Override
  public Edge searchNode(String key) throws Exception {
    return null;
  }

  public List<Integer> search(String key) throws Exception {
    throw new Exception();
  }

  public void leafInsertion(String key, int value) {

  }

}
