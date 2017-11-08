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
      edge = root.searchNode(key);
      edge.insert(value);
    } catch (EndOfPattern e) {
      // caso donde se acaba el patrón a seguir antes de llegar a una hoja
      Edge node = e.getNode();
      Edge leaf = node.findLeaf();
      leaf.leafInsertion(key,value);
    } catch (NoSuchChild e) {
      // caso donde no hay hijo que comience con la letra
      Edge node = e.getNode();
      node.findLeaf().leafInsertion(key,value);
    } catch (LeafReached e) {
      // TODO caso donde se llega a la hoja y no hay match exacto
      e.getNode().leafInsertion(key,value);
    } catch (Exception e) {
      // TODO para los otros casos
      System.out.println("Fallo inesperado: ");
      e.printStackTrace();
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
