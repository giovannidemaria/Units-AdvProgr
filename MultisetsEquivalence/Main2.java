import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) {
    Multiset2 multiset1 = new Multiset2();
    Multiset2 multiset2 = new Multiset2();
    Scanner keyboard = new Scanner(System.in);

    System.out.println("FIRST POINT OF THE EXERCISE\n\n");
    System.out.println("Give me the first list of doubles. When finished, digit 'f' ");
    while (true) {
      String newItem = keyboard.nextLine();
      if (newItem.equals("f"))
        break;
      multiset1.add(Float.parseFloat(newItem));
    }
    System.out.println("Give me the second list of doubles. When finished, digit 'f' ");
    while (true) {
      String newItem = keyboard.nextLine();
      if (newItem.equals("f"))
        break;
      multiset2.add(Float.parseFloat(newItem));
    }
    if (multiset1.equals(multiset2))
      System.out.println("The two multisets are equal");
    else
      System.out.println("The two multisets are NOT equal");

    Multiset2 multiset3 = new Multiset2();
    Multiset2 multiset4 = new Multiset2();
    System.out.println("\n\nSECOND POINT OF THE EXERCISE\n\nGive me the item and the list, separated by a comma. When finished, digit 'f'");
    while (true) {
      String newItemAndList = keyboard.nextLine();
      if (newItemAndList.equals("f"))
        break;
      String newItemAndListTemp = newItemAndList;
      newItemAndList = "";
      for (int i = 0; i < newItemAndListTemp.length(); i++)
        if (!(newItemAndListTemp.charAt(i) == ' '))
          newItemAndList = newItemAndList + newItemAndListTemp.charAt(i);

      float item;
      int list;
      for (int i = 0; i < newItemAndList.length(); i++) {
        if (newItemAndList.charAt(i) == ',') {
          item = Float.parseFloat(newItemAndList.substring(0, i));
          list = Integer.parseInt(newItemAndList.substring(i + 1));
          if (list == 1)
            multiset3.add(item);
          else if (list == 2)
            multiset4.add(item);
          else
            System.exit(-1);
        }
      }
    }
    if (multiset3.equals(multiset4))
      System.out.println("The two multisets are equal");
    else
      System.out.println("The two multisets are NOT equal");

  }
}