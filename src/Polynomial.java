public class Polynomial implements RealFunction {
  private final double[] coefficients;

  public Polynomial(double[] coefficients) {
    this.coefficients = coefficients;
  }

  @Override
  public Double apply(Double d) {
    int grade = coefficients.length;
    double result = 0.;
    for (int i = 0; i < grade; i++) {
      result += coefficients[i] * Math.pow(d, i);
    }
    return result;
  }

  public double[] getCoefficients() {
    return coefficients;
  }
}
