package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import main.hlp.hashTableLP;
import main.patricia.Patricia;
import main.tst.tst;

public class Main {
  private final static String alfabeta = "abcdefghijklmnopqrstuvwxyz ";
  /* La idea es que esta clase encuentre todos los textos de la carpeta
  ./files/ y para cada uno, secuencialmente:

  - Cree los tres diccionarios, estimando el tamaño y calculando el tiempo de ejecución
  - Realice los experimentos en orden

  Idealmente deberían guardarse los resultados en un archivo tipo CSV para facilitar el informe
   */

  public static void main(String[] args) throws IOException {
    ArrayList<Path> books = new ArrayList<Path>();
    final File assetsLocation = new File("C:\\Users\\BastyZ\\IdeaProjects\\StringDict\\src\\main\\text");
    for (final File book : assetsLocation.listFiles() ){
      books.add(book.toPath());
    }
    for (final Path book: books) {
      runExperimentOne(book);
    }

  }

  private static void runExperimentOne(Path book) throws IOException {
    ArrayList<Double> times = new ArrayList<>();
    ArrayList<String> words = new ArrayList<>();
    Scanner sc = new Scanner(book);
    while (sc.hasNextLine()) {
      String line = sc.nextLine(); // debería ser solo una
      String[] line_words = line.split(" ");
      for (String word : line_words) {
        words.add(word);
      }
    }
    char[] chars = alfabeta.toCharArray();
    List<char[]> asList = Arrays.asList(chars);
    List<Character> listC = new ArrayList<Character>();
    for (char c : chars) {
      listC.add(c);
    }
    // ya tenemos todas las palabras en orden en words
    System.out.println("----------------------------------------------------------");
    System.out.println("----------------------------------------------------------");
    System.out.println("El libro "+book.getFileName());
    System.out.println("Posee "+words.size()+" palabras");
    StringDictionary patricia = new Patricia();
    StringDictionary hlp = new hashTableLP(words.size());
    StringDictionary tst = new tst( listC );
    Stopwatch stopwatch = new Stopwatch();
    makeDictionary(patricia,words);
    times.add(stopwatch.elapsedTime());
    stopwatch.reset();
    makeDictionary(tst,words);
    times.add(stopwatch.elapsedTime());
    stopwatch.reset();
    makeDictionary(hlp,words);
    times.add(stopwatch.elapsedTime());
    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    System.out.println("Tiempo de Construcción   EXPERIMENTO 1");
    System.out.println("Patricia:     "+times.get(0));
    System.out.println("TST:          "+times.get(1));
    System.out.println("HLP:          "+times.get(2));
    System.out.println("-------------------------------------------------------------");
    List<String> randomWords = new ArrayList<>();
    List<String> missingWords = new ArrayList<>();
    LoremIpsum lore = new LoremIpsum();
    Random number = new Random();
    for (int i = 0; i < words.size()/10; i++) {
      randomWords.add(words.get(number.nextInt(words.size()-1)));
    }
    String[] miss = lore.getWords(49).split(" ");
    for (int j = 0; j < 49; j++) {
      missingWords.add(miss[j]);
    }
    System.out.println("Tiempo de busqueda para "+randomWords.size()+" palabras");
    stopwatch.reset();
    for (int i = 0; i < randomWords.size(); i++) {
      patricia.search(randomWords.get(i).replace(".","").replace(",",""));
    }
    times.add(stopwatch.elapsedTime()); // 3
    stopwatch.reset();
    for (int i = 0; i < randomWords.size(); i++) {
      tst.search(randomWords.get(i));
    }
    times.add(stopwatch.elapsedTime()); // 4
    stopwatch.reset();
    for (int i = 0; i < randomWords.size(); i++) {
      hlp.search(randomWords.get(i));
    }
    times.add(stopwatch.elapsedTime()); // 5
    stopwatch.reset();
    int mRandom = gal(randomWords);
    System.out.println("Para un m de "+mRandom);
    System.out.println("Patricia:   "+times.get(3));
    System.out.println("TST:          "+times.get(4));
    System.out.println("HLP:          "+times.get(5));
    System.out.println("-----------------------------------------------------------");
    System.out.println("Tiempo de fallo para "+missingWords.size()+" palabras");
    System.out.println("Para un m de "+gal(missingWords));
    stopwatch.reset();
    for (int i = 0; i < missingWords.size(); i++) {
      patricia.search(missingWords.get(i));
    }
    times.add(stopwatch.elapsedTime()); // 6
    stopwatch.reset();
    for (int i = 0; i < missingWords.size(); i++) {
      tst.search(missingWords.get(i));
    }
    times.add(stopwatch.elapsedTime()); // 7
    stopwatch.reset();
    for (int i = 0; i < missingWords.size(); i++) {
      hlp.search(missingWords.get(i));
    }
    times.add(stopwatch.elapsedTime()); // 8
    stopwatch.reset();
    System.out.println("Patricia:   "+times.get(6));
    System.out.println("TST:          "+times.get(7));
    System.out.println("HLP:          "+times.get(8));
    System.out.println("-----------------------------------------------------------");

  }

  private static int gal(List<String> words) {
    int m = 0;
    for (int i = 0; i < words.size(); i++) {
      m += words.get(i).length();
    }
    return m/words.size();

  }

  private static void makeDictionary(StringDictionary dictionary, List<String> words) {
    int value = 0;
    for (String word : words) {
      dictionary.insert(word+"$",value);
      value++;
    }
  }

}
