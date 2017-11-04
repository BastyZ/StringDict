package main.patricia;

abstract class Edge {
  private String prefix;

  Edge(String key) {
    this.prefix = key;
  }

  boolean isLeaf() {
    return false;
  }
}
