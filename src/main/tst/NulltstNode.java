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
  public void setLeft(ItstNode node) {  }

  @Override
  public void setMiddle(ItstNode node) {  }

  @Override
  public void setRight(ItstNode node) { }

  @Override
  public ItstNode insert(String key, int value, int index) {
    return new NulltstNode();
    /*TODO
    * insertar un nodo nuevo para el caracter en la posicion index del string key
    * se avanza el index, si no hay más string se agrega el value a ese nodo
    * si no avanzamos caracter por caracter insertandolos segun los criterios dados
    * se entrega el pirmer nodo creado*/
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
  public ItstNode getFather() {
    return new NulltstNode();
  }

  @Override
  public ItstNode getLeftChild() {
    return new NulltstNode();
  }

  @Override
  public ItstNode getMiddleChild() {
    return new NulltstNode();
  }

  @Override
  public ItstNode getRightChild() {
    return new NulltstNode();
  }

  @Override
  public int getSize() {
    return 0;
  }
}
