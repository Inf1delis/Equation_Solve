package lab3.methods;

import lab3.equations.EquationInterface;
import lab3.main.Main;


public class Paraboles implements MethodInterface {
    private EquationInterface equation;

    public Paraboles (EquationInterface equation) {
        this.equation = equation;
    }

    @Override
    public int solve(double a, double b) {
        double tmpA = a;
        double tmpB = b;
        double tmpC = (a+b)*0.5;
        int counter = 0;

        while (  Math.abs(equation.solve(tmpC)) > 1.0E-12 ) {
            tmpC = chooseRoot(tmpA, tmpB);
            counter++;

            if ( Math.signum(equation.solve(tmpA)) != Math.signum(equation.solve(tmpC)) ) {
                tmpB = tmpC;
            } else {
                tmpA = tmpC;
            }
        }

        Main.out.print(String.format("Точка: %e", tmpC));

        return counter;
    }

    private double DividedDifference(double[] X, int i, int k) { // k < 2, i = length - 1
        return i == 0 ?
                equation.solve(X[k]) :
                (DividedDifference( X, i-1, k+1) - DividedDifference( X, i-1, k) ) / ( X[k + i] - X[k]);
    }

    private double countA (double a, double b, double c) {
        double[] X = {a,c,b};
        return DividedDifference(X, 2,0);
    }

    private double countB (double a, double b, double c) {
        double[] X = {a,c,b};
        return DividedDifference(X, 1,0) + DividedDifference(X,2,0)*(a-c);
    }

    private double countC (double a, double b, double c) {
        return equation.solve(a);
    }

    private double chooseRoot (double a, double b) {
        double c = (a+b)*0.5;
        double A = countA(a,b,c);
        double B = countB(a,b,c);
        double C = countC(a,b,c);

        double root = a - 2*C/(B + Math.sqrt(B*B - 4*A*C));

        if (root >= a & root <= b) {
            return root;
        } else {
            return a - 2*C/(B - Math.sqrt(B*B - 4*A*C));
        }

    }
}
