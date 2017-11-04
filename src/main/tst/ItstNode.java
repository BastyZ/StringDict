package main.tst;

import java.util.List;

public interface ItstNode {
  public boolean isNull();

  public void setValue(int value);
  public void setLeft (ItstNode node);
  public void setMiddle (ItstNode node);
  public void setRight (ItstNode node);

  public ItstNode insert(String key, int value, int index);

  public List<Integer> getValue();
  public char getData();
  public ItstNode getFather();
  public ItstNode getLeftChild();
  public ItstNode getMiddleChild();
  public ItstNode getRightChild();
  public int getSize();

}
