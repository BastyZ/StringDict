package main;

public class LoremIpsum {
  public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
  private String[] loremIpsumWords;

  public LoremIpsum() {
    this.loremIpsumWords = LOREM_IPSUM.split("\\s");
  }

  /**
   * Returns one sentence (50 words) of the lorem ipsum text.
   *
   * @return 50 words of lorem ipsum text
   */
  public String getWords() {
    return getWords(50);
  }

  /**
   * Returns words from the lorem ipsum text.
   *
   * @param amount
   *            Amount of words
   * @return Lorem ipsum text
   */
  public String getWords(int amount) {
    return getWords(amount, 0);
  }

  /**
   * Returns words from the lorem ipsum text.
   *
   * @param amount
   *            Amount of words
   * @param startIndex
   *            Start index of word to begin with (must be >= 0 and < 50)
   * @return Lorem ipsum text
   * @throws IndexOutOfBoundsException
   *             If startIndex is < 0 or > 49
   */
  public String getWords(int amount, int startIndex) {
    if (startIndex < 0 || startIndex > 49) {
      throw new IndexOutOfBoundsException(
          "startIndex must be >= 0 and < 50");
    }

    int word = startIndex;
    StringBuilder lorem = new StringBuilder();

    for (int i = 0; i < amount; i++) {
      if (word == 50) {
        word = 0;
      }

      lorem.append(this.loremIpsumWords[word]);

      if (i < amount - 1) {
        lorem.append(' ');
      }

      word++;
    }

    return lorem.toString();
  }

  /**
   * Returns two paragraphs of lorem ipsum.
   *
   * @return Lorem ipsum paragraphs
   */
  public String getParagraphs() {
    return getParagraphs(2);
  }

  /**
   * Returns paragraphs of lorem ipsum.
   *
   * @param amount
   *            Amount of paragraphs
   * @return Lorem ipsum paragraphs
   */
  public String getParagraphs(int amount) {
    StringBuilder lorem = new StringBuilder();

    for (int i = 0; i < amount; i++) {
      lorem.append(LOREM_IPSUM);

      if (i < amount - 1) {
        lorem.append("\n\n");
      }
    }

    return lorem.toString();
  }

  public String getParagraphsHTML() {
    return getParagraphsHTML(2);
  }

  public String getParagraphsHTML(int amount) {
    StringBuilder lorem = new StringBuilder("<p>");

    for (int i = 0; i < amount; i++) {
      lorem.append(LOREM_IPSUM);

      if (i < amount - 1) {
        lorem.append("</p><p>");
      }
    }
    lorem.append("</p>");
    return lorem.toString();
  }
}
