package main.patricia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

abstract class Edge implements Comparator<Edge>, Comparable<Edge> {
  private String prefix;

  String prefix() {
    return prefix;
  }

  Edge(String key) {
    this.prefix = key;
  }

  public abstract Edge searchNode(String key) throws Exception;

  public List<Integer> search(String key) throws Exception {
    return this.searchNode(key).getValues();
  }

  public Edge getFather() {
    return null;
  }

  public boolean isRoot() {
    return false;
  }

  List<Integer> getValues() {
    return null;
  }

  int prefixSize(){
    return prefix.length();
  }

  boolean isLeaf() {
    return false;
  }

  boolean isNull() {
    return false;
  }

  public int compareTo(Edge edge) {
    return this.prefix().compareTo(edge.prefix());
  }

  public int compare(Edge anEdge, Edge otherEdge) {
    return anEdge.prefix().compareTo(otherEdge.prefix());
  }

  public void insert(int value) {

  }

  public abstract Edge findLeaf();

  public abstract ArrayList<Edge> getChildren();

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public abstract void clearChildren();

  public abstract void addChildren(Edge baby, Edge son);

  public abstract void leafInsertion(LeafReached e, int value);

  public abstract long getSize();

}
