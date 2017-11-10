package main.tst;

import java.util.List;

public interface ItstNode {
  boolean isNull();
  String toString();

  void setValue(int value);
  void setLeft(ItstNode node);
  void setMiddle(ItstNode node);
  void setRight(ItstNode node);

  ItstNode insert(String key, int value, int index);

  List<Integer> getValue();
  char getData();
  ItstNode getLeftChild();
  ItstNode getMiddleChild();
  ItstNode getRightChild();
  int getSize();

}
