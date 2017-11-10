package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
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
    books = new ArrayList<>();
    final File compBooksLocation = new File("C:\\Users\\BastyZ\\IdeaProjects\\StringDict\\src\\main\\text\\comparison");
    for (final File book: compBooksLocation.listFiles()) {
      books.add(book.toPath());
    }
    //runExperimentTwo(books.get(1),books.get(4)); // 2048
    //runExperimentTwo(books.get(2),books.get(5)); // 524288
  }

  private static void runExperimentTwo(Path path, Path path1) throws IOException {
    ArrayList<String> book1 = new ArrayList<>();
    ArrayList<String> book2 = new ArrayList<>();
    Scanner sc = new Scanner(path);
    while (sc.hasNextLine()){
      String line = sc.nextLine(); // debería ser solo una
      String[] line_words = line.split(" ");
      Collections.addAll(book1, line_words);
    }
    sc = new Scanner(path1);
    while (sc.hasNextLine()){
      String line = sc.nextLine(); // debería ser solo una
      String[] line_words = line.split(" ");
      Collections.addAll(book2, line_words);
    }
    ArrayList<String> concatenation = new ArrayList<>();
    concatenation.addAll(book1);
    concatenation.addAll(book2);
    float countConcatenation = book1.size()+book2.size();
    Set<String> hs = new HashSet<>();
    hs.addAll(concatenation);
    concatenation.clear();
    concatenation.addAll(hs);
    float dif = 0;
    for (String word : concatenation) {
      // TODO contar la cantidad de apariciones en cada texto y agregar la abs(resta) a dif
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
    System.out.println("--------------------------------------------------------------");
    System.out.println("--------------------------------------------------------------");
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
    System.out.println("Tiempo de Construcción y Tamaño   EXPERIMENTO 1");
    System.out.println("Patricia:     "+times.get(0)+"\t"+patricia.getSize()+" bytes");
    System.out.println("TST:          "+times.get(1)+"\t"+tst.getSize()+" bytes");
    System.out.println("HLP:          "+times.get(2)+"\t"+hlp.getSize()+" bytes");
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
