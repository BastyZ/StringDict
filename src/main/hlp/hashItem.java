package main.hlp;

import java.util.ArrayList;
import java.util.List;

public class hashItem{
  public List<Integer> value = new ArrayList<>();
  public String key;

  public hashItem(String k, int v){
    value.add(v);
    key = k;
  }

  public void setValue(int v){
    value.add(v);
  }
}