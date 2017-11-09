package main.patricia;

import java.util.ArrayList;
import java.util.Collections;

public class InnerEdge extends Edge {

  private ArrayList<Edge> children = new ArrayList<>();

  InnerEdge(String key, ArrayList<Edge> sons) {
    super(key);
    this.children = sons;
  }

  InnerEdge(String key, Edge son1, Edge son2) {
    super(key);
    this.addChildren(son1,son2);
  }

  public ArrayList<Edge> getChildren() {
    return this.children;
  }

  @Override
  public void clearChildren() {
    this.children = new ArrayList<Edge>();
  }

  @Override
  public void addChildren(Edge baby, Edge son) {
    this.children.add(baby);
    this.children.add(son);
    Collections.sort(this.children);
  }

  @Override
  public void leafInsertion(LeafReached e, int value) {
    String lcp = Patricia.lcp(e.node.prefix(), e.insertKey);
    for ( Edge node : this.children) {
      if ( node.prefix() == e.getNode().prefix() ) {
        Edge son1 = new LeafEdge(e.node.prefix().substring(lcp.length()), e.node.getValues(), node);
        Edge son2 = new LeafEdge(e.insertKey.substring(lcp.length()), value, node);
        node = new InnerEdge(lcp, son1, son2);
        break;
      }
    }
  }

  @Override
  public long getSize() {
    long childrenSize = 0;
    for (Edge son : this.children) {
      childrenSize += son.getSize();
    }
    return 4*super.prefixSize()+childrenSize;
  }

  public Edge searchNode(String key) throws Exception {
    if (this.children.isEmpty()) {
      // nunca deberían suceder ninguna de estas dos cosas
      throw new Exception();
    } else if (key.length() < super.prefixSize() ) {
      // se nos acabó la palabra antes de hacer match
      String lcp = Patricia.lcp(key,super.prefix());
      throw new EndOfPattern(this, lcp, key.substring(lcp.length()) );
    }
    Collections.sort(this.children);
    String keySuffix = key.substring(super.prefixSize(),key.length());
    // como los hijos están ordenados lexicográficamente, si nos pasamos perdemos
    for (Edge son : this.children) {
      if ( son.prefix().startsWith( son.prefix() ) ) {
        // hemos encontrado un hijo por el que bajar
        return son.searchNode(keySuffix);
      }
    }
    // no hemos encontrado al hijo
    throw new NoSuchChild(this, keySuffix);
  }

  public void leafInsertion(String key, int value) {
    // TODO insertion starting on leaf
  }

  @Override
  public Edge findLeaf() {
    return this.children.get(0).findLeaf();
  }

}
