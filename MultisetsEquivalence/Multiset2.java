public class Multiset2 {
  private double[] elements;

  public Multiset2() {
    elements = new double[0];
  }

  public Multiset2(double[] elements) {
    this.elements = elements;
  }

  public void add(double item) {
    double[] newElements = new double[elements.length + 1];
    System.arraycopy(elements, 0, newElements, 0, elements.length);
    newElements[elements.length] = item;
    elements = newElements;
  }

  public String toString() {
    String string = "Multiset:";
    boolean[] seen = new boolean[elements.length];
    for (int i = 0; i < elements.length; i++) {
      seen[i] = false;
    }
    for (int i = 0; i < elements.length; i++) {
      if(!seen[i]) {
        int howMany = count(elements[i]);
        updateSeen(seen, elements[i]);
        string = string + "\nelement\t" + elements[i] + "\tfrequency:\t" + howMany;
      }
    }
    if (string.equals("Multiset:"))
      return "Empty Multiset";
    return string;
  }
  private int count(double item){
    int counter = 0;
    for (double element : elements) {
      if (element == item)
        counter++;
    }
    return counter;
  }
  private void updateSeen(boolean[] seen, double item){
    for(int i=0; i< seen.length; i++){
      if(elements[i] == item)
        seen[i]=true;
    }
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Multiset2 secondMultiset)) {
      return false;
    }
    if (this.elements.length != secondMultiset.elements.length)
      return false;

    boolean[] seen = new boolean[elements.length];
    for (int i = 0; i < elements.length; i++) {
      seen[i] = false;
    }
    for (int i = 0; i < elements.length; i++) {
      if(!seen[i]) {
        int howMany = count(elements[i]);
        updateSeen(seen, elements[i]);
        if(secondMultiset.count(elements[i]) != howMany)
          return false;
      }
    }
    return true;
  }
}
