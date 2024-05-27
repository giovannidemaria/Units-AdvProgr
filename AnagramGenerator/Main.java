import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int numAnagrams = Integer.parseInt(args[0]);
    if (numAnagrams < 0) {
      System.out.println("arg is not a positive number");
      System.exit(-1);
    }
    Scanner keyboard = new Scanner(System.in);
    String word = keyboard.nextLine();
    AnagramGenerator anagramWord = new AnagramGenerator(numAnagrams);
    String[] result = anagramWord.generateAnagramsArr(word);
    for (String w : result) {
      System.out.println(w);
    }
    AnagramGenerator anagramWord2 = new AnagramGenerator(numAnagrams);
    anagramWord2.generateAnagramsStdio(word);
  }
}