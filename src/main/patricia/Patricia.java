package main.patricia;

import java.util.List;
import main.StringDictionary;

public class Patricia implements StringDictionary {
  private Edge root;

  public Patricia() {
    root = new NullEdge();
  }

  @Override
  public void insert(String key, int value) {
    if (root.isNull()) {
      root = new LeafEdge(key, value);
      return;
    }
    Edge edge;
    try {
      edge = root.searchNode(key,value);
      edge.leafInsertion(key,value);
    } catch (EndOfPattern e) {
      // TODO caso donde no hay hijo que comience con la letra
    } catch (NoSuchChild e) {
      // TODO caso donde se acaba el patrón a seguir antes de llegar a una hoja
    }
  }

  @Override
  public List<Integer> search(String key) {
    try {
      return root.search(key);
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public long getSize() {
    // TODO aplicar función
    return 0;
  }
}
