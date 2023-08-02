import java.lang.Math;
import java.util.Scanner;
import java.util.function.Function;

public class mco {
    public static void main(String[] args) {
    	
    	// variables
    	double n;
    	double a;
    	double b;
        Scanner scanner = new Scanner(System.in);

        // function definition
        Function<Double, Double> f = x-> x*x;
        //Function<Double, Double> f = x-> (((3*x*x*x)+(2*x*x)+(5*x))/2) + 3*x;
        //Function<Double, Double> f = x-> x*Math.sin(x);
        
    	// read input from user
    	System.out.println("\n  /\n || Input the values for the following:");
    	System.out.print(" ||  a = ");
        a = scanner.nextDouble();
    	System.out.print(" ||  b = ");
        b = scanner.nextDouble();
    	System.out.print(" ||  n = ");
        n = scanner.nextDouble();

        // solve for the approximate integral
        double integral = trapezoidalRule(f, a, b, n);
        System.out.println(" ||\n || Approximate Integral: \n ||  " + integral + "\n  \\");
    }

    private static double trapezoidalRule(Function<Double, Double> f, double a, double b, double n) {
        double h = (b - a) / n;
        double sum = 0.5 * (f.apply(a) + f.apply(b)); // no need to 2x the middle portion

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += f.apply(x);
        }

        return h * sum;
    }
}
