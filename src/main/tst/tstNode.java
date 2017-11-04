package main.tst;

import java.util.List;

public class tstNode implements ItstNode{
  private ItstNode father;
  private ItstNode left;
  private ItstNode middle;
  private ItstNode right;
  private List<Integer> value;
  private char data;

  public tstNode(char data){

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
    /*TODO*/
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
    return 0;
  }
}
