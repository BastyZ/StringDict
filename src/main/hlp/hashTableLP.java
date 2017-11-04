package main.hlp;

import java.util.List;
import main.StringDictionary;

public class hashTableLP implements StringDictionary{
  public final int SIZE;
  private String[] table;

  /*Constructor al que le entregas el arreglo de Strings*/
  @Override
  public hashTableLP(String[] T) {
    int k = T.length;
    this(k);
  }

  /*Constructor al que le entregas el largo del arreglo de Strings T*/
  @Override
  public hashTableLP(int k){
    SIZE=k;
    this.table= new String[SIZE];
  }

  /*Funcion de hash*/
  public int code(String key){
    return (Math.abs.(key.hashCode())%SIZE);
  }

  @Override
  public void insert(String key, int value) {

  }

  @Override
  public List<Integer> search(String key) {
    return null;
  }

  @Override
  public long getSize() {
    return SIZE;
  }
}
