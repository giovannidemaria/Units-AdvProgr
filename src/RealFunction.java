import java.util.function.Function;

@FunctionalInterface
public interface RealFunction extends Function<Double, Double> {
  default RealFunction composeWith(RealFunction other) {
    return x -> other.apply(apply(x));
  }

  default RealFunction integrate(double x0, double step) {
    return x -> {
      double sum = 0;
      for (double xv = x0; xv <= x; xv = xv + step) {
        sum = sum + step * apply(xv);
      }
      return sum;
    };
  }

  default RealFunction derivative() {
    return x -> {
      final double epsilon = 1e-8;
      return (apply(x + epsilon) - apply(x)) / epsilon;
    };
  }
}