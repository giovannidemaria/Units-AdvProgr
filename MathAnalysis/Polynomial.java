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

  @Override
  public RealFunction derivative() {
    double[] coefficients = getCoefficients();
    int grade = coefficients.length;
    double[] coefficientsDerivative = new double[grade - 1];
    for (int i = 0; i < grade - 1; i++) {
      coefficientsDerivative[i] = coefficients[i + 1] * (i + 1);
    }
    return new Polynomial(coefficientsDerivative);
  }

  @Override
  public RealFunction integrate(double x0, double step) {
    double[] coefficients = getCoefficients();
    int grade = coefficients.length;
    double[] coefficientsIntegral = new double[grade + 1];
    for (int i = 1; i < grade + 1; i++) {
      coefficientsIntegral[i] = coefficients[i - 1] / i;
    }

    Polynomial indefiniteIntegral = new Polynomial(coefficientsIntegral);

    double startval = indefiniteIntegral.apply(x0);
    coefficientsIntegral[0] -= startval;
    return new Polynomial(coefficientsIntegral);
  }

  public double[] getCoefficients() {
    return coefficients;
  }
}
