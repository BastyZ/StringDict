package main.hlp;

import java.util.List;
import main.StringDictionary;
import main.hlp.hashItem;

public class hashTableLP implements StringDictionary{
  private final int SIZE;
  private hashItem[] table;

  /*Constructor al que se le entrega el largo del arreglo de Strings T*/
  public hashTableLP(int k){
    SIZE=k;
    this.table= new hashItem[SIZE];
  }

  /*Funcion de hash*/
  private int code(String key){
    return (Math.abs.(key.hashCode())%SIZE);
  }

  @Override
  public void insert(String key, int value) {
    int test; //ubicación de prueba
    int h = code(key); //hashCode
    if (table.[h] == null){
      //si el espacio esta libre
      table[h] = new hashItem(key,value);
      test = -1;
    } else {
      if (h == (SIZE - 1)){
        //si h es el final del arreglo empiezo a buscar desde el principio de este
        test = 0;
      } else {
        //si no pruebo la siguiente posicion
        test = h + 1;
      }
    }

    //loop en busqueda del siguiente espacio vacio
    while ((test != -1) && (test != h)){
      if ((table[test] == null)){
        table[test] = new hashItem(key,value);
        test = -1;
      } else {
        if (test == (SIZE - 1)){
          test = 0;
        } else {
          test++;
        }
      }
    }

    if (test != -1){
      System.out.println("Inserción fallida, tabla de hash completa");
    } else {
      System.out.println("Inserción exitosa en la posición "+test+ "de la tabla de hash");
    }
  }

  @Override
  public List<Integer> search(String key) {
    return null;
  }

  @Override
  public long getSize() {
    return (long)SIZE;
  }
}
