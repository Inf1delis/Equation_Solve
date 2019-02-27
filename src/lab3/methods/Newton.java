package lab3.methods;

import lab3.equations.EquationInterface;
import lab3.main.Main;

public class Newton implements MethodInterface{
    private EquationInterface equation;

    public Newton (EquationInterface equation) {
        this.equation = equation;
    }

    @Override
    public int solve(double from, double to) {
        double b = to;
        double a = b;
        int counter = 0;

        while (Math.abs(equation.solve(b)) > 1.0E-12) {
            a = b;
            b = a - equation.solve(a)/equation.solveDiff(a);

            while (b >= to | b <= from) {
                b = (a+b)*0.5;
            }

            counter++;
        }

        Main.out.print(String.format("Точка: %e", a));
        return counter;
    }
}
