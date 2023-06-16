public class MathUtils {
  public static Polynomial polynomialDerivative(Polynomial polynomial) {
    double[] coefficients = polynomial.getCoefficients();
    int grade = coefficients.length;
    double[] coefficientsDerivative = new double[grade - 1];
    for (int i = 0; i < grade - 1; i++) {
      coefficientsDerivative[i] = coefficients[i + 1] * (i + 1);
    }
    return new Polynomial(coefficientsDerivative);
  }

  public static Polynomial polynomialIntegral(Polynomial polynomial) {
    double[] coefficients = polynomial.getCoefficients();
    int grade = coefficients.length;
    double[] coefficientsIntegral = new double[grade + 1];
    coefficientsIntegral[0] = 0.;
    for (int i = 1; i < grade + 1; i++) {
      coefficientsIntegral[i] = coefficients[i - 1] / i;
    }
    return new Polynomial(coefficientsIntegral);
  }

}
