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
      root = new LeafEdge(key, value, null);
      return;
    }
    Edge edge;
    try {
      edge = root.searchNode(key);
      edge.insert(value);
    } catch (EndOfPattern e) {
      // caso donde se acaba el patrón a seguir antes de llegar a una hoja
      Edge node = e.getNode();
      String prefix = e.getLcp();
      String suffix = node.prefix().substring(prefix.length());
      String remnant = e.getLeftOver();
      Edge son = new InnerEdge(suffix, node.getChildren());
      Edge baby = new LeafEdge(remnant, value, node);
      node.setPrefix(prefix);
      node.clearChildren();
      node.addChildren(baby,son);
    } catch (NoSuchChild e) {
      // caso donde no hay hijo que comience con la letra
      Edge node = e.getNode();
      LeafEdge son = new LeafEdge(e.getSuffix(),value, node);
    } catch (LeafReached e) {
      // caso donde se llega a la hoja y no hay match exacto
      if (e.getFather() == null) {
        // TODO father es root, por lo que hay que hacer el nuevo root
        root = new InnerEdge(lcp(e.getNode().prefix(),key),
            new LeafEdge(e.getNode().prefix(),e.getNode().getValues(),root),
            new LeafEdge(key,value,root));
      } else {
        e.getFather().leafInsertion(e, value);
      }
    } catch (Exception e) {
      // para los otros casos
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

  static String lcp(String a, String b) {
    String ans;
    int i;
    for (i = 0; i < Math.min(a.length(),b.length()) ; i++ ) {
      if (a.charAt(i) != b.charAt(i)) break;
    }
    return a.substring(0,i);
  }

}
