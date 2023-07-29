import java.lang.Math;
import java.util.function.Function;

public class mco {
    public static void main(String[] args) {
        // for trigonometric functions inputs are in RADIANS not DEGREES
        Function<Double, Double> f = x-> 2*x*x + 3*x -28;
        Function<Double, Double> test2 = x-> Math.sin(x);
        //Double b = Math.toRadians(178);
        //Double a = Math.toRadians(90);

        Double a = 5.0;
        Double b = 10.0;
        //System.out.println(test2.apply(x));


        int numIntervals = 100;

        double integral = trapezoidalRule(f, a, b, numIntervals);
        System.out.println(integral);
        //System.out.println("Approximate Integral: " + integral);
    }

    private static double trapezoidalRule(Function<Double, Double> f, double a, double b, int numIntervals) {
        double h = (b - a) / numIntervals;
        double sum = 0.5 * (f.apply(a) + f.apply(b)); // no need to 2x the middle portion

        for (int i = 1; i < numIntervals; i++) {
            double x = a + i * h;
            sum += f.apply(x);
        }

        return h * sum;
    }
}
