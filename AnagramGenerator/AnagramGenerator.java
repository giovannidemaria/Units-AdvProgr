public class AnagramGenerator {
  private int numAnagrams;
  private String[] anagramsArr;

  public AnagramGenerator(int numAnagrams) {
    this.numAnagrams = numAnagrams;
    anagramsArr = new String[numAnagrams];
  }

  public void generateAnagramsStdio(String str) {
    isWord(str);
    if (numAnagrams == 0)
      numAnagrams = Integer.MAX_VALUE;
    System.out.println("Anagrams of " + str + ":");
    generateAnagramsStdio("", str);
  }

  private void isWord(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (!((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'))) {
        System.out.println("This is not a word");
        System.exit(-1);
      }
    }
  }

  private void generateAnagramsStdio(String prefix, String suffix) {
    if ((suffix.length() == 0) && numAnagrams > 0) {
      System.out.println(firstCapitalised(prefix));
      numAnagrams--;
    }
    if ((suffix.length() != 0) && numAnagrams > 0) {
      for (int i = 0; i < suffix.length(); i++) {
        char c = suffix.charAt(i);
        String newPrefix = prefix + c;
        String newSuffix = suffix.substring(0, i) + suffix.substring(i + 1);
        generateAnagramsStdio(newPrefix, newSuffix);
      }
    }
  }


  public String[] generateAnagramsArr(String w) {
    isWord(w);
    if (numAnagrams == 0) {
      this.numAnagrams = NumbersUtils.factorial(w.length());
    }
    anagramsArr = new String[numAnagrams];
    System.out.println("Anagrams of " + w + ":");
    generateAnagramsArr("", w);
    return anagramsArr;
  }

  private void generateAnagramsArr(String prefix, String suffix) {
    if ((suffix.length() == 0)) {
      if ((anagramsArr.length - numAnagrams >= 0) && (anagramsArr.length - numAnagrams < anagramsArr.length)) {
        anagramsArr[anagramsArr.length - numAnagrams] = firstCapitalised(prefix);
        numAnagrams--;
      }
    }
    if (suffix.length() != 0) {
      for (int i = 0; i < suffix.length(); i++) {
        char c = suffix.charAt(i);
        String newPrefix = prefix + c;
        String newSuffix = suffix.substring(0, i) + suffix.substring(i + 1);
        generateAnagramsArr(newPrefix, newSuffix);
      }
    }
  }


  public static String firstCapitalised(String word) {
    if (word == null || word.isEmpty()) {
      return word;
    }
    char[] charArray = word.toCharArray();
    charArray[0] = Character.toUpperCase(charArray[0]);
    return new String(charArray);
  }

}