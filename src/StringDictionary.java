import java.util.List;

public interface StringDictionary {
  void insert(String key, int value);
  List<Integer> search(String key);
  long getSize();
}