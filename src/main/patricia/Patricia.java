package main.patricia;

import java.util.List;
import main.StringDictionary;

public class Patricia implements StringDictionary {
  private Edge root;

  @Override
  public void insert(String key, int value) {
    if (root == null) {
      root = new LeafEdge(key, value);
    } else if (root.isLeaf()){
      // TODO metodo de inserción
    } else {
      // TODO metodo de inserción 2
    }
  }

  @Override
  public List<Integer> search(String key) {
    return null;
  }

  @Override
  public long getSize() {
    return 0;
  }
}
