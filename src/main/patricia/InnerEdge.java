package main.patricia;

import java.util.ArrayList;
import java.util.Collections;

public class InnerEdge extends Edge {

  private ArrayList<Edge> children;

  InnerEdge(String key, ArrayList<Edge> sons) {
    super(key);
    this.children = sons;
  }

  @Override
  ArrayList<Edge> getChildren() {
    return this.children;
  }

  public Edge searchNode(String key) throws Exception {
    if (!super.prefix().startsWith(key) || this.children.isEmpty()) {
      // nunca deberían suceder ninguna de estas dos cosas
      throw new Exception();
    } else if (key.length() < super.prefixSize() ) {
      // se nos acabó la palabra antes de hacer match
      throw new EndOfPattern(this);
    }
    Collections.sort(this.children);
    String keySuffix = key.substring(super.prefixSize(),key.length());
    // como los hijos están ordenados lexicográficamente, si nos pasamos perdemos
    for (Edge son : this.children) {
      if ( son.prefix().startsWith( son.prefix() ) ) {
        // hemos encontrado un hijo por el que bajar
        return searchNode(keySuffix);
      }
    }
    // no hemos encontrado al hijo
    throw new NoSuchChild(this);
  }

  public void leafInsertion(String key, int value) {
    // TODO insertion starting on leaf
  }

  @Override
  public Edge findLeaf() {
    return this.children.get(0).findLeaf();
  }

}
