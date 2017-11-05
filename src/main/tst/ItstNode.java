package main.tst;

import java.util.List;

public interface ItstNode {
  public boolean isNull();
  public String toString();

  public void setValue(int value);
  private void setLeft (ItstNode node);
  public void setMiddle (ItstNode node);
  private void setRight (ItstNode node);

  public ItstNode insert(String key, int value, int index);

  public List<Integer> getValue();
  public char getData();
  private ItstNode getLeftChild();
  private ItstNode getMiddleChild();
  private ItstNode getRightChild();
  public int getSize();

}
