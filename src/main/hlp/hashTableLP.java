package main.hlp;

import java.util.List;
import main.StringDictionary;


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
    int h = key.hashCode();
    int d = h%SIZE;
    return Math.abs(d);
}

  @Override
  public void insert(String key, int value) {
    int test; //ubicacion de prueba
    int h = code(key); //hashCode
    if (table[h] == null){
      //si el espacio esta libre
      table[h] = new hashItem(key,value);
      test = -1;
    } else {
      if (table[h].key.equals(key)){ //si tiene la misma llave
        table[h].setValue(value);
        return;
      }if (h == (SIZE - 1)){
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
      //System.out.println("Inserción exitosa en la posición "+test+ "de la tabla de hash");
    }
  }

  @Override
  public List<Integer> search(String key){
    int test;
    int h = code(key);

    if (table[h] == null){
      //si la posición inicial del hashCode esta vacio e spor que no existe
      return null;
    } else if (table[h].key.equals(key)){
      //si coincide y es el mismo elemento, retornamos el valor
      return table[h].value;
    } else {
      if (h == (SIZE - 1)){
        test = 0;
      } else {
        test = h + 1;
      }
    }

    while((test != -1) && (test != h)){
      if (table[test] == null){
        return null;
      } else if (table[test].key.equals(key)){
        return table[test].value;
      } else {
        if (test == (SIZE -1)){
          test = 0;
        } else {
          test++;
        }
      }
    }

    return null;
  }

  @Override
  public long getSize() {
    long s = 0;
    for (hashItem item : table){
      if (item != null){
        s = s + item.getSize();
      }
    }
    return s;
  }

  public float mindFullness (){
    int n=0;
    for (hashItem item : table){
      if (item == null){
        n++;
      }
    }
    int l = SIZE - n;
    return (float) ((l / SIZE) * 100);
  }
}
