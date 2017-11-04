package main.patricia;

import java.util.List;

abstract class Edge {
  private String prefix;

  String prefix() {
    return prefix;
  }

  Edge(String key) {
    this.prefix = key;
  }

  Edge getLeftSon() throws NoSuchChild {
    throw new NoSuchChild();
  }

  Edge getRightSon() throws NoSuchChild {
    throw new NoSuchChild();
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

  public abstract Edge searchNode(String key, int value) throws NoSuchChild, EndOfPattern;

  public abstract List<Integer> search(String key) throws Exception;

  public abstract void leafInsertion(String key, int value);
}
