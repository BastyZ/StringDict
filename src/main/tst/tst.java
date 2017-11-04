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

  @Override
  public List<Integer> search(String key) {
    return null;
  }

  @Override
  public void insert(String key, int value) {

  }

  @Override
  public long getSize() {
    return (sigma.size() + root.getSize());
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
