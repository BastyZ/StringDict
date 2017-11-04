package main.tst;

import java.util.ArrayList;
import java.util.List;

public class tstNode implements ItstNode{
  private ItstNode father;
  private ItstNode left;
  private ItstNode middle;
  private ItstNode right;
  private List<Integer> value;
  private char data;

  public tstNode(char data){
    this.father = null;
    this.left = new NulltstNode();
    this.middle = new NulltstNode();
    this.right = new NulltstNode();
    this.value = new ArrayList<>();
    this.data = data;
  }

  @Override
  public String toString(){
    return (String.valueOf(data) + " " + left.toString() + middle.toString() + right.toString());
  }
  @Override
  public boolean isNull() {
    return false;
  }

  @Override
  public void setValue(int value) {
    this.value.add(value);
  }

  @Override
  public void setLeft(ItstNode node) {
    this.left = node;
  }

  @Override
  public void setMiddle(ItstNode node) {
    this.middle = node;
  }

  @Override
  public void setRight(ItstNode node) {
    this.right = node;
  }

  @Override
  public ItstNode insert(String key, int value, int index) {
    /*TODO
    * si el caracter en el la posición index del string key es MENOR a data
    * - insertamos en el hijo izquierdo, con la misma key, value e index
    *   y el resultado lo setea como hijo izquierdo
    * si el caracter en el la posición index del string key es MAYOR a data
    * - insertamos en el hijo derecho, con la misma key, value e index
    *   y el resultado lo setea como hijo derecho
    * si el caracter en el la posición index del string key es IGUAL a data
    * - si estamos al final de key agregamos value
    * - sino, insertamos en el hijo de al medio el mismo key y value pero aumentamos index
    *   y el resultado se setea como este hijo*/
    return null;
  }

  @Override
  public List<Integer> getValue() {
    return this.value;
  }

  @Override
  public char getData() {
    return this.data;
  }

  @Override
  public ItstNode getFather() {
    return this.father;
  }

  @Override
  public ItstNode getLeftChild() {
    return this.left;
  }

  @Override
  public ItstNode getMiddleChild() {
    return this.middle;
  }

  @Override
  public ItstNode getRightChild() {
    return this.right;
  }

  @Override
  public int getSize() {
    return (left.getSize() + middle.getSize() + right.getSize() + 4*value.size() + 50);
  }
}
