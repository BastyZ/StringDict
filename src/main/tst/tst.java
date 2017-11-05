package main.tst;

import java.util.ArrayList;
import java.util.List;
import main.StringDictionary;

public class tst implements StringDictionary {
  private ItstNode root;
  private List<Character> sigma;

  static List<Character> generateSigma (List<String> txt){
    List<Character> temp = new ArrayList<>();
    for (String str : txt){
      for (char chr : str.toCharArray()){
        temp.add(chr);
      }
    }
    return temp;
  }

  public tst(List<Character> chars){
    this.sigma = chars;
    root = new tstNode('#'); //donde # marca el final de una palabra
  }

  /* si la llave es valida
    * -agregamos # al final de key
    * - iniciamos la busqueda recursiva con el nodo raiz, el string key e index 0*/
  @Override
  public List<Integer> search(String key) {
    if (validString(key)){
      key = key + '#';
      return recursiveSearch(root,key,0);
    }
    return null;
  }

  /*si el nodo es null retornamos un arreglo vacio
    * si el caracter en el la posición index del string str es MENOR al dato guardado en node
    * - seguimos la busqueda desde el hijo izquierdo del nodo, el mismo str e index
    * si el caracter en el la posición index del string str es MAYOR al dato guardado en node
    * - seguimos la busqueda desde el hijo derecho del nodo, el mismo str e index
    * sino, es decir, el caracter evaluado en str es IGUAL al dato de node
    * - si el index está al final de str, retornamos el valor guardado en el node
    * - sino seguimos la búsqueda por el hijo de al medio, con el mismo str y aumentamos el index*/
  private List<Integer> recursiveSearch(ItstNode node, String str, int index){
    if (node.isNull()){
      return new ArrayList<>();
    }
    char chr = str.charAt(index);
    char dt = node.getData();
    if (chr < dt){
      return recursiveSearch(node.getLeftChild(),str,index);
    } else if (chr > dt){
      return recursiveSearch(node.getRightChild(),str,index);
    } else {
      int end = str.length() - 1;
      if (index == end){
        return node.getValue();
      } else {
        return recursiveSearch(node.getMiddleChild(),str,index+1);
      }
    }
  }

  /*si la llave es valida
  * -agregamos # al final del string
  * -inserta desde la raiz, dicho key y value con el index a partir de 0*/
  @Override
  public void insert(String key, int value) {
    if (validString(key)){
      key = key + '#';
      root.insert(key,value,0);
    }
  }

  @Override
  public long getSize() {
    return (sigma.size()*2 + root.getSize() + 8*2);
  }

  private boolean validString (String str){
    for (char chr : str.toCharArray()){
      if(!sigma.contains(chr)){
        return false;
      }
    }
    return true;
  }
}
