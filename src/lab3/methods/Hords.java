package lab3.methods;

import lab3.equations.EquationInterface;
import lab3.main.Main;

public class Hords implements MethodInterface {
    private EquationInterface equation;

    public Hords (EquationInterface equation) {
        this.equation = equation;
    }

    @Override
    public int solve(double a, double b) {
        double tmp;
        int counter = 0;

        while (Math.abs(equation.solve(a) - equation.solve(b)) > 1.0E-12) {
            tmp = b - (equation.solve(b)*(a - b))/(equation.solve(a) - equation.solve(b));
            b = a;
            a = tmp;
            counter++;
        }

        Main.out.print(String.format("Точка: %e", a));
        return counter;
    }
}
