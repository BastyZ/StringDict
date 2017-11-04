package main.patricia;

import java.util.List;

abstract class Edge {
  private String prefix;

  Edge(String key) {
    this.prefix = key;
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
