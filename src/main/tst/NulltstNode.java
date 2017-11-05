package main.tst;

import java.util.List;

public class NulltstNode implements ItstNode {

  @Override
  public boolean isNull() {
    return true;
  }

  @Override
  public void setValue(int value) {  }

  @Override
  private void setLeft(ItstNode node) {  }

  @Override
  public void setMiddle(ItstNode node) {  }

  @Override
  private void setRight(ItstNode node) { }

  /*insertar un nodo nuevo para el caracter en la posicion index del string key
    * se avanza el index, si no hay más string se agrega el value a ese nodo
    * si no avanzamos caracter por caracter insertandolos segun los criterios dados
    * se entrega el pirmer nodo creado*/
  @Override
  public ItstNode insert(String key, int value, int index) {
    ItstNode node = new tstNode(key.charAt(index));
    index = index + 1;
    int rest = key.substring(index).length();
    if (rest == 0){
      node.setValue(value);
    }
    ItstNode aux = node;
    ItstNode temp;
    for (int i = 0; i < rest; i++){
      char nextChar = key.charAt(index + i);
      temp = new tstNode(nextChar);
      aux.setMiddle(temp);
      if (i == rest - 1){
        temp.setValue(value);
      }
    }
    return node;
}

  @Override
  public List<Integer> getValue() {
    return null;
  }

  @Override
  public char getData() {
    return 0;
  }

  @Override
  private ItstNode getLeftChild() {
    return new NulltstNode();
  }

  @Override
  private ItstNode getMiddleChild() {
    return new NulltstNode();
  }

  @Override
  private ItstNode getRightChild() {
    return new NulltstNode();
  }

  @Override
  public int getSize() {
    return 8;
  }
}
