import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    double[] coefficienti = {2.,3.};
    Polynomial poly = new Polynomial(coefficienti);
    System.out.println(poly.integrate(0.,.001).apply(5.));
    Polynomial polyIntegral = MathUtils.polynomialIntegral(poly);
    System.out.println(polyIntegral.apply(5.));
  }
}