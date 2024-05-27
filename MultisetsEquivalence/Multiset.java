public class Multiset {
  private double[] elements;
  private int[] frequency;

  public Multiset() {
    elements = new double[0];
    frequency = new int[0];
  }

  public Multiset(double[] bag) {
    elements = new double[0];
    frequency = new int[0];
    for (double item :
            bag) {
      this.add(item);
    }
  }

  public void add(double item) {
    int index = findIndex(item);
    if (!(index == -1)) {
      frequency[index]++;
    } else {
      double[] oldElements = elements;
      int[] oldFrequency = frequency;
      elements = new double[oldElements.length + 1];
      frequency = new int[oldFrequency.length + 1];
      for (int i = 0; i < oldFrequency.length; i++) {
        elements[i] = oldElements[i];
        frequency[i] = oldFrequency[i];
      }
      elements[oldElements.length] = item;
      frequency[oldFrequency.length] = 1;
    }
  }

  private int findIndex(double item) {
    for (int i = 0; i < elements.length; i++) {
      if (elements[i] == item)
        return i;
    }
    return -1;
  }

  @Override
  public String toString() {
    String string = "Multiset:";
    for (int i = 0; i < elements.length; i++) {
      string = string + "\nelement\t" + elements[i] + "\tfrequency:\t" + frequency[i];
    }
    if (string.equals("Multiset:"))
      return "Empty Multiset";
    return string;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Multiset secondMultiset)) {
      return false;
    }
    if (this.elements.length != secondMultiset.elements.length)
      return false;
    for (int index2 = 0; index2 < secondMultiset.frequency.length; index2++) {
      double item = secondMultiset.elements[index2];
      int index1 = findIndex(item);
      if (index1 == -1)
        return false;
      if (!(frequency[index1] == secondMultiset.frequency[index2]))
        return false;
    }
    return true;
  }
}